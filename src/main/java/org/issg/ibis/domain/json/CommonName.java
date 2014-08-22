package org.issg.ibis.domain.json;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class CommonName {

	@Expose
	private String vernacularName;
	@Expose
	private String language;
	@Expose
	private Integer sourceTaxonKey;
	@Expose
	private Boolean preferred;

	public String getVernacularName() {
		return vernacularName;
	}

	public void setVernacularName(String vernacularName) {
		this.vernacularName = vernacularName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getSourceTaxonKey() {
		return sourceTaxonKey;
	}

	public void setSourceTaxonKey(Integer sourceTaxonKey) {
		this.sourceTaxonKey = sourceTaxonKey;
	}

	public Boolean getPreferred() {
		return preferred;
	}

	public void setPreferred(Boolean preferred) {
		this.preferred = preferred;
	}
	
	@Override
	public String toString() {
		return vernacularName;
	}

}
