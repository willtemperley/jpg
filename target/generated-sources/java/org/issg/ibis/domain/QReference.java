package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QReference is a Querydsl query type for Reference
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QReference extends EntityPathBase<Reference> {

    private static final long serialVersionUID = 588704102L;

    public static final QReference reference = new QReference("reference");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<Location, QLocation> locations = this.<Location, QLocation>createSet("locations", Location.class, QLocation.class, PathInits.DIRECT2);

    public final SetPath<Species, QSpecies> species = this.<Species, QSpecies>createSet("species", Species.class, QSpecies.class, PathInits.DIRECT2);

    public QReference(String variable) {
        super(Reference.class, forVariable(variable));
    }

    public QReference(Path<? extends Reference> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReference(PathMetadata<?> metadata) {
        super(Reference.class, metadata);
    }

}

