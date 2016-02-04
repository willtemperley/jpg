package org.com.conflictarm.domain;

import com.vividsolutions.jts.geom.Geometry;
import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by will on 1/25/16.
 *
 */
public interface AdminUnit {

    Geometry getGeom();

    void setGeom(Geometry geom);

    Long getId();

    void setId(Long id);

    String getIsoa3Id();

    void setIsoa3Id(String isoa3Id);

    String getName();

    void setName(String name);

    String getIsoa2Id();

    void setIsoa2Id(String isoa2Id);
}
