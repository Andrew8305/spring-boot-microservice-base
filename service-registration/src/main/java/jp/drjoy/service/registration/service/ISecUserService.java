package jp.drjoy.service.registration.service;

import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.registration.dto.dxo.SecUserDxoDto;
import jp.drjoy.service.registration.dto.form.SecUserForm;
import jp.drjoy.service.registration.dto.rst.SecUserRstDto;

public interface ISecUserService extends BaseService<SecUserForm, SecUserDxoDto, SecUserRstDto> {

}
