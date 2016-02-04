package org.com.conflictarm.domain;

import com.vividsolutions.jts.geom.Geometry;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by will on 1/25/16.
 */
@Entity
@Table(schema = "car", name = "route")
public class Route {

  @Id
  @Column(name = "id")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

//  @Type(type = "org.hibernate.spatial.GeometryType")
  @Column(columnDefinition = "geometry(Point,4326)")
  private Geometry geom;


  public Geometry getGeom() {
    return geom;
  }

  public void setGeom(Geometry geom) {
    this.geom = geom;
  }

  @ManyToOne
  @JoinColumn(name = "material_type_id")
  private MaterialType materialType;

  public MaterialType getMaterialType() {
    return materialType;
  }

  public void setMaterialType(MaterialType materialType) {
    this.materialType = materialType;
  }

  @Column(name = "manufacturer_city")
  private
  String manufacturerCity;

  public String getManufacturerCity() {
    return manufacturerCity;
  }

  public void setManufacturerCity(String manufacturerCity) {
    this.manufacturerCity = manufacturerCity;
  }

  @Column(name = "manufacturer_name")
  private
  String manufacturerName;

  public String getManufacturerName() {
    return manufacturerName;
  }

  public void setManufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
  }


  @Column(name = "manufacturer_country")
  private
  String manufacturerCountry;

  public String getManufacturerCountry() {
    return manufacturerCountry;
  }

  public void setManufacturerCountry(String manufacturerCountry) {
    this.manufacturerCountry = manufacturerCountry;
  }

  @Column(name = "country_id")
  private Integer countryId;

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }
}
