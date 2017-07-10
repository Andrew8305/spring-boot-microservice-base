package jp.drjoy.service.registration.service;

import java.util.List;

import jp.drjoy.service.registration.dto.dxo.R001DxoDto;
import jp.drjoy.service.registration.entity.SecUser;

public interface IR001Service {
	List<SecUser> getAllSecUser();
	String add(R001DxoDto dxo);
}
