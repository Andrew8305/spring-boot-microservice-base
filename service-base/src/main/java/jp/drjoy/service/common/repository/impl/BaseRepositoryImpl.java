package jp.drjoy.service.common.repository.impl;

import java.io.Serializable;

import jp.drjoy.service.common.repository.AbstractRepository;
import jp.drjoy.service.common.repository.BaseRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends AbstractRepository<T, ID> implements BaseRepository<T, ID> {

}