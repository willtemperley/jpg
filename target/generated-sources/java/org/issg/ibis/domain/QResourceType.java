package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QResourceType is a Querydsl query type for ResourceType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QResourceType extends EntityPathBase<ResourceType> {

    private static final long serialVersionUID = 1850698861L;

    public static final QResourceType resourceType = new QResourceType("resourceType");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public QResourceType(String variable) {
        super(ResourceType.class, forVariable(variable));
    }

    public QResourceType(Path<? extends ResourceType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResourceType(PathMetadata<?> metadata) {
        super(ResourceType.class, metadata);
    }

}

