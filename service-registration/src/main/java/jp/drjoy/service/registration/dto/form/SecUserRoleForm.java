package jp.drjoy.service.registration.dto.form;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;

public class SecUserRoleForm extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	private String dbActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDbActive() {
		return dbActive;
	}

	public void setDbActive(String dbActive) {
		this.dbActive = dbActive;
	}

}
