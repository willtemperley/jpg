package org.issg.ibis.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.spatial.jts.JTS;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

@Entity
@SqlResultSetMapping(name = "Location.implicit", entities = { @EntityResult(entityClass = Location.class) })
@NamedNativeQueries({ @NamedNativeQuery(name = "Location.copy_location", query = "SELECT * from ibis.copy_location(:full_id, :name, :country_id)", resultSetMapping = "Location.implicit") })
@NamedQueries({ @NamedQuery(name = Location.HAS_IMPACT, query = "from Location l where exists (select 1 from SpeciesImpact i where i.location.id = l.id) order by name") })
@Table(schema = "ibis", name = "location")
public class Location {

	public static final String HAS_IMPACT = "Has Impact";

	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	@SequenceGenerator(allocationSize = 1, name = "seq", sequenceName = "ibis.location_id_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// private LocationGeom locationGeom;
	//
	// @OneToOne(cascade = CascadeType.ALL, optional=false, fetch =
	// FetchType.LAZY)
	// @PrimaryKeyJoinColumn
	// public LocationGeom getLocationGeom() {
	// return locationGeom;
	// }
	//
	// public void setLocationGeom(LocationGeom locationGeom) {
	// this.locationGeom = locationGeom;
	// }

	public void populate(GID val) {
		if (val != null) {
			this.name = val.toString();
			this.latitude = val.getGeom().getY();
			this.longitude = val.getGeom().getX();
			this.country = val.getCountry();
			this.setPrefix("GID");
			this.setIdentifier(val.getId().toString());
			

			this.area = val.getArea();
			
			//Very approximate box created
			if (area != null) {

				Envelope env = new Envelope();
				double onesqkmindegrees = Math.pow(0.0083333333, 2);
				double nDegs = area * onesqkmindegrees;
				double halfsideLen = Math.sqrt(nDegs)/2;
				System.out.println("side: " + halfsideLen);
				
				Coordinate ll = new Coordinate(longitude - halfsideLen, latitude - halfsideLen);
				Coordinate ur = new Coordinate(longitude + halfsideLen, latitude + halfsideLen);
				
				env.expandToInclude(ll);
				env.expandToInclude(ur);
				
				Polygon poly = (Polygon) JTS.getDefaultGeomFactory().toGeometry(env);

				geom = new MultiPolygon(new Polygon[]{poly}, JTS.getDefaultGeomFactory());
				
			}
		}
	}

	private Geometry geom;

	@Basic(fetch = FetchType.LAZY)
	@Type(type = "org.hibernate.spatial.GeometryType")
	public Geometry getGeom() {
		return geom;
	}

	public void setGeom(Geometry geom) {
		this.geom = geom;
	}

	private List<LocationSummary> locationSummaries;

	@OneToMany(mappedBy = "location")
	@OrderBy("contentType.id ASC")
	public List<LocationSummary> getLocationSummaries() {
		return locationSummaries;
	}

	public void setLocationSummaries(List<LocationSummary> locationSummaries) {
		this.locationSummaries = locationSummaries;
	}

	private String name;

	@NotNull
	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private LocationType locationType;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "location_type_id")
	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	private Country country;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	private Polygon envelope;

	@Column
	@Type(type = "org.hibernate.spatial.GeometryType")
	public Polygon getEnvelope() {
		return envelope;
	}

	public void setEnvelope(Polygon envelope) {
		this.envelope = envelope;
	}

	private String prefix;

	@Column
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	private String identifier;

	@Column
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	private String url;

	@Column
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private Double area;

	@Column
	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	private Double latitude;

	@Column
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	private Double longitude;

	@Column
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	private String comments;

	@Column
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public DesignatedAreaType designatedAreaType;

	@ManyToOne
	@JoinColumn(name = "designated_area_type_id")
	public DesignatedAreaType getDesignatedAreaType() {
		return designatedAreaType;
	}

	public void setDesignatedAreaType(DesignatedAreaType designatedAreaType) {
		this.designatedAreaType = designatedAreaType;
	}

	private String islandGroup;

	@Column(name = "island_group")
	public String getIslandGroup() {
		return islandGroup;
	}

	public void setIslandGroup(String islandGroup) {
		this.islandGroup = islandGroup;
	}

	private String designation;

	@Column
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	private String iucnCat;

	@Column(name = "iucn_category_id")
	public String getIucnCat() {
		return iucnCat;
	}

	public void setIucnCat(String iucnCat) {
		this.iucnCat = iucnCat;
	}

	private Point centroid;

	// @Transient
	@Column
	@Type(type = "org.hibernate.spatial.GeometryType")
	public Point getCentroid() {
		return centroid;
		// if (getLongitude() == null || getLatitude() == null) {
		// return null;
		// }
		// Double l = getLongitude();
		// /*
		// * Super hacky transformation
		// */
		// if (l <= 0) {
		// l += 360;
		// }
		// return geomFact.createPoint(new Coordinate(l, getLatitude()));
	}

	public void setCentroid(Point centroid) {
		this.centroid = centroid;
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

		if (obj instanceof Location) {
			Location otherObj = (Location) obj;
			return otherObj.getId().equals(this.getId());
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return name;
	}
}
