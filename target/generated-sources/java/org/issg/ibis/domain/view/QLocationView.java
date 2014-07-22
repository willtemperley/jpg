package org.issg.ibis.domain.view;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QLocationView is a Querydsl query type for LocationView
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLocationView extends EntityPathBase<LocationView> {

    private static final long serialVersionUID = 537723902L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocationView locationView = new QLocationView("locationView");

    public final StringPath country = createString("country");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath region = createString("region");

    public final org.issg.ibis.domain.QSpecies species;

    public QLocationView(String variable) {
        this(LocationView.class, forVariable(variable), INITS);
    }

    public QLocationView(Path<? extends LocationView> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLocationView(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLocationView(PathMetadata<?> metadata, PathInits inits) {
        this(LocationView.class, metadata, inits);
    }

    public QLocationView(Class<? extends LocationView> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.species = inits.isInitialized("species") ? new org.issg.ibis.domain.QSpecies(forProperty("species"), inits.get("species")) : null;
    }

}

