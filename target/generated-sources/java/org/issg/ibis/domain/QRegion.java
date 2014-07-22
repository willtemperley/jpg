package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRegion is a Querydsl query type for Region
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRegion extends EntityPathBase<Region> {

    private static final long serialVersionUID = -974968135L;

    public static final QRegion region = new QRegion("region");

    public final SetPath<Country, QCountry> countries = this.<Country, QCountry>createSet("countries", Country.class, QCountry.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QRegion(String variable) {
        super(Region.class, forVariable(variable));
    }

    public QRegion(Path<? extends Region> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegion(PathMetadata<?> metadata) {
        super(Region.class, metadata);
    }

}

