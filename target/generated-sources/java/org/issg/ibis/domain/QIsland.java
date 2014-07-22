package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QIsland is a Querydsl query type for Island
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIsland extends EntityPathBase<Island> {

    private static final long serialVersionUID = -1219559974L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIsland island = new QIsland("island");

    public final NumberPath<Long> countryId = createNumber("countryId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath islandGroup = createString("islandGroup");

    public final StringPath islandName = createString("islandName");

    public final StringPath islandNotes = createString("islandNotes");

    public final QIslandType islandType;

    public final NumberPath<Double> latitudeDec = createNumber("latitudeDec", Double.class);

    public final StringPath latitudeDeg = createString("latitudeDeg");

    public final NumberPath<Double> longitudeDec = createNumber("longitudeDec", Double.class);

    public final StringPath longitudeDeg = createString("longitudeDeg");

    public QIsland(String variable) {
        this(Island.class, forVariable(variable), INITS);
    }

    public QIsland(Path<? extends Island> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QIsland(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QIsland(PathMetadata<?> metadata, PathInits inits) {
        this(Island.class, metadata, inits);
    }

    public QIsland(Class<? extends Island> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.islandType = inits.isInitialized("islandType") ? new QIslandType(forProperty("islandType")) : null;
    }

}

