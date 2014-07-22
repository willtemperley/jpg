package org.issg.ibis.domain.view;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSpeciesExtent is a Querydsl query type for SpeciesExtent
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSpeciesExtent extends EntityPathBase<SpeciesExtent> {

    private static final long serialVersionUID = 306673666L;

    public static final QSpeciesExtent speciesExtent = new QSpeciesExtent("speciesExtent");

    public final ComparablePath<com.vividsolutions.jts.geom.Polygon> envelope = createComparable("envelope", com.vividsolutions.jts.geom.Polygon.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QSpeciesExtent(String variable) {
        super(SpeciesExtent.class, forVariable(variable));
    }

    public QSpeciesExtent(Path<? extends SpeciesExtent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSpeciesExtent(PathMetadata<?> metadata) {
        super(SpeciesExtent.class, metadata);
    }

}

