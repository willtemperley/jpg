package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QLocation is a Querydsl query type for Location
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLocation extends EntityPathBase<Location> {

    private static final long serialVersionUID = 1949877818L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocation location = new QLocation("location");

    public final NumberPath<Double> area = createNumber("area", Double.class);

    public final ComparablePath<com.vividsolutions.jts.geom.Point> centroid = createComparable("centroid", com.vividsolutions.jts.geom.Point.class);

    public final StringPath comments = createString("comments");

    public final QCountry country;

    public final QDesignatedAreaType designatedAreaType;

    public final StringPath designation = createString("designation");

    public final ComparablePath<com.vividsolutions.jts.geom.Polygon> envelope = createComparable("envelope", com.vividsolutions.jts.geom.Polygon.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifier = createString("identifier");

    public final StringPath islandGroup = createString("islandGroup");

    public final QIslandType islandType;

    public final StringPath iucnCat = createString("iucnCat");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final ListPath<LocationSummary, QLocationSummary> locationSummaries = this.<LocationSummary, QLocationSummary>createList("locationSummaries", LocationSummary.class, QLocationSummary.class, PathInits.DIRECT2);

    public final QLocationType locationType;

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath name = createString("name");

    public final StringPath prefix = createString("prefix");

    public final StringPath url = createString("url");

    public QLocation(String variable) {
        this(Location.class, forVariable(variable), INITS);
    }

    public QLocation(Path<? extends Location> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLocation(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLocation(PathMetadata<?> metadata, PathInits inits) {
        this(Location.class, metadata, inits);
    }

    public QLocation(Class<? extends Location> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.country = inits.isInitialized("country") ? new QCountry(forProperty("country"), inits.get("country")) : null;
        this.designatedAreaType = inits.isInitialized("designatedAreaType") ? new QDesignatedAreaType(forProperty("designatedAreaType")) : null;
        this.islandType = inits.isInitialized("islandType") ? new QIslandType(forProperty("islandType")) : null;
        this.locationType = inits.isInitialized("locationType") ? new QLocationType(forProperty("locationType")) : null;
    }

}

