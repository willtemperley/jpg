package org.issg.ibis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "ibis", name = "conservation_classification")
public class ConservationClassification {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @SequenceGenerator(allocationSize = 1, name = "seq", sequenceName = "ibis.conservation_classification_id_seq")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String abbreviation;

    public String getAbbreviation() {
		return abbreviation;
	}
    
    public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

    private String name;

    @Column
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
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

        if (obj instanceof ConservationClassification) {
           ConservationClassification otherObj = (ConservationClassification) obj;
           if (otherObj.getId().equals(this.getId())) {
                return true;
            }
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return name;
    }
}
