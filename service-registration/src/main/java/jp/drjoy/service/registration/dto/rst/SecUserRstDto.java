package jp.drjoy.service.registration.dto.rst;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;

public class SecUserRstDto extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String role;

	private Integer userRoleId;

	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
