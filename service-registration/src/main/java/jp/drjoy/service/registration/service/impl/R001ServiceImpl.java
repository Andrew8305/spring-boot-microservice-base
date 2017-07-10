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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.drjoy.service.registration.dto.dxo.R001DxoDto;
import jp.drjoy.service.registration.entity.SecRole;
import jp.drjoy.service.registration.entity.SecUser;
import jp.drjoy.service.registration.entity.SecUserRole;
import jp.drjoy.service.registration.repository.ISecUserRepository;
import jp.drjoy.service.registration.repository.ISecUserRoleRepository;
import jp.drjoy.service.registration.service.IR001Service;

@Service
public class R001ServiceImpl implements IR001Service {

	@Autowired
	private ISecUserRepository secUserRepository;

	@Autowired
	private ISecUserRoleRepository secUserRoleRepository;

	public List<SecUser> getAllSecUser() {
		return secUserRepository.findAll();
	}

	@Override
	public String add(R001DxoDto dxo) {
		SecUser user = new SecUser();
		user.setId(dxo.getSecUserId());
		user.setUsername(dxo.getSecUserName());
		
		SecRole role = new SecRole();
		role.setId(dxo.getSecRoleId());
		
		SecUserRole entity =new SecUserRole();
		entity.setSecRole(role);
		entity.setSecUser(user);
		entity.setId(dxo.getSecUserRoleId());
		return secUserRoleRepository.save(entity).getId().toString();
	}

}