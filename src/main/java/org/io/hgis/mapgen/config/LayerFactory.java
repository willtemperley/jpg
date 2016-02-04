package org.io.hgis.mapgen.config;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import org.com.conflictarm.domain.AdminUnit;
import uk.ac.ox.map.carto.util.GeometryUtil;

import java.util.ArrayList;
import java.util.List;

public class LayerFactory {
  

  /**
   * Transforms a list of {@link A0s}s to a list of {@link MultiPolygon}s which are clipped to the {@link Envelope} passed.
   *
   * @param countryUnits
   * @param env
   * @return
   */
  public static List<MultiPolygon> getClippedA0s(List<AdminUnit> countryUnits, Envelope env) {

    List<MultiPolygon> mps = new ArrayList<MultiPolygon>();

    for (AdminUnit adminUnit : countryUnits) {
      MultiPolygon ag = (MultiPolygon) adminUnit.getGeom();
      if (ag != null) {
        Geometry clipped = GeometryUtil.clip(env, ag);
        if (clipped != null  && clipped instanceof MultiPolygon) {
          mps.add((MultiPolygon) clipped);
        }
      }
    }

    return mps;

  }

//  /**
//   * Convenience function to obtain a list of {@link MultiPolygon}s from a list of {@link AdminUnit}
//   *
//   * @param countryUnits the {@link Country}(ies) from which to extract polygons
//   * @return
//   */
//  public static List<MultiPolygon> toMultiPolygons(List<Country> countryUnits) {
//
//    List<MultiPolygon> mps = new ArrayList<MultiPolygon>();
//
//    for (Country adminUnit : countryUnits) {
//      Country ag = adminUnit.getAdminGeom();
//      if (ag != null) {
//        mps.add(ag.getGeom());
//      }
//    }
//
//    return mps;
//  }
  
}