package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSpeciesSummary is a Querydsl query type for SpeciesSummary
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSpeciesSummary extends EntityPathBase<SpeciesSummary> {

    private static final long serialVersionUID = -707604081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSpeciesSummary speciesSummary = new QSpeciesSummary("speciesSummary");

    public final StringPath content = createString("content");

    public final QContentType contentType;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSpecies species;

    public QSpeciesSummary(String variable) {
        this(SpeciesSummary.class, forVariable(variable), INITS);
    }

    public QSpeciesSummary(Path<? extends SpeciesSummary> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpeciesSummary(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpeciesSummary(PathMetadata<?> metadata, PathInits inits) {
        this(SpeciesSummary.class, metadata, inits);
    }

    public QSpeciesSummary(Class<? extends SpeciesSummary> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.contentType = inits.isInitialized("contentType") ? new QContentType(forProperty("contentType")) : null;
        this.species = inits.isInitialized("species") ? new QSpecies(forProperty("species"), inits.get("species")) : null;
    }

}

