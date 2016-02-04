package org.com.conflictarm.style;

import uk.ac.ox.map.domain.carto.Colour;

public enum PaletteCAR {

  WATER("#E6E7E8"),
  WHITE("#FFFFFF"),

  BLACK("#000000"),
  RED("#E22E25"),
  LIGHT_GREY("#E5E7E8"),
  MED_LIGHT_GREY("#E6E7E8"),
  MED_GREY("#AEB1B2"),
  GREY_4("#D3D5D6"),
  TEAL_BLUE("#377772"),
  AUTUNITE_YELLOW("#FFFF73");

  private String hexColour;

  PaletteCAR(String hexColour) {
    this.hexColour = hexColour;
  }

  public Colour get() {
    return new Colour(hexColour, 1);
  }

  public Colour get(double a) {
    return new Colour(hexColour, a);
  }

}
