package jp.drjoy.service.registration.dto.form;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;

public class R001Form extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String secUserId;
	private String secUserName;
	private String secRoleId;
	private String secUserRoleId;

	public String getSecUserId() {
		return secUserId;
	}

	public void setSecUserId(String secUserId) {
		this.secUserId = secUserId;
	}

	public String getSecUserName() {
		return secUserName;
	}

	public void setSecUserName(String secUserName) {
		this.secUserName = secUserName;
	}

	public String getSecRoleId() {
		return secRoleId;
	}

	public void setSecRoleId(String secRoleId) {
		this.secRoleId = secRoleId;
	}

	public String getSecUserRoleId() {
		return secUserRoleId;
	}

	public void setSecUserRoleId(String secUserRoleId) {
		this.secUserRoleId = secUserRoleId;
	}

}
