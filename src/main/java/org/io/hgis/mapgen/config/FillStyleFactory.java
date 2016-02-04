package org.io.hgis.mapgen.config;

import uk.ac.ox.map.carto.style.*;
import uk.ac.ox.map.carto.style.symbolizer.FillStyle;
import uk.ac.ox.map.carto.style.symbolizer.LineStyle;
import uk.ac.ox.map.domain.carto.Colour;

public class FillStyleFactory {

  private static double defaultLineWidth = 0.2;

  private static FillStyle waterFillStyle;

  public static FillStyle getWaterFillStyle() {
    if (waterFillStyle == null) {
      LineStyle outline = new LineStyle(Palette.WATER.get(), defaultLineWidth);
      FillStyle fs = new FillStyle(outline);
      fs.layers.add(new SolidFillLayer(Palette.WATER.get()));
      return fs;
    }
    return waterFillStyle;
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

      LineStyle outline = new LineStyle(Palette.WHITE.get(0), 0);
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

  private static FillStyle maskFillStyle;

  public static FillStyle getMaskFillStyle() {
    if (maskFillStyle == null) {
      return getSimpleFillStyle(Palette.GREY_60.get(), defaultLineWidth,
          Palette.WHITE.get());
    }
    return maskFillStyle;
  }

  private static FillStyle baseFillStyle;

  public static FillStyle getBaseFillStyle() {
    if (baseFillStyle == null) {
      return getSimpleFillStyle(Palette.GREY_60.get(), defaultLineWidth,
          Palette.GREY_20.get());
    }
    return baseFillStyle;
  }

  private static FillStyle borderFillStyle;

  public static FillStyle getBorderFillStyle() {
    if (borderFillStyle == null) {

      return getSimpleFillStyle(Palette.GREY_60.get(), defaultLineWidth,
          Palette.WHITE.get(0));
    }
    return borderFillStyle;
  }

  private static FillStyle anoMaskFillStyle;

  public static FillStyle getAnoMaskFillStyle() {
    if (anoMaskFillStyle == null) {
      Colour blueColour = new Colour(0.270588, 0.462745, 0.694117, 1);
      return getSimpleFillStyle(blueColour, defaultLineWidth, blueColour);
    }
    return anoMaskFillStyle;
  }


  public static FillStyle getDocumentationFillStyle() {
      return getSimpleFillStyle(Palette.GREY_60.get(), defaultLineWidth,
          Palette.TUSCAN_RED.get());
  }


  public static FillStyle getSourceFillStyle() {
      return getSimpleFillStyle(Palette.GREY_60.get(), defaultLineWidth,
              Palette.FERN.get());
  }

  public static FillStyle getIntermediary() {
      return getSimpleFillStyle(Palette.GREY_60.get(), defaultLineWidth,
              Palette.AUTUNITE_YELLOW.get());
  }

  public static FillStyle getCapture() {
    return getSimpleFillStyle(Palette.GREY_60.get(), defaultLineWidth,
            Palette.ULTRA_BLUE.get());
  }
}
