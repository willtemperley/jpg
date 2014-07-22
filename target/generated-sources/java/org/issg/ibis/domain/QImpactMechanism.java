package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QImpactMechanism is a Querydsl query type for ImpactMechanism
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QImpactMechanism extends EntityPathBase<ImpactMechanism> {

    private static final long serialVersionUID = 1239170702L;

    public static final QImpactMechanism impactMechanism = new QImpactMechanism("impactMechanism");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public final BooleanPath used = createBoolean("used");

    public QImpactMechanism(String variable) {
        super(ImpactMechanism.class, forVariable(variable));
    }

    public QImpactMechanism(Path<? extends ImpactMechanism> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImpactMechanism(PathMetadata<?> metadata) {
        super(ImpactMechanism.class, metadata);
    }

}

