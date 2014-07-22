package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QDesignatedArea is a Querydsl query type for DesignatedArea
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDesignatedArea extends EntityPathBase<DesignatedArea> {

    private static final long serialVersionUID = -116173246L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDesignatedArea designatedArea = new QDesignatedArea("designatedArea");

    public final StringPath areaid = createString("areaid");

    public final StringPath comments = createString("comments");

    public final QDesignatedAreaType designatedAreaType;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> idcountry = createNumber("idcountry", Long.class);

    public final QIsland island;

    public final NumberPath<Long> latitude = createNumber("latitude", Long.class);

    public final NumberPath<Long> longitude = createNumber("longitude", Long.class);

    public final StringPath siteName = createString("siteName");

    public final NumberPath<Double> totalsize = createNumber("totalsize", Double.class);

    public final StringPath url = createString("url");

    public QDesignatedArea(String variable) {
        this(DesignatedArea.class, forVariable(variable), INITS);
    }

    public QDesignatedArea(Path<? extends DesignatedArea> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDesignatedArea(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDesignatedArea(PathMetadata<?> metadata, PathInits inits) {
        this(DesignatedArea.class, metadata, inits);
    }

    public QDesignatedArea(Class<? extends DesignatedArea> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.designatedAreaType = inits.isInitialized("designatedAreaType") ? new QDesignatedAreaType(forProperty("designatedAreaType")) : null;
        this.island = inits.isInitialized("island") ? new QIsland(forProperty("island"), inits.get("island")) : null;
    }

}

