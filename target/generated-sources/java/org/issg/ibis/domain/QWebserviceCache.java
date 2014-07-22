package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QWebserviceCache is a Querydsl query type for WebserviceCache
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWebserviceCache extends EntityPathBase<WebserviceCache> {

    private static final long serialVersionUID = 1025947900L;

    public static final QWebserviceCache webserviceCache = new QWebserviceCache("webserviceCache");

    public final DateTimePath<java.util.Date> accessDate = createDateTime("accessDate", java.util.Date.class);

    public final StringPath id = createString("id");

    public final StringPath result = createString("result");

    public QWebserviceCache(String variable) {
        super(WebserviceCache.class, forVariable(variable));
    }

    public QWebserviceCache(Path<? extends WebserviceCache> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWebserviceCache(PathMetadata<?> metadata) {
        super(WebserviceCache.class, metadata);
    }

}

