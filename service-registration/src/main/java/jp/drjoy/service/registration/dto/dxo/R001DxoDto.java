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

package jp.drjoy.service.registration.dto.dxo;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;

public class R001DxoDto extends DTO<Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long secUserId;
	private String secUserName;
	private Long secRoleId;
	private Long secUserRoleId;

	public Long getSecRoleId() {
		return secRoleId;
	}

	public void setSecRoleId(Long secRoleId) {
		this.secRoleId = secRoleId;
	}

	public Long getSecUserRoleId() {
		return secUserRoleId;
	}

	public void setSecUserRoleId(Long secUserRoleId) {
		this.secUserRoleId = secUserRoleId;
	}

	public Long getSecUserId() {
		return secUserId;
	}

	public void setSecUserId(Long secUserId) {
		this.secUserId = secUserId;
	}

	public String getSecUserName() {
		return secUserName;
	}

	public void setSecUserName(String secUserName) {
		this.secUserName = secUserName;
	}

}
