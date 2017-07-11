package jp.drjoy.service.registration.entity;

public class R001Entity {
	private Long userId;
	private String username;
	private Long roleId;

	public R001Entity(Long userId, String username, Long roleId) {
		this.userId = userId;
		this.username = username;
		this.roleId = roleId;
	}

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
