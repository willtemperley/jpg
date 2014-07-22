package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QOrganismType is a Querydsl query type for OrganismType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrganismType extends EntityPathBase<OrganismType> {

    private static final long serialVersionUID = -1071241423L;

    public static final QOrganismType organismType = new QOrganismType("organismType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public QOrganismType(String variable) {
        super(OrganismType.class, forVariable(variable));
    }

    public QOrganismType(Path<? extends OrganismType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrganismType(PathMetadata<?> metadata) {
        super(OrganismType.class, metadata);
    }

}

