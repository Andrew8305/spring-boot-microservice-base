/**
* Copyright (c) Acroquest Technology Co., Ltd. All Rights Reserved.
* Please read the associated COPYRIGHTS file for more details.
*
* THE SOFTWARE IS PROVIDED BY Acroquest Technology Co., Ltd.,
* WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
* CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

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
