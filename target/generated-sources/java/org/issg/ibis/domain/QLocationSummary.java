package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QLocationSummary is a Querydsl query type for LocationSummary
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLocationSummary extends EntityPathBase<LocationSummary> {

    private static final long serialVersionUID = -2097159156L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocationSummary locationSummary = new QLocationSummary("locationSummary");

    public final StringPath content = createString("content");

    public final QContentType contentType;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLocation location;

    public QLocationSummary(String variable) {
        this(LocationSummary.class, forVariable(variable), INITS);
    }

    public QLocationSummary(Path<? extends LocationSummary> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLocationSummary(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLocationSummary(PathMetadata<?> metadata, PathInits inits) {
        this(LocationSummary.class, metadata, inits);
    }

    public QLocationSummary(Class<? extends LocationSummary> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contentType = inits.isInitialized("contentType") ? new QContentType(forProperty("contentType")) : null;
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location"), inits.get("location")) : null;
    }

}

