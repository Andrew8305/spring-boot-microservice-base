package jp.drjoy.service.registration.entity;

import java.io.Serializable;
import javax.persistence.*;

import jp.drjoy.service.common.dto.PO;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sec_user database table.
 * 
 */
@Entity
@Table(name="sec_user")
@NamedQuery(name="SecUser.findAll", query="SELECT s FROM SecUser s")
public class SecUser extends PO<Long> implements Serializable {
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

	private String password;

	private String username;

	//bi-directional many-to-one association to SecUserRole
	@OneToMany(mappedBy="secUser")
	private List<SecUserRole> secUserRoles;

	public SecUser() {
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SecUserRole> getSecUserRoles() {
		return this.secUserRoles;
	}

	public void setSecUserRoles(List<SecUserRole> secUserRoles) {
		this.secUserRoles = secUserRoles;
	}

	public SecUserRole addSecUserRole(SecUserRole secUserRole) {
		getSecUserRoles().add(secUserRole);
		secUserRole.setSecUser(this);

		return secUserRole;
	}

	public SecUserRole removeSecUserRole(SecUserRole secUserRole) {
		getSecUserRoles().remove(secUserRole);
		secUserRole.setSecUser(null);

		return secUserRole;
	}

}