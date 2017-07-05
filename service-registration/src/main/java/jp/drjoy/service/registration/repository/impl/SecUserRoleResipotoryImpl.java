package jp.drjoy.service.registration.repository.impl;

import org.springframework.stereotype.Repository;

import jp.drjoy.service.common.repository.impl.BaseRepositoryImpl;
import jp.drjoy.service.registration.entity.SecUserRole;
import jp.drjoy.service.registration.repository.SecUserRoleRepository;

@Repository
public class SecUserRoleResipotoryImpl extends BaseRepositoryImpl<SecUserRole, Long> implements SecUserRoleRepository {

}
