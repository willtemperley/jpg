package org.com.conflictarm.domain;

/**
 * Created by will on 1/25/16.
 */
import com.vividsolutions.jts.geom.Geometry;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * Created by tempehu on 01-Dec-14.
 */
@Entity
@Table(schema = "car", name = "waypoint")
public class Waypoint {

    @Id
    @Column(name = "id")
    public Integer id;

    @ManyToOne
    @JoinColumn(name="route_id")
    public Route route;

    @Type(type = "org.hibernate.spatial.GeometryType")
    public Geometry geom;

    @Column(name = "chain_position")
    public String chainPosition;

    @Column(name = "waypoint_type")
    public String waypointType;

    @Column(name = "transfer_type")
    public String transferType;

    @NotNull
    @Column(name = "country")
    public String country;

    @Column(name = "city")
    public String city;

    @Column(name = "country_id")
    private Integer countryId;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

}
