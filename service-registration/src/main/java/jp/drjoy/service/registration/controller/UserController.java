package jp.drjoy.service.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.drjoy.service.common.controller.BasicController;
import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.registration.dto.dxo.SecUserDxoDto;
import jp.drjoy.service.registration.dto.form.SecUserForm;
import jp.drjoy.service.registration.dto.rst.SecUserRstDto;
import jp.drjoy.service.registration.service.ISecUserService;

@RestController
@RequestMapping("user")
public class UserController extends BasicController<SecUserForm, SecUserDxoDto, SecUserRstDto> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ISecUserService secUserService;

	@Override
	protected BaseService<SecUserForm, SecUserDxoDto, SecUserRstDto> getService() {
		return secUserService;
	}

	@Override
	protected Class<SecUserDxoDto> getClassOfBaseDxo() {
		return SecUserDxoDto.class;
	}

}
