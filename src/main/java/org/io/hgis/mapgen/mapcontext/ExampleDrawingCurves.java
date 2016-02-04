/*
 * java-gnome, a UI library for writing GTK and GNOME programs from Java!
 *
 * Copyright © 2007-2016 Operational Dynamics Consulting, Pty Ltd and Others
 *
 * The code in this file, and the program it is a part of, is made available
 * to you by its authors as open source software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License version
 * 2 ("GPL") as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GPL for more details.
 *
 * You should have received a copy of the GPL along with this program. If not,
 * see http://www.gnu.org/licenses/. The authors of this program may be
 * contacted through http://java-gnome.sourceforge.net/.
 */
package org.io.hgis.mapgen.mapcontext;

import com.vividsolutions.jts.geom.Envelope;
import org.com.conflictarm.domain.MaterialType;
import org.com.conflictarm.style.Palette;
import org.freedesktop.cairo.Context;
import org.freedesktop.cairo.Pattern;
import org.gnome.gdk.Event;
import org.gnome.gtk.DrawingArea;
import org.gnome.gtk.Gtk;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import org.io.hgis.mapgen.config.EMF;
import uk.ac.ox.map.carto.canvas.DataFrame;
import uk.ac.ox.map.carto.canvas.Rectangle;

import javax.persistence.EntityManager;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.List;

/**
 * @author Will Temperley
 *         <p/>
 *         The curve_to example from:
 *         http://cairographics.org/samples/curve_to/
 *         <p/>
 *         The red lines demonstrate the relationship between the
 *         start and end points of the curve and the control points.
 *         <p/>
 *         In depth discussion of the maths here:
 *         http://pomax.github.io/bezierinfo/
 */
public class ExampleDrawingCurves {

  public static void main(String[] args) {
    final Window w;
    final DrawingArea d;

    Gtk.init(args);

    w = new Window();
    w.setTitle("Drawing");
    w.setDefaultSize(700, 400);

    long startTime = System.nanoTime();

    final EntityManager em = EMF.get().createEntityManager();

    long endTime = System.nanoTime();

    System.out.println("Time=" + ((double)(endTime - startTime) / 1000000000));

    d = new DrawingArea();
    w.add(d);
    w.showAll();

    d.connect(new Widget.Draw() {
      public boolean onDraw(Widget source, Context cr) {
        final Pattern linear, radial;

        List<MaterialType> mt = em.createQuery("from MaterialType", MaterialType.class).getResultList();


        CustodyChain cs = new CustodyChain(em, mt.get(0));

        Rectangle rect = new Rectangle(10, 10, 600, 300);

        DataFrame.Builder dfBuilder = new DataFrame.Builder(cs.getEnvelope(), rect, "/tmp/tmp-surface.pdf")
            .backgroundColour(Palette.WATER.get());

        DataFrame df = null;
        try {
          df = new DataFrame(dfBuilder);
        } catch (IOException e) {
          e.printStackTrace();
        }
        cs.drawLayers(df, null);

        Point2D.Double origin = df.getOrigin();
        cr.setSource(df.getSurface(), origin.x, origin.y);
        cr.paint();

        // Free resources used by dataframe.
        df.finish();
                /*
                 * Draw a bézier curve.
                 */

        return true;
      }
    });

        /*
         * And that's it. Conclude with connecting the usual tear-down
         * handler, and then fire up the main loop.
         */

    w.connect(new Window.DeleteEvent() {
      public boolean onDeleteEvent(Widget source, Event event) {
        Gtk.mainQuit();
        return false;
      }
    });

    Gtk.main();
  }
}
