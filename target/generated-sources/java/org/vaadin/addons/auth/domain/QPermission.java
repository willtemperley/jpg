package org.vaadin.addons.auth.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPermission is a Querydsl query type for Permission
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPermission extends EntityPathBase<Permission> {

    private static final long serialVersionUID = 15880829L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPermission permission = new QPermission("permission");

    public final QAction action;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPermissionTarget target;

    public QPermission(String variable) {
        this(Permission.class, forVariable(variable), INITS);
    }

    public QPermission(Path<? extends Permission> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPermission(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPermission(PathMetadata<?> metadata, PathInits inits) {
        this(Permission.class, metadata, inits);
    }

    public QPermission(Class<? extends Permission> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.action = inits.isInitialized("action") ? new QAction(forProperty("action")) : null;
        this.target = inits.isInitialized("target") ? new QPermissionTarget(forProperty("target")) : null;
    }

}

