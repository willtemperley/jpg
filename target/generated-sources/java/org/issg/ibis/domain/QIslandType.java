package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QIslandType is a Querydsl query type for IslandType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIslandType extends EntityPathBase<IslandType> {

    private static final long serialVersionUID = 1504740404L;

    public static final QIslandType islandType = new QIslandType("islandType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath uri = createString("uri");

    public QIslandType(String variable) {
        super(IslandType.class, forVariable(variable));
    }

    public QIslandType(Path<? extends IslandType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIslandType(PathMetadata<?> metadata) {
        super(IslandType.class, metadata);
    }

}

