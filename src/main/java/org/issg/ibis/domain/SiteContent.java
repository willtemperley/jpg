package org.issg.ibis.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "ibis", name = "site_content")
public class SiteContent implements Content {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @SequenceGenerator(allocationSize = 1, name = "seq", sequenceName = "ibis.site_content_id_seq")
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    private ContentType contentType;

    @Override
    @NotNull
    @ManyToOne
    @JoinColumn(name="content_type_id")
    public ContentType getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    private String title;

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String content;

    @Override
    @NotNull
    @Column
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        
        if (obj instanceof SiteContent) {
           SiteContent otherObj = (SiteContent) obj;
            if (otherObj.getId() != null) {
                return otherObj.getId().equals(this.getId());
            }
            return false;
        }
        return super.equals(obj);
    }

}
