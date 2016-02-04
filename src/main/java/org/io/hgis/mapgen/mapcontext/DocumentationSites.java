package org.io.hgis.mapgen.mapcontext;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import org.com.conflictarm.domain.Admin0;
import org.com.conflictarm.domain.AdminUnit;
import org.com.conflictarm.domain.Waypoint;
import org.io.hgis.mapgen.config.FillStyleFactory;
import org.io.hgis.mapgen.config.H5RasterFactory;
import org.io.hgis.mapgen.config.LayerFactory;
import org.io.hgis.mapgen.config.MapContext;
import uk.ac.ox.map.carto.canvas.DataFrame;
import uk.ac.ox.map.carto.style.symbolizer.FillStyle;
import uk.ac.ox.map.carto.style.symbolizer.PointSymbolizer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Sites where IEDs have been documented
 *
 * Created by will on 1/23/16.
 */
public class DocumentationSites extends MapContext {

    private final Envelope envelope;
    private EntityManager em;
    private final List<Waypoint> waypoints;


//    @SuppressWarnings("unchecked")
//    public List<Country> findByExtent(Envelope env) {
//
//        Query q = em.createNativeQuery(
//                "select id, name, isoa2_id, isoa3_id, region_id, geom from administrative_units.country c " +
//                        "where c.geom && st_setsrid(st_makebox2d(st_point(:minx, :miny), st_point(:maxx, :maxy)), 4326)", Country.class);
//        q.setParameter("minx", env.getMinX());
//        q.setParameter("miny", env.getMinY());
//        q.setParameter("maxx", env.getMaxX());
//        q.setParameter("maxy", env.getMaxY());
//        return q.getResultList();
//    }

    @SuppressWarnings("unchecked")
    public List<AdminUnit> findA0ByExtent(Envelope env) {

        Query q = em.createNativeQuery(
                "select id, name, iso_a2, iso_a3, geom from ne.ne_110m_admin_0_countries c " +
                        "where c.geom && st_setsrid(st_makebox2d(st_point(:minx, :miny), st_point(:maxx, :maxy)), 4326)", Admin0.class);
        q.setParameter("minx", env.getMinX());
        q.setParameter("miny", env.getMinY());
        q.setParameter("maxx", env.getMaxX());
        q.setParameter("maxy", env.getMaxY());
        return q.getResultList();
    }

    public DocumentationSites(EntityManager em) {
        super(em);
        this.em = em;

        waypoints = getWaypoints();
        this.envelope = new Envelope();
        for (Waypoint waypoint : waypoints) {
            Coordinate coordinate = waypoint.geom.getCoordinate();
            envelope.expandToInclude(coordinate);
        }

        envelope.expandBy(1.5);
    }

    @Override
    public Envelope getEnvelope() {
        return envelope;
    }

    @Override
    public String getFileName(String prefix) {
        return "documentation_sites.pdf";
    }

    @Override
    public void drawLayers(DataFrame df, List<H5RasterFactory> rasterFactories) {

        //TODO need to think about this - is there a cleaner way?
        List<AdminUnit> countries = findA0ByExtent(df.getEnvelope());

        //fixme duplication, do in DB?
        List<MultiPolygon> base = LayerFactory.getClippedA0s(countries, df.getEnvelope());
        df.drawFeatures(base, FillStyleFactory.getBaseFillStyle());

        FillStyle fs = FillStyleFactory.getDocumentationFillStyle();
        PointSymbolizer pointSymbolizer = new PointSymbolizer(fs, 5d);

        for (Waypoint waypoint : waypoints) {
            Geometry geom = waypoint.geom;
            Coordinate coord = geom.getCoordinate();
            df.drawPoint(coord.x, coord.y, pointSymbolizer);
            df.drawPoint(coord.x, coord.y, pointSymbolizer);
        }
    }

    private List<Waypoint> getWaypoints() {
        TypedQuery<Waypoint> q = em.createQuery("select w from Waypoint w where w.waypointType = 'document'", Waypoint.class);
        return q.getResultList();
    }

    @Override
    public String getTitle(String prefix) {
        return "test title";
    }

    @Override
    public String getSubTitle() {
        return "Test";
    }
}
