package org.io.hgis.mapgen;

import com.vividsolutions.jts.geom.Envelope;
import uk.ac.ox.map.carto.canvas.DataFrame;
//import uk.ac.ox.map.carto.canvas.DataFrame;
//import uk.ac.ox.map.h5.H5RasterFactory;
//import uk.ac.ox.map.mapgen.MapFactory;

import java.util.List;

/**
 * Used by a {@link MapFactory} to process map requests.
 * 
 * All production and drawing of map layers is conducted by implementations of
 * this.
 * 
 */
public interface MapContext {

  /**
   * The geographical extent of the area of interest, which will be a subset of
   * the map extent, but generally more than the geographical entity.
   * 
   * @return
   */
  Envelope getEnvelope();

  /**
   * The species, region or theme usually drives the filename.
   * 
   * @param prefix
   * @return
   */
  String getFileName(String prefix);

  /**
   * Responsible for drawing all layers on the passed data frame.
   * 
   * @param df
   */
  void drawLayers(DataFrame df, List<H5RasterFactory> rasterFactories);

  /**
   * The map title
   * 
   * @param prefix
   * @return
   */
  String getTitle(String prefix);

  /**
   * The subtitle, usually the name of a geographical entity
   * 
   * @return
   */
  String getSubTitle();

}
