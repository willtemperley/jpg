package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCountry is a Querydsl query type for Country
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCountry extends EntityPathBase<Country> {

    private static final long serialVersionUID = -287519631L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCountry country = new QCountry("country");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isoa2Id = createString("isoa2Id");

    public final StringPath isoa3Id = createString("isoa3Id");

    public final StringPath name = createString("name");

    public final QRegion region;

    public QCountry(String variable) {
        this(Country.class, forVariable(variable), INITS);
    }

    public QCountry(Path<? extends Country> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCountry(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCountry(PathMetadata<?> metadata, PathInits inits) {
        this(Country.class, metadata, inits);
    }

    public QCountry(Class<? extends Country> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

