package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTaxonomicRank is a Querydsl query type for TaxonomicRank
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaxonomicRank extends EntityPathBase<TaxonomicRank> {

    private static final long serialVersionUID = -714757847L;

    public static final QTaxonomicRank taxonomicRank = new QTaxonomicRank("taxonomicRank");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public QTaxonomicRank(String variable) {
        super(TaxonomicRank.class, forVariable(variable));
    }

    public QTaxonomicRank(Path<? extends TaxonomicRank> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTaxonomicRank(PathMetadata<?> metadata) {
        super(TaxonomicRank.class, metadata);
    }

}

