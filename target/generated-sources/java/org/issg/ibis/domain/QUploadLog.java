package org.issg.ibis.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUploadLog is a Querydsl query type for UploadLog
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUploadLog extends EntityPathBase<UploadLog> {

    private static final long serialVersionUID = -1542030434L;

    public static final QUploadLog uploadLog = new QUploadLog("uploadLog");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QUploadLog(String variable) {
        super(UploadLog.class, forVariable(variable));
    }

    public QUploadLog(Path<? extends UploadLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUploadLog(PathMetadata<?> metadata) {
        super(UploadLog.class, metadata);
    }

}

