package jp.drjoy.service.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.drjoy.service.common.controller.BasicController;
import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.registration.dto.dxo.SecUserRoleDxoDto;
import jp.drjoy.service.registration.dto.form.SecUserRoleForm;
import jp.drjoy.service.registration.dto.rst.SecUserRoleRstDto;
import jp.drjoy.service.registration.service.ISecUserRoleService;

@RestController
@RequestMapping("userRole")
public class UserRoleController extends BasicController<SecUserRoleForm, SecUserRoleDxoDto, SecUserRoleRstDto> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ISecUserRoleService userRoleService;

	@Override
	protected BaseService<SecUserRoleForm, SecUserRoleDxoDto, SecUserRoleRstDto> getService() {
		return userRoleService;
	}

	@Override
	protected Class<SecUserRoleDxoDto> getClassOfBaseDxo() {
		return SecUserRoleDxoDto.class;
	}

}
