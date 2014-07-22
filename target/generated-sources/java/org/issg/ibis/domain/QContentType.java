package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QContentType is a Querydsl query type for ContentType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QContentType extends EntityPathBase<ContentType> {

    private static final long serialVersionUID = -1563958610L;

    public static final QContentType contentType = new QContentType("contentType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QContentType(String variable) {
        super(ContentType.class, forVariable(variable));
    }

    public QContentType(Path<? extends ContentType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContentType(PathMetadata<?> metadata) {
        super(ContentType.class, metadata);
    }

}

