package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QIucnCategory is a Querydsl query type for IucnCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIucnCategory extends EntityPathBase<IucnCategory> {

    private static final long serialVersionUID = -297372486L;

    public static final QIucnCategory iucnCategory = new QIucnCategory("iucnCategory");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QIucnCategory(String variable) {
        super(IucnCategory.class, forVariable(variable));
    }

    public QIucnCategory(Path<? extends IucnCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIucnCategory(PathMetadata<?> metadata) {
        super(IucnCategory.class, metadata);
    }

}

