package jp.drjoy.service.registration.dto.prm;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;

public class R001Prm extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
