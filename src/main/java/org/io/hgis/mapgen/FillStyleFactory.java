package org.io.hgis.mapgen;

import uk.ac.ox.map.carto.style.*;
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
          Palette.WHITE.get());
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

  private static FillStyle anoPointsFillStyle;

  public static FillStyle getAnoPointFillStyle() {
    if (anoPointsFillStyle == null) {
      return getSimpleFillStyle(Palette.BLACK.get(), defaultLineWidth,
          Palette.BLACK.get(0.5));
    }
    return anoPointsFillStyle;
  }
}
