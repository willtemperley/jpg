package org.io.hgis.mapgen;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.MultiPolygon;
import org.issg.ibis.domain.Country;
import uk.ac.ox.map.carto.canvas.DataFrame;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by will on 1/23/16.
 */
public class MC1 implements MapContext {

    private final Country c;
    private final Envelope envelope;
    private EntityManager em;


    @SuppressWarnings("unchecked")
    public List<Country> findByExtent(Envelope env) {

        Query q = em.createNativeQuery(
                "select id, name, isoa2_id, isoa3_id, region_id, geom from administrative_units.country c " +
                        "where c.geom && st_setsrid(st_makebox2d(st_point(:minx, :miny), st_point(:maxx, :maxy)), 4326)", Country.class);
        q.setParameter("minx", env.getMinX());
        q.setParameter("miny", env.getMinY());
        q.setParameter("maxx", env.getMaxX());
        q.setParameter("maxy", env.getMaxY());
        return q.getResultList();
    }

    public MC1(Country c, EntityManager em) {
        this.c = c;
        this.em = em;
        this.envelope = c.getGeom().getEnvelopeInternal();
        envelope.expandBy(2);
    }

    @Override
    public Envelope getEnvelope() {
        return envelope;
    }

    @Override
    public String getFileName(String prefix) {
        return c.getName();
    }

    @Override
    public void drawLayers(DataFrame df, List<H5RasterFactory> rasterFactories) {

        //TODO need to think about this - is there a cleaner way?
        List<Country> countries = findByExtent(df.getEnvelope());
        List<MultiPolygon> base = LayerFactory.getClippedMultiPolygons(countries, df.getEnvelope());
        df.drawFeatures(base, FillStyleFactory.getBaseFillStyle());
    }

    @Override
    public String getTitle(String prefix) {
        return c.getName();
    }

    @Override
    public String getSubTitle() {
        return "Test";
    }
}
