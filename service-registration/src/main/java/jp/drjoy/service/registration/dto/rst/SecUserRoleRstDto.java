package jp.drjoy.service.registration.dto.rst;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;

public class SecUserRoleRstDto extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private SecRoleRstDto secRoleRstDto;

	public SecRoleRstDto getSecRoleRstDto() {
		return secRoleRstDto;
	}

	public void setSecRoleRstDto(SecRoleRstDto secRoleRstDto) {
		this.secRoleRstDto = secRoleRstDto;
	}

	public static class SecRoleRstDto implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	}
}
