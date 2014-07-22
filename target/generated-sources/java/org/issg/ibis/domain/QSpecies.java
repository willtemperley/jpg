package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSpecies is a Querydsl query type for Species
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSpecies extends EntityPathBase<Species> {

    private static final long serialVersionUID = 1041151511L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSpecies species1 = new QSpecies("species1");

    public final StringPath authority = createString("authority");

    public final SetPath<Biome, QBiome> biomes = this.<Biome, QBiome>createSet("biomes", Biome.class, QBiome.class, PathInits.DIRECT2);

    public final StringPath clazz = createString("clazz");

    public final StringPath commonName = createString("commonName");

    public final StringPath family = createString("family");

    public final StringPath gbifJson = createString("gbifJson");

    public final StringPath genus = createString("genus");

    public final StringPath gisdLink = createString("gisdLink");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final SetPath<SpeciesImpact, QSpeciesImpact> invasiveSpeciesImpacts = this.<SpeciesImpact, QSpeciesImpact>createSet("invasiveSpeciesImpacts", SpeciesImpact.class, QSpeciesImpact.class, PathInits.DIRECT2);

    public final StringPath kingdom = createString("kingdom");

    public final StringPath link = createString("link");

    public final StringPath name = createString("name");

    public final SetPath<SpeciesImpact, QSpeciesImpact> nativeSpeciesImpacts = this.<SpeciesImpact, QSpeciesImpact>createSet("nativeSpeciesImpacts", SpeciesImpact.class, QSpeciesImpact.class, PathInits.DIRECT2);

    public final NumberPath<Long> nubKey = createNumber("nubKey", Long.class);

    public final StringPath order = createString("order");

    public final QOrganismType organismType;

    public final StringPath phylum = createString("phylum");

    public final QRedlistCategory redlistCategory;

    public final NumberPath<Integer> redlistId = createNumber("redlistId", Integer.class);

    public final SetPath<Reference, QReference> references = this.<Reference, QReference>createSet("references", Reference.class, QReference.class, PathInits.DIRECT2);

    public final StringPath species = createString("species");

    public final SetPath<SpeciesLocation, QSpeciesLocation> speciesLocations = this.<SpeciesLocation, QSpeciesLocation>createSet("speciesLocations", SpeciesLocation.class, QSpeciesLocation.class, PathInits.DIRECT2);

    public final SetPath<org.issg.ibis.domain.view.LocationView, org.issg.ibis.domain.view.QLocationView> speciesLocationViews = this.<org.issg.ibis.domain.view.LocationView, org.issg.ibis.domain.view.QLocationView>createSet("speciesLocationViews", org.issg.ibis.domain.view.LocationView.class, org.issg.ibis.domain.view.QLocationView.class, PathInits.DIRECT2);

    public final ListPath<SpeciesSummary, QSpeciesSummary> speciesSummaries = this.<SpeciesSummary, QSpeciesSummary>createList("speciesSummaries", SpeciesSummary.class, QSpeciesSummary.class, PathInits.DIRECT2);

    public final StringPath synonyms = createString("synonyms");

    public final StringPath uri = createString("uri");

    public QSpecies(String variable) {
        this(Species.class, forVariable(variable), INITS);
    }

    public QSpecies(Path<? extends Species> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpecies(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSpecies(PathMetadata<?> metadata, PathInits inits) {
        this(Species.class, metadata, inits);
    }

    public QSpecies(Class<? extends Species> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.organismType = inits.isInitialized("organismType") ? new QOrganismType(forProperty("organismType")) : null;
        this.redlistCategory = inits.isInitialized("redlistCategory") ? new QRedlistCategory(forProperty("redlistCategory")) : null;
    }

}

