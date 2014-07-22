package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QImpactOutcome is a Querydsl query type for ImpactOutcome
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QImpactOutcome extends EntityPathBase<ImpactOutcome> {

    private static final long serialVersionUID = 2044341191L;

    public static final QImpactOutcome impactOutcome = new QImpactOutcome("impactOutcome");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public QImpactOutcome(String variable) {
        super(ImpactOutcome.class, forVariable(variable));
    }

    public QImpactOutcome(Path<? extends ImpactOutcome> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImpactOutcome(PathMetadata<?> metadata) {
        super(ImpactOutcome.class, metadata);
    }

}

