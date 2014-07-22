package org.vaadin.addons.auth.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -455301212L;

    public static final QRole role = new QRole("role");

    public final BooleanPath canLogin = createBoolean("canLogin");

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final SetPath<Group, QGroup> groups = this.<Group, QGroup>createSet("groups", Group.class, QGroup.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isSuperUser = createBoolean("isSuperUser");

    public final StringPath lastName = createString("lastName");

    public final SetPath<Permission, QPermission> permissions = this.<Permission, QPermission>createSet("permissions", Permission.class, QPermission.class, PathInits.DIRECT2);

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata<?> metadata) {
        super(Role.class, metadata);
    }

}

