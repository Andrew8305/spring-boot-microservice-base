package jp.drjoy.service.registration.service;

import java.util.List;

import jp.drjoy.service.registration.dto.dxo.R001DxoDto;
import jp.drjoy.service.registration.dto.rst.R001RstDto;
import jp.drjoy.service.registration.entitygenerate.SecUser;

public interface IR001Service {
	List<SecUser> getAllSecUser();
	String add(R001DxoDto dxo);
	List<R001RstDto> getAllSecUserRole(R001DxoDto dxo);
}
