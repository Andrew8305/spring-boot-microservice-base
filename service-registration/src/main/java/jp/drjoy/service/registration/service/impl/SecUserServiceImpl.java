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
import jp.drjoy.service.registration.dto.form.SecUserForm;
import jp.drjoy.service.registration.dto.rst.SecUserRstDto;
import jp.drjoy.service.registration.entity.SecUser;
import jp.drjoy.service.registration.repository.SecUserRepository;
import jp.drjoy.service.registration.service.ISecUserService;

@Service
public class SecUserServiceImpl extends BaseServiceImpl<SecUser, SecUserForm, SecUserRstDto> implements ISecUserService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SecUserRepository userRepository;

	@Override
	public BaseRepository<SecUser, Long> getRepository() {
		return userRepository;
	}

	@Override
	public SecUserRstDto createBaseDto(SecUser entity, Long size) {
		SecUserRstDto simpleDto = new SecUserRstDto();
		BeanUtil.copyPropertiesNative(entity, simpleDto);
		simpleDto.setCount(size);
		return simpleDto;
	}

	@Override
	public SecUser createEntity(SecUserForm userForm) {
		SecUser entity = (SecUser) BeanUtil.createAndCopyPropertiesNative(userForm, SecUser.class);
		return entity;
	}

	@Override
	public void updateEntity(SecUser entity, SecUserForm userForm) throws RuntimeException {
		userForm.setId(entity.getId());
		BeanUtil.copyPropertiesNative(userForm, entity);
	}

}