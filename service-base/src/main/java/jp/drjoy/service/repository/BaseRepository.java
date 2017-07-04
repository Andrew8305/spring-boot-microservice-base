package jp.drjoy.service.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
		extends BasePagingAndSortingRepository<T, ID>, BaseQueryByExampleExecutor<T> {

	public List<T> findAll();

	public List<T> findAll(Sort sort);

	public List<T> findAll(Iterable<ID> ids);

	public <S extends T> List<S> save(Iterable<S> entities);

	public void flush();

	public <S extends T> S saveAndFlush(S entity);

	public void deleteInBatch(Iterable<T> entities);

	public void deleteAllInBatch();

	public T getOne(ID id);

	@Override
	public <S extends T> List<S> findAll(Example<S> example);

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort);

}
