package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSpeciesImpact is a Querydsl query type for SpeciesImpact
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSpeciesImpact extends EntityPathBase<SpeciesImpact> {

    private static final long serialVersionUID = -316427715L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSpeciesImpact speciesImpact = new QSpeciesImpact("speciesImpact");

    public final QBiologicalStatus biologicalStatus;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QImpactMechanism impactMechanism;

    public final QImpactOutcome impactOutcome;

    public final QSpecies invasiveSpecies;

    public final QLocation location;

    public final QSpecies nativeSpecies;

    public final QReference reference;

    public QSpeciesImpact(String variable) {
        this(SpeciesImpact.class, forVariable(variable), INITS);
    }

    public QSpeciesImpact(Path<? extends SpeciesImpact> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpeciesImpact(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpeciesImpact(PathMetadata<?> metadata, PathInits inits) {
        this(SpeciesImpact.class, metadata, inits);
    }

    public QSpeciesImpact(Class<? extends SpeciesImpact> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.biologicalStatus = inits.isInitialized("biologicalStatus") ? new QBiologicalStatus(forProperty("biologicalStatus")) : null;
        this.impactMechanism = inits.isInitialized("impactMechanism") ? new QImpactMechanism(forProperty("impactMechanism")) : null;
        this.impactOutcome = inits.isInitialized("impactOutcome") ? new QImpactOutcome(forProperty("impactOutcome")) : null;
        this.invasiveSpecies = inits.isInitialized("invasiveSpecies") ? new QSpecies(forProperty("invasiveSpecies"), inits.get("invasiveSpecies")) : null;
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location"), inits.get("location")) : null;
        this.nativeSpecies = inits.isInitialized("nativeSpecies") ? new QSpecies(forProperty("nativeSpecies"), inits.get("nativeSpecies")) : null;
        this.reference = inits.isInitialized("reference") ? new QReference(forProperty("reference")) : null;
    }

}

