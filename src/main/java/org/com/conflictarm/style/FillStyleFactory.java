package org.com.conflictarm.style;

import uk.ac.ox.map.carto.style.LineFillLayer;
import uk.ac.ox.map.carto.style.SolidFillLayer;
import uk.ac.ox.map.carto.style.symbolizer.FillStyle;
import uk.ac.ox.map.carto.style.symbolizer.LineStyle;
import uk.ac.ox.map.domain.carto.Colour;

public class FillStyleFactory {

  private static double defaultLineWidth = 0.2;

  public static FillStyle getBaseFillStyle() {
    return getSimpleFillStyle(PaletteCAR.MED_GREY.get(), defaultLineWidth,
        PaletteCAR.MED_GREY.get());
  }

  public static FillStyle getMaskFillStyle() {
    return getSimpleFillStyle(PaletteCAR.MED_GREY.get(), defaultLineWidth,
        PaletteCAR.WHITE.get());
  }

  public static FillStyle getWaterFillStyle() {

      LineStyle outline = new LineStyle(PaletteCAR.WATER.get(), defaultLineWidth);
      FillStyle fs = new FillStyle(outline);
      fs.layers.add(new SolidFillLayer(PaletteCAR.WATER.get()));
      return fs;
  }

  public static FillStyle getSimpleFillStyle(Colour outlineColour,
      double outlineWidth, Colour fillColour) {

    LineStyle outline = new LineStyle(outlineColour, outlineWidth);
    FillStyle fs = new FillStyle(outline);
    fs.layers.add(new SolidFillLayer(fillColour));

    return fs;
  }

  private static FillStyle duffyFillStyle;

  public static FillStyle getDuffyFillStyle() {

    if (duffyFillStyle == null) {

      LineStyle outline = new LineStyle(PaletteCAR.WHITE.get(0), 0);
      FillStyle fs = new FillStyle(outline);

      // Blue
      fs.layers.add(new LineFillLayer(25, 12, 0, new LineStyle(new Colour(
          "#6B7EAE", 1), 2)));
      // Grey
      fs.layers.add(new LineFillLayer(45, 12, 4, new LineStyle(new Colour(
          "#D2D2D2", 1), 4)));

      return fs;
    }
    return duffyFillStyle;
  }


  public static FillStyle getDocumentationFillStyle() {
      return getSimpleFillStyle(PaletteCAR.BLACK.get(), defaultLineWidth,
          PaletteCAR.RED.get());
  }


  public static FillStyle getSourceFillStyle() {
      return getSimpleFillStyle(PaletteCAR.BLACK.get(), defaultLineWidth,
              PaletteCAR.TEAL_BLUE.get());
  }

  public static FillStyle getIntermediary() {
      return getSimpleFillStyle(PaletteCAR.BLACK.get(), defaultLineWidth,
              PaletteCAR.MED_LIGHT_GREY.get());
  }

  public static FillStyle getCapture() {
    return getSimpleFillStyle(PaletteCAR.WHITE.get(), defaultLineWidth,
            PaletteCAR.BLACK.get());
  }
}
