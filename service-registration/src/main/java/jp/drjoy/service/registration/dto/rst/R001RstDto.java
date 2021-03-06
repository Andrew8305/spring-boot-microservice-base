package jp.drjoy.service.registration.dto.rst;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;

public class R001RstDto extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private String username;
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
