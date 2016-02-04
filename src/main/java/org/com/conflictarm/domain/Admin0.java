package org.com.conflictarm.domain;

import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "ne", name = "ne_110m_admin_0_countries")
public class Admin0 implements AdminUnit {

    private Geometry geom;

    @Override
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "geometry(MultiPolygon,4326)")
    public Geometry getGeom() {
        return geom;
    }

    @Override
    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    private Long id;

    @Override
    @Id
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    @Override
    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    private String isoa2Id;

    @Override
    @NotNull
    @Column(name="iso_a2")
    public String getIsoa2Id() {
        return isoa2Id;
    }

    @Override
    public void setIsoa2Id(String isoa2Id) {
        this.isoa2Id = isoa2Id;
    }

  private String isoa3Id;

  @Override
  @NotNull
  @Column(name="iso_a3")
  public String getIsoa3Id() {
    return isoa3Id;
  }

  @Override
  public void setIsoa3Id(String isoa3Id) {
    this.isoa3Id = isoa3Id;
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
