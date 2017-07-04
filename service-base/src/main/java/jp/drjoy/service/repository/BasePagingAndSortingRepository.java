package jp.drjoy.service.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasePagingAndSortingRepository<T, ID extends Serializable> {

	public Iterable<T> findAll(Sort sort);

	public Page<T> findAll(Pageable pageable);

	public <S extends T> S save(S entity);

	public <S extends T> Iterable<S> save(Iterable<S> entities);

	public T findOne(ID id);

	public boolean exists(ID id);

	public Iterable<T> findAll();

	public Iterable<T> findAll(Iterable<ID> ids);

	public long count();

	public void delete(ID id);

	public void delete(T entity);

	public void delete(Iterable<? extends T> entities);

	public void deleteAll();
}
