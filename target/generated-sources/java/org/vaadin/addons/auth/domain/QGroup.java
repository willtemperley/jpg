package org.vaadin.addons.auth.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QGroup is a Querydsl query type for Group
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGroup extends EntityPathBase<Group> {

    private static final long serialVersionUID = -1239501551L;

    public static final QGroup group = new QGroup("group1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<Permission, QPermission> permissions = this.<Permission, QPermission>createSet("permissions", Permission.class, QPermission.class, PathInits.DIRECT2);

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public QGroup(String variable) {
        super(Group.class, forVariable(variable));
    }

    public QGroup(Path<? extends Group> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroup(PathMetadata<?> metadata) {
        super(Group.class, metadata);
    }

}

