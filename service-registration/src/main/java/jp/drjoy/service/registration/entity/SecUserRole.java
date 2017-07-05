package jp.drjoy.service.registration.entity;

import java.io.Serializable;
import javax.persistence.*;

import jp.drjoy.service.common.dto.PO;

import java.sql.Timestamp;


/**
 * The persistent class for the sec_user_role database table.
 * 
 */
@Entity
@Table(name="sec_user_role")
@NamedQuery(name="SecUserRole.findAll", query="SELECT s FROM SecUserRole s")
public class SecUserRole extends PO<Long> implements Serializable {
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

	//bi-directional many-to-one association to SecRole
	@ManyToOne
	@JoinColumn(name="role_id")
	private SecRole secRole;

	//bi-directional many-to-one association to SecUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private SecUser secUser;

	public SecUserRole() {
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

	public SecRole getSecRole() {
		return this.secRole;
	}

	public void setSecRole(SecRole secRole) {
		this.secRole = secRole;
	}

	public SecUser getSecUser() {
		return this.secUser;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

}