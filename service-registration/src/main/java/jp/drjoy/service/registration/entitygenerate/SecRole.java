package jp.drjoy.service.registration.entitygenerate;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sec_role database table.
 * 
 */
@Entity
@Table(name="sec_role")
@NamedQuery(name="SecRole.findAll", query="SELECT s FROM SecRole s")
public class SecRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="creator_id")
	private Long creatorId;

	@Column(name="db_active")
	private String dbActive;

	private String description;

	@Column(name="last_updated_id")
	private Long lastUpdatedId;

	@Column(name="last_updated_time")
	private Timestamp lastUpdatedTime;

	private String name;

	private String type;

	//bi-directional many-to-one association to SecRolePermission
	@OneToMany(mappedBy="secRole")
	private List<SecRolePermission> secRolePermissions;

	//bi-directional many-to-one association to SecUserRole
	@OneToMany(mappedBy="secRole")
	private List<SecUserRole> secUserRoles;

	public SecRole() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Long getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getDbActive() {
		return this.dbActive;
	}

	public void setDbActive(String dbActive) {
		this.dbActive = dbActive;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLastUpdatedId() {
		return this.lastUpdatedId;
	}

	public void setLastUpdatedId(Long lastUpdatedId) {
		this.lastUpdatedId = lastUpdatedId;
	}

	public Timestamp getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SecRolePermission> getSecRolePermissions() {
		return this.secRolePermissions;
	}

	public void setSecRolePermissions(List<SecRolePermission> secRolePermissions) {
		this.secRolePermissions = secRolePermissions;
	}

	public SecRolePermission addSecRolePermission(SecRolePermission secRolePermission) {
		getSecRolePermissions().add(secRolePermission);
		secRolePermission.setSecRole(this);

		return secRolePermission;
	}

	public SecRolePermission removeSecRolePermission(SecRolePermission secRolePermission) {
		getSecRolePermissions().remove(secRolePermission);
		secRolePermission.setSecRole(null);

		return secRolePermission;
	}

	public List<SecUserRole> getSecUserRoles() {
		return this.secUserRoles;
	}

	public void setSecUserRoles(List<SecUserRole> secUserRoles) {
		this.secUserRoles = secUserRoles;
	}

	public SecUserRole addSecUserRole(SecUserRole secUserRole) {
		getSecUserRoles().add(secUserRole);
		secUserRole.setSecRole(this);

		return secUserRole;
	}

	public SecUserRole removeSecUserRole(SecUserRole secUserRole) {
		getSecUserRoles().remove(secUserRole);
		secUserRole.setSecRole(null);

		return secUserRole;
	}

}