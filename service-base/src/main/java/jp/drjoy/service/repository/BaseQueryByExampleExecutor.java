package jp.drjoy.service.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BaseQueryByExampleExecutor<T> {

	public <S extends T> S findOne(Example<S> example);

	public <S extends T> Iterable<S> findAll(Example<S> example);

	public <S extends T> Iterable<S> findAll(Example<S> example, Sort sort);

	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

	public <S extends T> long count(Example<S> example);

	public <S extends T> boolean exists(Example<S> example);
	
}
