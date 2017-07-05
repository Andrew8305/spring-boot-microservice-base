package jp.drjoy.service.registration.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sec_role_permission database table.
 * 
 */
@Entity
@Table(name="sec_role_permission")
@NamedQuery(name="SecRolePermission.findAll", query="SELECT s FROM SecRolePermission s")
public class SecRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="creator_id")
	private Long creatorId;

	@Column(name="db_active")
	private String dbActive;

	@Column(name="last_updated_id")
	private Long lastUpdatedId;

	@Column(name="last_updated_time")
	private Timestamp lastUpdatedTime;

	//bi-directional many-to-one association to SecPermission
	@ManyToOne
	@JoinColumn(name="permission_id")
	private SecPermission secPermission;

	//bi-directional many-to-one association to SecRole
	@ManyToOne
	@JoinColumn(name="role_id")
	private SecRole secRole;

	public SecRolePermission() {
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

	public SecPermission getSecPermission() {
		return this.secPermission;
	}

	public void setSecPermission(SecPermission secPermission) {
		this.secPermission = secPermission;
	}

	public SecRole getSecRole() {
		return this.secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
	}

}