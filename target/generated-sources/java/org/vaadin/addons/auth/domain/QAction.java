package org.vaadin.addons.auth.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAction is a Querydsl query type for Action
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAction extends EntityPathBase<Action> {

    private static final long serialVersionUID = 44667364L;

    public static final QAction action = new QAction("action");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public QAction(String variable) {
        super(Action.class, forVariable(variable));
    }

    public QAction(Path<? extends Action> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAction(PathMetadata<?> metadata) {
        super(Action.class, metadata);
    }

}

