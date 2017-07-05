package jp.drjoy.service.registration.repository.impl;

import org.springframework.stereotype.Repository;

import jp.drjoy.service.common.repository.impl.BaseRepositoryImpl;
import jp.drjoy.service.registration.entity.UserRole;
import jp.drjoy.service.registration.repository.UserRoleRepository;

@Repository
public class UserRoleResipotoryImpl extends BaseRepositoryImpl<UserRole, Long> implements UserRoleRepository {

}
