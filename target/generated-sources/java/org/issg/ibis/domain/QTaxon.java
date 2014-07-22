package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTaxon is a Querydsl query type for Taxon
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaxon extends EntityPathBase<Taxon> {

    private static final long serialVersionUID = 1632861797L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTaxon taxon = new QTaxon("taxon");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public final QTaxon parentTaxon;

    public final QTaxonomicRank taxonomicRank;

    public QTaxon(String variable) {
        this(Taxon.class, forVariable(variable), INITS);
    }

    public QTaxon(Path<? extends Taxon> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaxon(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaxon(PathMetadata<?> metadata, PathInits inits) {
        this(Taxon.class, metadata, inits);
    }

    public QTaxon(Class<? extends Taxon> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentTaxon = inits.isInitialized("parentTaxon") ? new QTaxon(forProperty("parentTaxon"), inits.get("parentTaxon")) : null;
        this.taxonomicRank = inits.isInitialized("taxonomicRank") ? new QTaxonomicRank(forProperty("taxonomicRank")) : null;
    }

}

