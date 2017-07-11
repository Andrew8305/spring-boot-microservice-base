package jp.drjoy.service.registration.repository;

import java.util.List;

import jp.drjoy.service.registration.dto.prm.R001Prm;
import jp.drjoy.service.registration.entity.R001Entity;

public interface IR001Repository{
	List<R001Entity> getAllSecUserRole(R001Prm prm);
}
