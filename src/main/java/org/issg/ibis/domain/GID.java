package org.issg.ibis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

import java.util.Set;

@Entity
@Table(schema = "administrative_units", name = "gid")
public class GID {

    private Long id;

    @Id
    @Column(name="gid_code")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    
    @Column
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}

    private String name2;

    @Column
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	private String correctedName;

	@Column(name="corrected_name")
	public String getCorrectedName() {
		return correctedName;
	}

	public void setCorrectedName(String correctedName) {
		this.correctedName = correctedName;
	}
	
	private Point geom;
	
	@Column
    @Type(type = "org.hibernate.spatial.GeometryType")
    public Point getGeom() {
		return geom;
	}
	public void setGeom(Point geom) {
		this.geom = geom;
	}
	
	
	private Double area;
	
	@Column
	public Double getArea() {
		return area;
	}
	
	public void setArea(Double area) {
		this.area = area;
	}

	private Country country;

    @NotNull
    @ManyToOne
    @JoinColumn(name="country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


	@Override
    public int hashCode() {
        if (id != null) {
            return id.intValue();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof GID) {
           GID otherObj = (GID) obj;
           if (otherObj.getId().equals(this.getId())) {
                return true;
           }
           return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
    	if (name != null) {
    		return name;
		}
    	if (name2 != null) {
    		return name2;
		}
    	if (correctedName != null) {
    		return correctedName;
		}
    	return "Unnamed";
    }
}
