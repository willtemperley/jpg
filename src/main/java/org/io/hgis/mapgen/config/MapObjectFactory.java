package org.io.hgis.mapgen.config;

import com.vividsolutions.jts.geom.Envelope;
import org.com.conflictarm.style.PaletteCAR;
import org.freedesktop.cairo.PdfSurface;
import org.gnome.gdk.Pixbuf;
import org.gnome.rsvg.Handle;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import uk.ac.ox.map.carto.canvas.DataFrame;
import uk.ac.ox.map.carto.canvas.MapCanvas;
import uk.ac.ox.map.carto.canvas.Rectangle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by will on 1/23/16.
 */
public class MapObjectFactory extends MapConfigDoc {

    public MapObjectFactory(Document doc) {
        super(doc);
    }

//  public static ContinuousScale buildColourScale(ColourMap cm) {
//
//    ContinuousScale cs = new ContinuousScale();
//
//    for (ColourMapEntry m : cm.getColourMapEntries()) {
//      String colourString = m.getColour();
//      boolean ignoreRgb = false;
//      Colour c;
//      if (colourString == null) {
//        ignoreRgb = true;
//        c = new Colour("#000000", 1);
//      } else {
//        c = new Colour(colourString, m.getOpacity());
//      }
//      cs.addColorStopRGB(m.getLabel(), m.getQuantity(), c, ignoreRgb);
//    }
//
//    cs.finish();
//    return cs;
//  }

  /**
   * Draws all static graphics specified in configuration file
   *
   * @param mc
   * @throws FileNotFoundException
   */
  protected void drawGraphics(MapCanvas mc) throws FileNotFoundException {
    String xpathExpression = "/mapconf/graphic";
    List<Node> nodes = getNodeList(xpathExpression);
    for (Node node : nodes) {

      ConfigNode cn = new ConfigNode(node);

      String type = cn.getAttribute("type");
      String fileName = cn.getAttribute("source");
      Rectangle rect = cn.getFrame();

      if (type.equals("image/svg+xml")) {
        Handle svgH = new Handle(fileName);
        mc.drawSVG(rect, svgH);
      } else if (type.equals("image/png")) {
        Pixbuf pbLogo = new Pixbuf(fileName);
        mc.drawImage(rect, pbLogo);
      } else {
        throw new RuntimeException("Unsupported image type.");
      }
    }
  }

  public MapCanvas getCanvas(String fileName) throws IOException {

    Node n = getNode("/mapconf");
    ConfigNode node = new ConfigNode(n);

    double width = Double.parseDouble(node.getAttribute("width"));
    double height = Double.parseDouble(node.getAttribute("height"));

    MapCanvas mc = new MapCanvas(new PdfSurface(fileName, width, height),
        width, height);
    return mc;
  }

  public DataFrame getDataFrame(Envelope env) throws IOException {

    /*
     * Main dataframe
     */
    ConfigNode node = getConfigNode("dataframe");

    Rectangle rect = node.getFrame();

    DataFrame.Builder dfBuilder = new DataFrame.Builder(env, rect, null)
        .backgroundColour(PaletteCAR.WATER.get());

    String hasGridStr = node.getAttribute("hasGrid");
    if (hasGridStr != null) {
      boolean hasGrid = Boolean.valueOf(hasGridStr);
      dfBuilder.hasGrid(hasGrid);
    }

    String hasBorderStr = node.getAttribute("hasBorder");
    if (hasBorderStr != null) {
      boolean hasBorder = Boolean.valueOf(hasBorderStr);
      dfBuilder.hasBorder(hasBorder);
    }

    return dfBuilder.build();
  }

  protected String getLegend() {
    return "FIXME";
//    StringBuilder sb = new StringBuilder();
//
//    List<MapTypeLegendEntry> mtles = mapType.getMapTypeLegendEntries();
//    for (MapTypeLegendEntry mapTypeLegendEntry : mtles) {
//      LegendEntry legendEntry = mapTypeLegendEntry.getLegendEntry();
//      String text = legendEntry.getText();
//      sb.append(text);
//      sb.append("<br>");
//    }
//    return sb.toString();
  }

  public ConfigNode getConfigNode(String nodeName) {
    return  super.getConfigNode(nodeName);
  }

}
