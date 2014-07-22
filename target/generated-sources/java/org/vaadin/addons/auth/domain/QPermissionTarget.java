package org.vaadin.addons.auth.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPermissionTarget is a Querydsl query type for PermissionTarget
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPermissionTarget extends EntityPathBase<PermissionTarget> {

    private static final long serialVersionUID = 733683310L;

    public static final QPermissionTarget permissionTarget = new QPermissionTarget("permissionTarget");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QPermissionTarget(String variable) {
        super(PermissionTarget.class, forVariable(variable));
    }

    public QPermissionTarget(Path<? extends PermissionTarget> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPermissionTarget(PathMetadata<?> metadata) {
        super(PermissionTarget.class, metadata);
    }

}

