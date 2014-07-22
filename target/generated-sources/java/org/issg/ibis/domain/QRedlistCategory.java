package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QRedlistCategory is a Querydsl query type for RedlistCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRedlistCategory extends EntityPathBase<RedlistCategory> {

    private static final long serialVersionUID = -2002967384L;

    public static final QRedlistCategory redlistCategory = new QRedlistCategory("redlistCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public final StringPath redlistCode = createString("redlistCode");

    public QRedlistCategory(String variable) {
        super(RedlistCategory.class, forVariable(variable));
    }

    public QRedlistCategory(Path<? extends RedlistCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRedlistCategory(PathMetadata<?> metadata) {
        super(RedlistCategory.class, metadata);
    }

}

