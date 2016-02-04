package org.io.hgis.mapgen.config;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.MultiPolygon;
import org.com.conflictarm.domain.Admin0;
import org.com.conflictarm.domain.AdminUnit;
import uk.ac.ox.map.carto.canvas.DataFrame;
//import uk.ac.ox.map.carto.canvas.DataFrame;
//import uk.ac.ox.map.h5.H5RasterFactory;
//import uk.ac.ox.map.mapgen.MapFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Used by a {@link MapFactory} to process map requests.
 * 
 * All production and drawing of map layers is conducted by implementations of
 * this.
 * 
 */
public abstract class MapContext {

  protected EntityManager em;

  public MapContext(EntityManager em) {
    this.em = em;
  }

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

  /**
   * The geographical extent of the area of interest, which will be a subset of
   * the map extent, but generally more than the geographical entity.
   * 
   * @return
   */
  public abstract Envelope getEnvelope();

  /**
   * The species, region or theme usually drives the filename.
   * 
   * @param prefix
   * @return
   */
  public abstract String getFileName(String prefix);

  /**
   * Responsible for drawing all layers on the passed data frame.
   * 
   * @param df
   */
  public abstract void drawLayers(DataFrame df, List<H5RasterFactory> rasterFactories);

  protected List<MultiPolygon> getA0byEnv(Envelope envelope) {
      List<AdminUnit> countries = findA0ByExtent(envelope);
      //fixme duplication, do clipping in DB?
      return LayerFactory.getClippedA0s(countries, envelope);
  }

  /**
   * The map title
   * 
   * @param prefix
   * @return
   */
  public abstract String getTitle(String prefix);

  /**
   * The subtitle, usually the name of a geographical entity
   * 
   * @return
   */
  public abstract String getSubTitle();

}
