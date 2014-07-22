package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBiome is a Querydsl query type for Biome
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBiome extends EntityPathBase<Biome> {

    private static final long serialVersionUID = 1616468027L;

    public static final QBiome biome = new QBiome("biome");

    public final StringPath annotation = createString("annotation");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath label = createString("label");

    public final SetPath<Species, QSpecies> speciess = this.<Species, QSpecies>createSet("speciess", Species.class, QSpecies.class, PathInits.DIRECT2);

    public QBiome(String variable) {
        super(Biome.class, forVariable(variable));
    }

    public QBiome(Path<? extends Biome> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBiome(PathMetadata<?> metadata) {
        super(Biome.class, metadata);
    }

}

