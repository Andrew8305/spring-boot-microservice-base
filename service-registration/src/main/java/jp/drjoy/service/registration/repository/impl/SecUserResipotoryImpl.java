package jp.drjoy.service.registration.repository.impl;

import org.springframework.stereotype.Repository;

import jp.drjoy.service.common.repository.impl.BaseRepositoryImpl;
import jp.drjoy.service.registration.entity.SecUser;
import jp.drjoy.service.registration.repository.SecUserRepository;

@Repository
public class SecUserResipotoryImpl extends BaseRepositoryImpl<SecUser, Long> implements SecUserRepository {

}
