package jp.drjoy.service.common.repository.impl;

import java.io.Serializable;

import jp.drjoy.service.common.repository.BaseRepository;
import jp.drjoy.service.common.repository.BaseSimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends BaseSimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {


}