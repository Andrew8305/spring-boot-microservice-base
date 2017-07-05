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
import jp.drjoy.service.registration.dto.rst.UserRoleRstDto;
import jp.drjoy.service.registration.entity.UserRole;
import jp.drjoy.service.registration.repository.UserRoleRepository;
import jp.drjoy.service.registration.service.IUserRoleService;

@Service("timesheetService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, UserRoleRstDto> implements IUserRoleService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public BaseRepository<UserRole, Long> getRepository() {
		return userRoleRepository;
	}

	@Override
	public UserRoleRstDto createBaseDto(UserRole entity, Long size) {
		UserRoleRstDto simpleDto = new UserRoleRstDto();
		BeanUtil.copyPropertiesNative(entity, simpleDto);
		simpleDto.setCount(size);
		return simpleDto;
	}

	@Override
	public UserRole createEntity(UserRoleRstDto timesheetsDto) {
		UserRole entity = new UserRole();
		BeanUtil.copyPropertiesNative(timesheetsDto, entity);
		return entity;
	}

	@Override
	public void updateEntity(UserRole entity, UserRoleRstDto timesheetsDto) throws RuntimeException {
		timesheetsDto.setId(entity.getId());
		BeanUtil.copyPropertiesNative(timesheetsDto, entity);
	}

}