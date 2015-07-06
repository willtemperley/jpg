package org.vaadin.addons.auth.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "auth", name = "permission")
public class Permission {
  
  
  private Long id;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
  @SequenceGenerator(allocationSize = 1, name="seq", sequenceName="auth.permission_id_seq")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  private Action action;

  @NotNull
  @ManyToOne
  public Action getAction() {
    return action;
  }
  
  public void setAction(Action action) {
    this.action = action;
  }
  
  private PermissionTarget target;

  @NotNull
  @ManyToOne
  public PermissionTarget getTarget() {
    return target;
  }

  public void setTarget(PermissionTarget target) {
    this.target = target;
  }
  
  @Override
  public String toString() {
    return action.getLabel() + "_" + target.getName();
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

        if (obj instanceof Permission) {
           Permission otherObj = (Permission) obj;
          return otherObj.getId().equals(this.getId());
        }
        return super.equals(obj);
    }
}
