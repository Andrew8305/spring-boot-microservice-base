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

package jp.drjoy.service.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.drjoy.service.common.repository.BaseRepository;
import jp.drjoy.service.common.service.impl.BaseServiceImpl;
import jp.drjoy.service.common.util.BeanUtil;
import jp.drjoy.service.registration.dto.form.UserRoleForm;
import jp.drjoy.service.registration.dto.rst.SecUserRoleRstDto;
import jp.drjoy.service.registration.dto.rst.SecUserRoleRstDto.SecRoleRstDto;
import jp.drjoy.service.registration.entity.SecUserRole;
import jp.drjoy.service.registration.repository.SecUserRoleRepository;
import jp.drjoy.service.registration.service.ISecUserRoleService;


@Service("userRoleService")
public class SecUserRoleServiceImpl extends BaseServiceImpl<SecUserRole, UserRoleForm, SecUserRoleRstDto> implements ISecUserRoleService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SecUserRoleRepository userRoleRepository;

	@Override
	public BaseRepository<SecUserRole, Long> getRepository() {
		return userRoleRepository;
	}

	@Override
	public SecUserRoleRstDto createBaseDto(SecUserRole entity, Long size) {
		SecUserRoleRstDto simpleDto = (SecUserRoleRstDto) BeanUtil.createAndCopyPropertiesNative(entity, SecUserRoleRstDto.class);
		simpleDto.setSecRole( (SecRoleRstDto) BeanUtil.createAndCopyPropertiesNative(entity.getSecRole(), SecUserRoleRstDto.SecRoleRstDto.class));
		simpleDto.setCount(size);
		return simpleDto;
	}

	@Override
	public SecUserRole createEntity(UserRoleForm userForm) {
		SecUserRole entity = (SecUserRole) BeanUtil.createAndCopyPropertiesNative(userForm, SecUserRole.class);
		return entity;
	}

	@Override
	public void updateEntity(SecUserRole entity, UserRoleForm userForm) throws RuntimeException {
		userForm.setId(entity.getId());
		BeanUtil.copyPropertiesNative(userForm, entity);
	}

}