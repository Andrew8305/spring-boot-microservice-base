package jp.drjoy.service.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.drjoy.service.common.repository.BaseRepository;
import jp.drjoy.service.common.service.impl.BaseServiceImpl;
import jp.drjoy.service.common.util.BeanUtil;
import jp.drjoy.service.registration.dto.dxo.SecUserRoleDxoDto;
import jp.drjoy.service.registration.dto.form.SecUserRoleForm;
import jp.drjoy.service.registration.dto.rst.SecUserRoleRstDto;
import jp.drjoy.service.registration.entity.SecRole;
import jp.drjoy.service.registration.entity.SecUser;
import jp.drjoy.service.registration.entity.SecUserRole;
import jp.drjoy.service.registration.repository.ISecUserRoleRepository;
import jp.drjoy.service.registration.service.ISecUserRoleService;

@Service("userRoleService")
public class SecUserRoleServiceImpl extends BaseServiceImpl<SecUserRole
															, SecUserRoleForm
															, SecUserRoleDxoDto
															, SecUserRoleRstDto> 
									implements ISecUserRoleService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ISecUserRoleRepository userRoleRepository;

	@Override
	public BaseRepository<SecUserRole, Long> getRepository() {
		return userRoleRepository;
	}

	@Override
	public SecUserRoleRstDto createBaseDto(SecUserRole entity, Long size) {
		SecUserRoleRstDto simpleDto = (SecUserRoleRstDto) BeanUtil.createAndCopyPropertiesNative(entity
																								, SecUserRoleRstDto.class);
		simpleDto.setSecRoleRstDto((SecUserRoleRstDto.SecRoleRstDto) BeanUtil.createAndCopyPropertiesNative(entity.getSecRole()
																											, SecUserRoleRstDto.SecRoleRstDto.class));
		simpleDto.setCount(size);
		return simpleDto;
	}

	@Override
	public SecUserRole createEntity(SecUserRoleDxoDto baseDxoDto) {
		SecUserRole entity = (SecUserRole) BeanUtil.createAndCopyPropertiesNative(baseDxoDto, SecUserRole.class);
		SecUser user = new SecUser();
		user.setId(1l);
		SecRole role =new SecRole();
		role.setId(1l);
		entity.setSecUser(user);
		entity.setSecRole(role);
		return entity;
	}

	@Override
	public void updateEntity(SecUserRole entity, SecUserRoleDxoDto secUserRoleDxoDto) throws RuntimeException {
		secUserRoleDxoDto.setId(entity.getId());
		BeanUtil.copyPropertiesNative(secUserRoleDxoDto, entity);
	}

}