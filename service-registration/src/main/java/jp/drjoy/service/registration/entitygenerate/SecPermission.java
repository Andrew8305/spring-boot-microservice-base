package jp.drjoy.service.registration.entitygenerate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sec_permission database table.
 * 
 */
@Entity
@Table(name="sec_permission")
@NamedQuery(name="SecPermission.findAll", query="SELECT s FROM SecPermission s")
public class SecPermission implements Serializable {
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
	@OneToMany(mappedBy="secPermission")
	private List<SecRolePermission> secRolePermissions;

	public SecPermission() {
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
		secRolePermission.setSecPermission(this);

		return secRolePermission;
	}

	public SecRolePermission removeSecRolePermission(SecRolePermission secRolePermission) {
		getSecRolePermissions().remove(secRolePermission);
		secRolePermission.setSecPermission(null);

		return secRolePermission;
	}

}