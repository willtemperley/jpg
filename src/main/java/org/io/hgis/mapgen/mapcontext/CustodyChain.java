package org.io.hgis.mapgen.mapcontext;

import com.google.common.base.Joiner;
import com.vividsolutions.jts.geom.*;
import org.com.conflictarm.domain.*;
import org.com.conflictarm.style.FillStyleFactory;
import org.com.conflictarm.style.PaletteCAR;
import org.io.hgis.mapgen.config.H5RasterFactory;
import org.io.hgis.mapgen.config.MapContext;
import uk.ac.ox.map.carto.canvas.DataFrame;
import uk.ac.ox.map.carto.canvas.MapKeyItem;
import uk.ac.ox.map.carto.style.Palette;
import uk.ac.ox.map.carto.style.symbolizer.FillStyle;
import uk.ac.ox.map.carto.style.symbolizer.LineStyle;
import uk.ac.ox.map.carto.style.symbolizer.PointSymbolizer;
import uk.ac.ox.map.domain.carto.Colour;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 * Sites where IEDs have been documented
 *
 * Created by will on 1/23/16.
 */
public class CustodyChain extends MapContext {

  private final Envelope envelope;
  private final List<Waypoint> waypoints;
  private final MaterialType materialType;
  private final List<Route> routes;

  public GeometryFactory gf = new GeometryFactory();
  private final Map<Integer, String> routeNames;
  private final HashSet<String> distinctRoutes;
  private final Set<Integer> countriesInvolved;

  public List<MapKeyItem> getRouteKeyItems() {
    return routeKeyItems;
  }

  private final List<MapKeyItem> routeKeyItems;
  //Map 4 Chains of custody of aluminium paste, ammonium nitrate, and urea used by IS forces
//Map 5 Chain of custody of hydrogen peroxide and white petroleum drums used by IS forces
//Map 6 Chains of custody of detonating cord and safety fuse used by IS forces
//Map 7 Chains of custody of detonators used by IS forces
//Map 8 Chain of custody of wires and cables used by IS forces
//Map 9 Chains of custody of electronic components used by IS forces
//Map 10 Chains of custody of mobile telephones used by IS forces

  public CustodyChain(EntityManager em, MaterialType matId) {
    super(em);

    countriesInvolved = new HashSet<Integer>();

    routes = em.createQuery("select r from Route r " +
        "where r.materialType.id = :id", Route.class).setParameter("id", matId.getId())
        .getResultList();

    routeNames = new HashMap<Integer, String>();
    distinctRoutes = new HashSet<String>();
    for (Route route : routes) {
      List<String> countries = new ArrayList<String>();
      countries.add(route.getManufacturerCountry());
      countriesInvolved.add(route.getCountryId());

      for (Waypoint waypoint : getWaypoints(route)) {
        if (!countries.get(countries.size() - 1).equals(waypoint.country)) {
          countries.add(waypoint.country);
          countriesInvolved.add(waypoint.getCountryId());
        }
      }
      String countryList = Joiner.on('-').join(countries);
      routeNames.put(route.getId(), countryList);
      distinctRoutes.add(countryList);
    }

    routeKeyItems = new ArrayList<MapKeyItem>();
    List<Colour> colours = getColours();
    int i = 0;
    for (String distinctRoute : distinctRoutes) {
      LineStyle ls = new LineStyle(colours.get(i), 2);
      routeKeyItems.add(new MapKeyItem(distinctRoute, ls));
      i++;
    }


    this.materialType = matId;

    //FIXME must be a quicker way
    waypoints = new ArrayList<Waypoint>();

    for (Route route : routes) {
      List<Waypoint> wps = getWaypoints(route);
      for (Waypoint waypoint : wps) {
        waypoints.add(waypoint);
      }
    }

    this.envelope = new Envelope();
    for (Waypoint waypoint : waypoints) {
      Coordinate coordinate = waypoint.geom.getCoordinate();
      envelope.expandToInclude(coordinate);
    }

    for (Route route : routes) {
      if (route.getGeom() == null) continue;
      Coordinate coordinate = route.getGeom().getCoordinate();
      envelope.expandToInclude(coordinate);
    }

    envelope.expandBy(1.5);
  }

  private List<Waypoint> getWaypoints(Route r) {
    TypedQuery<Waypoint> q = em.createQuery("select w from Waypoint w where w.route.id = :id order by w.chainPosition", Waypoint.class)
        .setParameter("id", r.getId());
    return q.getResultList();
  }

  public Envelope getEnvelope() {
    return envelope;
  }

  public String getFileName(String prefix) {
    return prefix + materialType.getName().replace('/', '-') + ".pdf";
  }

  public List<MapKeyItem> getMapKey() {
    List<MapKeyItem> mapKeyItems = new ArrayList<MapKeyItem>();

    Map<String, PointSymbolizer> pointSymbolizers = getPointSymbolizers();
    {
      MapKeyItem mapKeyItem = new MapKeyItem("Source", pointSymbolizers.get("source"));
      mapKeyItems.add(mapKeyItem);
    }
    {
      MapKeyItem mapKeyItem = new MapKeyItem("Intermediary", pointSymbolizers.get("intermediary"));
      mapKeyItems.add(mapKeyItem);
    }
    {
      MapKeyItem mapKeyItem = new MapKeyItem("Location captured", pointSymbolizers.get("capture"));
      mapKeyItems.add(mapKeyItem);
    }
    {
      MapKeyItem mapKeyItem = new MapKeyItem("Location documentated", pointSymbolizers.get("document"));
      mapKeyItems.add(mapKeyItem);
    }

//    LineStyle lineStyle = new LineStyle(PaletteCAR.AUTUNITE_YELLOW.get(), 0.2);
//    MapKeyItem mapKeyItem = new MapKeyItem("test", lineStyle);

    return mapKeyItems;

  }

