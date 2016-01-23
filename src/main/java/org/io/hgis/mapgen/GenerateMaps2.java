package org.io.hgis.mapgen;


import com.vividsolutions.jts.geom.Envelope;
import org.gnome.gtk.Gtk;
import org.issg.ibis.domain.Country;
import uk.ac.ox.map.carto.canvas.DataFrame;
import uk.ac.ox.map.carto.canvas.MapCanvas;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.w3c.dom.Document;
import uk.ac.ox.map.carto.style.Palette;

public class GenerateMaps2 {

    static EntityManager em = EMF.get().createEntityManager();
    private static final String pdfOutputDir = "/tmp";

    static final String DATAFRAME_ONLY    = "resources/mapconf_df_only.xml";
    static final String LANDSCAPE         = "resources/mapconf_landscape.xml";
    static final String PORTRAIT          = "src/main/resources/mapconf_portrait.xml";
    static final String PORTRAIT_DISPLAY  = "resources/mapconf_portrait_display.xml";
    static final String LANDSCAPE_DISPLAY = "resources/mapconf_landscape_display.xml";

    /**
     * @param args None required
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Gtk.init(args);

        DocumentBuilder builder;
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        String configurationFileName = PORTRAIT;
        Document doc = builder.parse(configurationFileName);
        MapObjectFactory base = new MapObjectFactory(doc);


        Country syria = em.find(Country.class, 760L);
//        List<Country> results = em.createQuery("from Country", Country.class).getResultList();
//        for(Country country: results) {

        Envelope env = syria.getGeom().getEnvelopeInternal();
        //FIXME doing this in the mapcontext too
        env.expandBy(2);

        MapContext mc= new MC1(syria, em);

         process(base, mc);

    }


    public static void process(MapObjectFactory mapObjectFactory, MapContext mapContext) throws IOException {

        System.out.println("Processing");

    /*
     * Create absolute filename
     */
//        String pdfFileName = mapContext.getFileName("test");
        File outputFile = new File(pdfOutputDir, "test.pdf");

        MapCanvas mc = mapObjectFactory.getCanvas(outputFile.getAbsolutePath());

        DataFrame df = mapObjectFactory.getDataFrame(mapContext.getEnvelope());
        df.setBackgroundColour(Palette.WATER.get());
//        if (!dummyRun) {
        mapContext.drawLayers(df, null);
//        }

        mc.addDataFrame(df);
        mc.drawDataFrames();

//        drawGraphics(mc);
        mc.finish();
    }


}
