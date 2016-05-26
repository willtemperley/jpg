package carto

import java.awt.geom.Point2D

import org.geotools.coverage.grid.GridCoverage2D
import org.geotools.gce.geotiff.GeoTiffReader
import org.io.hgis.mapgen.img.SimpleRasterLayer
import uk.ac.ox.map.imageio.RasterLayer

/**
  * Created by willtemperley@gmail.com on 2/7/16.
  */
object TestIO {


  def main(args: Array[String]) {

    getRasterLayer

  }
  def getRasterLayer: RasterLayer = {

    val gt = new GeoTiffReader()
    val OUTPUT_DIR = "/tmp/"
    val gc2d: GridCoverage2D = gt.read(OUTPUT_DIR + "GRAY_50M_SR/GRAY_50M_SR.tif", null)

    val im = gc2d.getRenderedImage


    val data = im.getData

    val db = data.getDataBuffer
    //    db.getElem()


    val cellSize =  360D / im.getWidth
    return null;
//    return new SimpleRasterLayer(new Point2D.Double(-180d, 90d), cellSize, null)

  }

}
