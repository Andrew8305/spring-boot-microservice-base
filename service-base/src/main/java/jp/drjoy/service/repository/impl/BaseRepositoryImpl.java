package jp.drjoy.service.repository.impl;

import java.io.Serializable;

import jp.drjoy.service.repository.BaseRepository;
import jp.drjoy.service.repository.BaseSimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends BaseSimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {


}