package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSpeciesLocation is a Querydsl query type for SpeciesLocation
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSpeciesLocation extends EntityPathBase<SpeciesLocation> {

    private static final long serialVersionUID = -1102531860L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSpeciesLocation speciesLocation = new QSpeciesLocation("speciesLocation");

    public final QBiologicalStatus biologicalStatus;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLocation location;

    public final QSpecies species;

    public QSpeciesLocation(String variable) {
        this(SpeciesLocation.class, forVariable(variable), INITS);
    }

    public QSpeciesLocation(Path<? extends SpeciesLocation> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpeciesLocation(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpeciesLocation(PathMetadata<?> metadata, PathInits inits) {
        this(SpeciesLocation.class, metadata, inits);
    }

    public QSpeciesLocation(Class<? extends SpeciesLocation> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.biologicalStatus = inits.isInitialized("biologicalStatus") ? new QBiologicalStatus(forProperty("biologicalStatus")) : null;
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location"), inits.get("location")) : null;
        this.species = inits.isInitialized("species") ? new QSpecies(forProperty("species"), inits.get("species")) : null;
    }

}

