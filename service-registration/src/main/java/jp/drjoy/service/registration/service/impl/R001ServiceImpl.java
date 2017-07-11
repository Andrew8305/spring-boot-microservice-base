package jp.drjoy.service.registration.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.drjoy.service.registration.dto.prm.R001Prm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.drjoy.service.common.util.BeanUtil;
import jp.drjoy.service.registration.dto.dxo.R001DxoDto;
import jp.drjoy.service.registration.dto.rst.R001RstDto;
import jp.drjoy.service.registration.entity.R001Entity;
import jp.drjoy.service.registration.entitygenerate.SecRole;
import jp.drjoy.service.registration.entitygenerate.SecUser;
import jp.drjoy.service.registration.entitygenerate.SecUserRole;
import jp.drjoy.service.registration.repository.IR001Repository;
import jp.drjoy.service.registration.repository.ISecUserRepository;
import jp.drjoy.service.registration.repository.ISecUserRoleRepository;
import jp.drjoy.service.registration.service.IR001Service;

@Service
public class R001ServiceImpl implements IR001Service {

	@Autowired
	private ISecUserRepository secUserRepository;

	@Autowired
	private IR001Repository r001Repository;

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

		SecUserRole entity = new SecUserRole();
		entity.setSecRole(role);
		entity.setSecUser(user);
		entity.setId(dxo.getSecUserRoleId());
		return secUserRoleRepository.save(entity).getId().toString();
	}

	@Override
	public List<R001RstDto> getAllSecUserRole(R001DxoDto dxo) {
		R001Prm prm = new R001Prm();
		prm.setUserId(dxo.getSecUserId());
		List<R001Entity> rs = r001Repository.getAllSecUserRole(prm);
		List<R001RstDto> r001RstDtos = new ArrayList<>();
		for (R001Entity entity : rs) {
			r001RstDtos.add((R001RstDto) BeanUtil.createAndCopyPropertiesNative(entity, R001RstDto.class));
		}
		return r001RstDtos;
	}

}