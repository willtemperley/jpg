package org.issg.ibis.domain.json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class VernacularNameQuery {

@Expose
private Integer offset;
@Expose
private Integer limit;
@Expose
private Boolean endOfRecords;
@Expose
private List<CommonName> results = new ArrayList<CommonName>();

public Integer getOffset() {
return offset;
}

public void setOffset(Integer offset) {
this.offset = offset;
}

public Integer getLimit() {
return limit;
}

public void setLimit(Integer limit) {
this.limit = limit;
}

public Boolean getEndOfRecords() {
return endOfRecords;
}

public void setEndOfRecords(Boolean endOfRecords) {
this.endOfRecords = endOfRecords;
}

public List<CommonName> getResults() {
return results;
}

public void setResults(List<CommonName> results) {
this.results = results;
}

}