  public List<Colour> getColours() {
    List<Colour> colours = new ArrayList<Colour>();
    colours.add(PaletteCAR.RED.get());
    colours.add(PaletteCAR.TEAL_BLUE.get());
    colours.add(Palette.GRID.get());
    colours.add(PaletteCAR.BLACK.get());
    colours.add(Palette.ORANGE_DARK.get());
    colours.add(Palette.MACAW_GREEN.get());
    return colours;
  }

  private Map<String, PointSymbolizer> getPointSymbolizers() {
    //TODO make the key drive the map,
    // i.e. generate the key, use it to style the map
    Map<String, PointSymbolizer> symbolizerMap = new HashMap<String, PointSymbolizer>(5);
    PointSymbolizer s1 = new PointSymbolizer(FillStyleFactory.getSourceFillStyle(), 5d);
    PointSymbolizer s2 = new PointSymbolizer(FillStyleFactory.getIntermediary(), 5d);
    PointSymbolizer s3 = new PointSymbolizer(FillStyleFactory.getCapture(), 5d);
    PointSymbolizer s4 = new PointSymbolizer(FillStyleFactory.getDocumentationFillStyle(), 5d);

    symbolizerMap.put("source", s1);
    symbolizerMap.put("intermediary", s2);
    symbolizerMap.put("capture", s3);
    symbolizerMap.put("document", s4);
    return symbolizerMap;
  }


  public void drawLayers(DataFrame df, List<H5RasterFactory> rasterFactories) {

    //TODO need to think about this - is there a cleaner way?
    Envelope envelope = df.getEnvelope();

    List<AdminUnit> countries = findA0ByExtent(envelope);
//    List<MultiPolygon> multiPolygons = getA0byEnv(envelope);
    FillStyle maskFillStyle = FillStyleFactory.getMaskFillStyle();
    FillStyle otherFillStyle = FillStyleFactory.getBaseFillStyle();
    for (AdminUnit country : countries) {
      if (countriesInvolved.contains(country.getId().intValue())) {
        df.drawMultiPolygon((MultiPolygon) country.getGeom(), otherFillStyle);
      } else {
        df.drawMultiPolygon((MultiPolygon) country.getGeom(), maskFillStyle);
      }
    }


//    df.drawFeatures(multiPolygons, FillStyleFactory.getBaseFillStyle());

    Map<String, PointSymbolizer> ps = getPointSymbolizers();

    for (Route route : routes) {

      Geometry prevGeom = route.getGeom();
      if (prevGeom == null) continue;

//      Coordinate startCoord = prevGeom.getCoordinate();
//      df.drawPoint(startCoord.x, startCoord.y, ps.get("source"));

      //todo, Horrible search!
      LineStyle redLine = null;
      for (MapKeyItem mapKeyItem : getRouteKeyItems()) {
        String routeName = routeNames.get(route.getId());
        if (mapKeyItem.description.equals(routeName)) {
          redLine = (LineStyle) mapKeyItem.getSymbolizer();
        }
      }

      if (redLine == null) {
        System.out.println("Null: " +routeNames.get(route.getId()));
      }

      for (Waypoint waypoint : getWaypoints(route)) {

        Geometry geom = waypoint.geom;

        if (prevGeom.equals(geom)) {
          //Happens when e.g. capture and documentation are the same.
          continue;
        }

        Coordinate coord = geom.getCoordinate();

        Coordinate[] arr = new Coordinate[2];

        //This changes the direction of the linestring to prevent overlaps with dashes
        arr[0] = prevGeom.getCoordinate();
        arr[1] = coord;


        LineString ls = gf.createLineString(arr);

        if (waypoint.transferType.contains("Solid")) {
          redLine.setDashes(new double[]{});
        } else {
          redLine.setDashes(new double[]{5.0});
        }

//        df.drawLineString(ls, redLine);
        df.drawCurve(ls, redLine);

        prevGeom = geom;
      }
    }

    for (Route route : routes) {
      Geometry prevGeom = route.getGeom();
      if (prevGeom == null) {
        continue;
      }
      Coordinate startCoord = prevGeom.getCoordinate();
      df.drawPoint(startCoord.x, startCoord.y, ps.get("source"));

      for (Waypoint waypoint : getWaypoints(route)) {

        Geometry geom = waypoint.geom;
        Coordinate coord = geom.getCoordinate();


        PointSymbolizer symbolizer = ps.get(waypoint.waypointType);
        if (symbolizer == null) {
          System.out.println(waypoint.waypointType);
        } else {
          df.drawPoint(coord.x, coord.y, symbolizer);
        }
      }
    }
  }


  public String getTitle(String prefix) {
    return prefix + materialType.getName();
  }

  public String getSubTitle() {
    return "Test";
  }
}
