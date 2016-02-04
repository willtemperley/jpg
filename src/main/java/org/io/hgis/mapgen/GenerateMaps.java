package org.io.hgis.mapgen;


import org.com.conflictarm.domain.MaterialType;
import org.gnome.gtk.Gtk;
import org.io.hgis.mapgen.config.*;
import org.io.hgis.mapgen.mapcontext.CustodyChain;
import uk.ac.ox.map.carto.canvas.*;

import javax.persistence.EntityManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.Document;
import uk.ac.ox.map.carto.style.symbolizer.PointSymbolizer;
import uk.ac.ox.map.carto.util.StringUtil;

public class GenerateMaps {

  private static final String pdfOutputDir = "/media/sf_IdeaProjects/CAR";
  private static boolean dummyRun = false;

  static final String DATAFRAME_ONLY = "resources/mapconf_df_only.xml";
  static final String LANDSCAPE = "MapGen/src/main/resources/mapconf_landscape.xml";
  static final String PORTRAIT = "MapGen/src/main/resources/mapconf_portrait.xml";
  static final String PORTRAIT_DISPLAY = "resources/mapconf_portrait_display.xml";
  static final String LANDSCAPE_DISPLAY = "resources/mapconf_landscape_display.xml";

  /**
   * @param args None required
   * @throws Exception TODO document the good things and the bad things
   *                   TODO
   *                   TODO populated places
   *                   TODO
   *                   TODO meshGradients
   *                   TODO
   *                   TODO database of all natural earth stuff
   *                   TODO
   *                   TODO generic data access for base data
   *                   TODO
   */
  public static void main(String[] args) throws Exception {

    Gtk.init(args);

    DocumentBuilder builder;
    builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    String configurationFileName = LANDSCAPE;
    Document doc = builder.parse(configurationFileName);
    MapObjectFactory base = new MapObjectFactory(doc);


    EntityManager em = EMF.get().createEntityManager();

    //FIXME doing this in the mapcontext too

//        DocumentationSites mc= new DocumentationSites(em);
//
//        process(base, mc);

    List<MaterialType> mt = em.createQuery("from MaterialType", MaterialType.class).getResultList();

//        CustodyChain cs = new CustodyChain(em, mt.get(0));
//        process(base, cs);

    for (MaterialType materialType : mt) {

      CustodyChain cs = new CustodyChain(em, materialType);
      process(base, cs);

    }

  }


  public static void process(MapObjectFactory mapObjectFactory, MapContext mapContext) throws IOException {

    System.out.println("Processing");

    /*
     * Create absolute filename
     */
//        String pdfFileName = mapContext.getFileName("test");
    String fn = mapContext.getFileName("");
    File outputFile = new File(pdfOutputDir, fn);

    MapCanvas mc = mapObjectFactory.getCanvas(outputFile.getAbsolutePath());
    DataFrame df = mapObjectFactory.getDataFrame(mapContext.getEnvelope());
    df.setBackgroundColour(org.com.conflictarm.style.Palette.WATER.get());

//    df.setBackgroundColour(Palette.WATER.get());

    if (!dummyRun) {
      mapContext.drawLayers(df, null);
    }

    mc.addDataFrame(df);
    mc.drawDataFrames();

    /*
     * Key
     */
    CustodyChain custodyChain = (CustodyChain) mapContext;
    {
      MapConfigDoc.ConfigNode node = mapObjectFactory.getConfigNode("key");
      Rectangle frame = node.getFrame();
      double fontSize = 15;

      List<MapKeyItem> items = custodyChain.getMapKey();
      MapKey mk = new MapKey(frame, fontSize, "");
      for (MapKeyItem item : items) {
        mk.addItem(item);
      }

      mc.drawKey(mk);
    }
    /*
     * Key
     */
    {
      MapConfigDoc.ConfigNode node = mapObjectFactory.getConfigNode("key2");
      Rectangle frame = node.getFrame();
      double fontSize = 15;
      MapKey mk = new MapKey(frame, fontSize, "");

      List<MapKeyItem> items = custodyChain.getRouteKeyItems();
      for (MapKeyItem item : items) {
        mk.addItem(item);
      }

      mc.drawKey(mk);
//      PointSymbolizer ps = new PointSymbolizer(FillStyleFactory.getDocumentationFillStyle(), 5D);
//      key1(mc, frame, fontSize, ps);
    }


    /*
    * Title
    */
    {
      MapConfigDoc.ConfigNode node = mapObjectFactory.getConfigNode("title");
      if (node != null) {

        String fontSizeAttr = node.getAttribute("fontSize");
        Double fontSize = Double.valueOf(fontSizeAttr);

        String title = mapContext.getTitle("Chains of custody of ");
        mc.setTitle(title, node.getFrame(), fontSize);
      }
    }

//        drawGraphics(mc);
    mc.finish();
  }

  private static void key1(MapCanvas mc, Rectangle frame, double fontSize, PointSymbolizer ps) {
    MapKey mapKey = new MapKey(frame, fontSize, null);
    MapKeyItem mki = new MapKeyItem("IED component documentation sites", ps);
    mapKey.addItem(mki);
    mc.drawKey(mapKey);
  }


}
