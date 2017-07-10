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
