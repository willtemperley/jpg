package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QLocationType is a Querydsl query type for LocationType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLocationType extends EntityPathBase<LocationType> {

    private static final long serialVersionUID = -2118181740L;

    public static final QLocationType locationType = new QLocationType("locationType");

    public final StringPath id = createString("id");

    public QLocationType(String variable) {
        super(LocationType.class, forVariable(variable));
    }

    public QLocationType(Path<? extends LocationType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocationType(PathMetadata<?> metadata) {
        super(LocationType.class, metadata);
    }

}

