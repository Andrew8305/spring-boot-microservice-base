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

package jp.drjoy.service.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.drjoy.service.common.controller.BaseController;
import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.registration.dto.form.SecUserForm;
import jp.drjoy.service.registration.dto.rst.SecUserRstDto;
import jp.drjoy.service.registration.service.ISecUserService;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<SecUserForm, SecUserRstDto> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ISecUserService secUserService;

	@Override
	protected BaseService<SecUserForm, SecUserRstDto> getService() {
		return secUserService;
	}

}
