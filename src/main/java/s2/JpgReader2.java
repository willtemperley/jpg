package s2;

import org.gdal.gdal.Band;
import org.gdal.gdal.Dataset;
import org.gdal.gdal.gdal;
import org.gdal.gdalconst.gdalconstConstants;
import scala.collection.convert.Wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by willtemperley@gmail.com on 2/12/16.
 */
public class JpgReader2 {

  public static void main(String[] args) throws IOException {


//    System.out.println((10980 * 10980) * 2);

    String jlibPath = System.getProperty("java.library.path");
    System.setProperty("java.library.path", jlibPath + ":/usr/local/lib");

    String pathname = "/tmp/s2.jp2";
    System.loadLibrary("openjp2");

    gdal.AllRegister();


    Dataset hDataset = gdal.Open(pathname, gdalconstConstants.GA_ReadOnly);

    int x = hDataset.getRasterXSize();

    Band rb = hDataset.GetRasterBand(1);

    short[] arr = new short[1000 * 1000];
//    rb.ReadRaster(8000,8000, 1000,1000, arr);


//    hDataset.BuildOverviews()
    int xS = rb.getXSize();
    int yS = rb.getYSize();

    System.out.println(xS);
    System.out.println(yS);
//    System.out.println(x);
//
//    for (short i : arr) {
//      System.out.println(i);
//    }

    System.out.println(hDataset.GetProjection());


  }

}
