package org.issg.ibis.domain.view;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QResourceDescription is a Querydsl query type for ResourceDescription
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QResourceDescription extends EntityPathBase<ResourceDescription> {

    private static final long serialVersionUID = 896274058L;

    public static final QResourceDescription resourceDescription = new QResourceDescription("resourceDescription");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> impactCount = createNumber("impactCount", Integer.class);

    public final SetPath<org.issg.ibis.domain.Location, org.issg.ibis.domain.QLocation> locations = this.<org.issg.ibis.domain.Location, org.issg.ibis.domain.QLocation>createSet("locations", org.issg.ibis.domain.Location.class, org.issg.ibis.domain.QLocation.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath resultType = createString("resultType");

    public final SetPath<org.issg.ibis.domain.Species, org.issg.ibis.domain.QSpecies> species = this.<org.issg.ibis.domain.Species, org.issg.ibis.domain.QSpecies>createSet("species", org.issg.ibis.domain.Species.class, org.issg.ibis.domain.QSpecies.class, PathInits.DIRECT2);

    public QResourceDescription(String variable) {
        super(ResourceDescription.class, forVariable(variable));
    }

    public QResourceDescription(Path<? extends ResourceDescription> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResourceDescription(PathMetadata<?> metadata) {
        super(ResourceDescription.class, metadata);
    }

}

