package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBiologicalStatus is a Querydsl query type for BiologicalStatus
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBiologicalStatus extends EntityPathBase<BiologicalStatus> {

    private static final long serialVersionUID = 92155608L;

    public static final QBiologicalStatus biologicalStatus = new QBiologicalStatus("biologicalStatus");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isInvasive = createBoolean("isInvasive");

    public final StringPath label = createString("label");

    public QBiologicalStatus(String variable) {
        super(BiologicalStatus.class, forVariable(variable));
    }

    public QBiologicalStatus(Path<? extends BiologicalStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBiologicalStatus(PathMetadata<?> metadata) {
        super(BiologicalStatus.class, metadata);
    }

}

