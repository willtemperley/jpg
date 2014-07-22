package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDesignatedAreaType is a Querydsl query type for DesignatedAreaType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDesignatedAreaType extends EntityPathBase<DesignatedAreaType> {

    private static final long serialVersionUID = -146642788L;

    public static final QDesignatedAreaType designatedAreaType = new QDesignatedAreaType("designatedAreaType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public QDesignatedAreaType(String variable) {
        super(DesignatedAreaType.class, forVariable(variable));
    }

    public QDesignatedAreaType(Path<? extends DesignatedAreaType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDesignatedAreaType(PathMetadata<?> metadata) {
        super(DesignatedAreaType.class, metadata);
    }

}

