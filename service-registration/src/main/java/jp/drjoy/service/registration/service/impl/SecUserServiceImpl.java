package jp.drjoy.service.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.drjoy.service.common.repository.BaseRepository;
import jp.drjoy.service.common.service.impl.BaseServiceImpl;
import jp.drjoy.service.common.util.BeanUtil;
import jp.drjoy.service.registration.dto.dxo.SecUserDxoDto;
import jp.drjoy.service.registration.dto.form.SecUserForm;
import jp.drjoy.service.registration.dto.rst.SecUserRstDto;
import jp.drjoy.service.registration.entity.SecUser;
import jp.drjoy.service.registration.repository.ISecUserRepository;
import jp.drjoy.service.registration.service.ISecUserService;

@Service
public class SecUserServiceImpl extends BaseServiceImpl<SecUser, SecUserForm, SecUserDxoDto, SecUserRstDto> implements ISecUserService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ISecUserRepository userRepository;

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
	public SecUser createEntity(SecUserDxoDto baseDxoDto) {
		SecUser entity = (SecUser) BeanUtil.createAndCopyPropertiesNative(baseDxoDto, SecUser.class);
		return entity;
	}

	@Override
	public void updateEntity(SecUser entity, SecUserDxoDto baseDxoDto) throws RuntimeException {
		baseDxoDto.setId(entity.getId());
		BeanUtil.copyPropertiesNative(baseDxoDto, entity);
	}

}