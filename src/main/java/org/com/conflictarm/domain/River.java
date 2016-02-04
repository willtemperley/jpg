package org.com.conflictarm.domain;

import com.vividsolutions.jts.geom.Geometry;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "car", name = "ne_110m_admin_0_countries")
public class River {

    private Geometry geom;

    @Basic(fetch = FetchType.LAZY)
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    private Long id;

    @Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String isoa3Id;

    @NotNull
    @Column(name="iso_a3")
    public String getIsoa3Id() {
        return isoa3Id;
    }

    public void setIsoa3Id(String isoa3Id) {
        this.isoa3Id = isoa3Id;
    }

    private String name;

    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String isoa2Id;

    @NotNull
    @Column(name="iso_a2")
    public String getIsoa2Id() {
        return isoa2Id;
    }

    public void setIsoa2Id(String isoa2Id) {
        this.isoa2Id = isoa2Id;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof AdminUnit) {
            AdminUnit comparee = (AdminUnit) obj;
            if (comparee.getId().equals(getId())) {
                return true;
            }
        }
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        return id.intValue();
    }
    
    @Override
    public String toString() {
        return name;
    }

}
