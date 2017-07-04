/*
 * Copyright 2008-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.drjoy.service.repository;

import static org.springframework.data.jpa.repository.query.QueryUtils.COUNT_QUERY_STRING;
import static org.springframework.data.jpa.repository.query.QueryUtils.DELETE_ALL_QUERY_STRING;
import static org.springframework.data.jpa.repository.query.QueryUtils.applyAndBind;
import static org.springframework.data.jpa.repository.query.QueryUtils.getQueryString;
import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.data.jpa.repository.query.JpaEntityGraph;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.data.repository.support.PageableExecutionUtils.TotalSupplier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public abstract class BaseSimpleJpaRepository<T, ID extends Serializable> {

	private static final String ID_MUST_NOT_BE_NULL = "The given id must not be null!";

	@PersistenceContext
	private EntityManager entityManager;

	private JpaEntityInformation<T, ?> entityInformation;

	private Class<T> domainClass;

	private CrudMethodMetadata metadata;

	private PersistenceProvider provider;

	static {
		System.out.println("hello");
	}
	public void setRepositoryMethodMetadata(CrudMethodMetadata crudMethodMetadata) {
		this.metadata = crudMethodMetadata;
	}

	protected CrudMethodMetadata getRepositoryMethodMetadata() {
		return metadata;
	}

	@SuppressWarnings("unchecked")
	public BaseSimpleJpaRepository() {

		if (this.domainClass == null) {
			Class<?> superClazz = getClass();
			Type superType = superClazz.getGenericSuperclass();
			while (!(superType instanceof ParameterizedType)) {
				superClazz = superClazz.getSuperclass();
				superType = superClazz.getGenericSuperclass();
			}
			int paraIndex = 0;
			ParameterizedType genericSuperclass = (ParameterizedType) superType;
			this.domainClass = (Class<T>) genericSuperclass.getActualTypeArguments()[paraIndex++];
		}
		
	}

	public EntityManager getEntityManager() {
		this.entityInformation = JpaEntityInformationSupport.getEntityInformation(this.domainClass, this.entityManager);
		return entityManager;
	}

	public List<T> findAll() {
		return getQuery(null, (Sort) null).getResultList();
	}

	protected TypedQuery<T> getQuery(Specification<T> spec, Sort sort) {
		return getQuery(spec, this.domainClass, sort);
	}

	public List<T> findAll(Sort sort) {
		return getQuery(null, sort).getResultList();
	}

	public List<T> findAll(Iterable<ID> ids) {

		if (ids == null || !ids.iterator().hasNext()) {
			return Collections.emptyList();
		}

		if (entityInformation.hasCompositeId()) {

			List<T> results = new ArrayList<T>();

			for (ID id : ids) {
				results.add(findOne(id));
			}

			return results;
		}

		ByIdsSpecification<T> specification = new ByIdsSpecification<T>(entityInformation);
		TypedQuery<T> query = getQuery(specification, (Sort) null);

		return query.setParameter(specification.parameter, ids).getResultList();
	}

	private static final class ByIdsSpecification<T> implements Specification<T> {

		private final JpaEntityInformation<T, ?> entityInformation;
		@SuppressWarnings("rawtypes")
		ParameterExpression<Iterable> parameter;

		public ByIdsSpecification(JpaEntityInformation<T, ?> entityInformation) {
			this.entityInformation = entityInformation;
		}

		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

			Path<?> path = root.get(entityInformation.getIdAttribute());
			parameter = cb.parameter(Iterable.class);
			return path.in(parameter);
		}
	}

	@Transactional
	public <S extends T> List<S> save(Iterable<S> entities) {

		List<S> result = new ArrayList<S>();

		if (entities == null) {
			return result;
		}

		for (S entity : entities) {
			result.add(save(entity));
		}

		return result;
	}

	@Transactional
	public void flush() {

		this.getEntityManager().flush();
	}

	@Transactional
	public <S extends T> S saveAndFlush(S entity) {

		S result = save(entity);
		flush();

		return result;
	}

	@Transactional
	public void deleteInBatch(Iterable<T> entities) {

		Assert.notNull(entities, "The given Iterable of entities not be null!");

		if (!entities.iterator().hasNext()) {
			return;
		}

		applyAndBind(getQueryString(DELETE_ALL_QUERY_STRING, entityInformation.getEntityName()), entities,
				getEntityManager()).executeUpdate();
	}

	@Transactional
	public void deleteAllInBatch() {

		this.getEntityManager().createQuery(getDeleteAllQueryString()).executeUpdate();
	}

	private String getDeleteAllQueryString() {
		return getQueryString(DELETE_ALL_QUERY_STRING, entityInformation.getEntityName());
	}

	public T getOne(ID id) {

		Assert.notNull(id, ID_MUST_NOT_BE_NULL);
		return this.getEntityManager().getReference(this.domainClass, id);
	}

	public <S extends T> List<S> findAll(Example<S> example) {

		return getQuery(new ExampleSpecification<S>(example), example.getProbeType(), (Sort) null).getResultList();
	}

	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {

		return getQuery(new ExampleSpecification<S>(example), example.getProbeType(), sort).getResultList();
	}

	public Page<T> findAll(Pageable pageable) {

		if (null == pageable) {
			return new PageImpl<T>(findAll());
		}

		return findAll((Specification<T>) null, pageable);
	}

	public Page<T> findAll(Specification<T> spec, Pageable pageable) {

		TypedQuery<T> query = getQuery(spec, pageable);
		return pageable == null ? new PageImpl<T>(query.getResultList()) : readPage(query, this.domainClass, pageable, spec);
	}

	protected <S extends T> Page<S> readPage(TypedQuery<S> query, final Class<S> domainClass, Pageable pageable,
			final Specification<S> spec) {

		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());

		return PageableExecutionUtils.getPage(query.getResultList(), pageable, new TotalSupplier() {

			@Override
			public long get() {
				return executeCountQuery(getCountQuery(spec, domainClass));
			}
		});
	}

	private static Long executeCountQuery(TypedQuery<Long> query) {

		Assert.notNull(query, "TypedQuery must not be null!");

		List<Long> totals = query.getResultList();
		Long total = 0L;

		for (Long element : totals) {
			total += element == null ? 0 : element;
		}

		return total;
	}

	protected <S extends T> TypedQuery<Long> getCountQuery(Specification<S> spec, Class<S> domainClass) {

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);

		Root<S> root = applySpecificationToCriteria(spec, domainClass, query);

		if (query.isDistinct()) {
			query.select(builder.countDistinct(root));
		} else {
			query.select(builder.count(root));
		}

		// Remove all Orders the Specifications might have applied
		query.orderBy(Collections.<Order>emptyList());

		return this.getEntityManager().createQuery(query);
	}

	protected TypedQuery<T> getQuery(Specification<T> spec, Pageable pageable) {

		Sort sort = pageable == null ? null : pageable.getSort();
		return getQuery(spec, this.domainClass, sort);
	}

	@Transactional
	public <S extends T> S save(S entity) {

		if (entityInformation.isNew(entity)) {
			this.getEntityManager().persist(entity);
			return entity;
		} else {
			return this.getEntityManager().merge(entity);
		}
	}

	public T findOne(ID id) {

		Assert.notNull(id, ID_MUST_NOT_BE_NULL);

		Class<T> domainType = this.domainClass;

		if (metadata == null) {
			return this.getEntityManager().find(domainType, id);
		}

		LockModeType type = metadata.getLockModeType();

		Map<String, Object> hints = getQueryHints();

		return type == null ? this.getEntityManager().find(domainType, id, hints)
				: this.getEntityManager().find(domainType, id, type, hints);
	}

	public boolean exists(ID id) {

		Assert.notNull(id, ID_MUST_NOT_BE_NULL);

		if (entityInformation.getIdAttribute() == null) {
			return findOne(id) != null;
		}

		String placeholder = provider.getCountQueryPlaceholder();
		String entityName = entityInformation.getEntityName();
		Iterable<String> idAttributeNames = entityInformation.getIdAttributeNames();
		String existsQuery = QueryUtils.getExistsQueryString(entityName, placeholder, idAttributeNames);

		TypedQuery<Long> query = this.getEntityManager().createQuery(existsQuery, Long.class);

		if (!entityInformation.hasCompositeId()) {
			query.setParameter(idAttributeNames.iterator().next(), id);
			return query.getSingleResult() == 1L;
		}

		for (String idAttributeName : idAttributeNames) {

			Object idAttributeValue = entityInformation.getCompositeIdAttributeValue(id, idAttributeName);

			boolean complexIdParameterValueDiscovered = idAttributeValue != null && !query.getParameter(idAttributeName)
					.getParameterType().isAssignableFrom(idAttributeValue.getClass());

			if (complexIdParameterValueDiscovered) {

				// fall-back to findOne(id) which does the proper mapping for
				// the parameter.
				return findOne(id) != null;
			}

			query.setParameter(idAttributeName, idAttributeValue);
		}

		return query.getSingleResult() == 1L;
	}

	public long count() {

		return this.getEntityManager().createQuery(getCountQueryString(), Long.class).getSingleResult();
	}

	private String getCountQueryString() {

		String countQuery = String.format(COUNT_QUERY_STRING, provider.getCountQueryPlaceholder(), "%s");
		return getQueryString(countQuery, entityInformation.getEntityName());
	}

	@Transactional
	public void delete(ID id) {

		Assert.notNull(id, ID_MUST_NOT_BE_NULL);

		T entity = findOne(id);

		if (entity == null) {
			throw new EmptyResultDataAccessException(
					String.format("No %s entity with id %s exists!", entityInformation.getJavaType(), id), 1);
		}

		delete(entity);

	}

	@Transactional
	public void delete(T entity) {

		Assert.notNull(entity, "The entity must not be null!");
		this.getEntityManager()
				.remove(this.getEntityManager().contains(entity) ? entity : this.getEntityManager().merge(entity));

	}

	@Transactional
	public void delete(Iterable<? extends T> entities) {

		Assert.notNull(entities, "The given Iterable of entities not be null!");

		for (T entity : entities) {
			delete(entity);
		}

	}

	@Transactional
	public void deleteAll() {

		for (T element : findAll()) {
			delete(element);
		}

	}

	public <S extends T> S findOne(Example<S> example) {

		try {
			return getQuery(new ExampleSpecification<S>(example), example.getProbeType(), (Sort) null)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Sort sort) {

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<S> query = builder.createQuery(domainClass);

		Root<S> root = applySpecificationToCriteria(spec, domainClass, query);
		query.select(root);

		if (sort != null) {
			query.orderBy(toOrders(sort, root, builder));
		}

		return applyRepositoryMethodMetadata(this.getEntityManager().createQuery(query));
	}

	private <S> TypedQuery<S> applyRepositoryMethodMetadata(TypedQuery<S> query) {

		if (metadata == null) {
			return query;
		}

		LockModeType type = metadata.getLockModeType();
		TypedQuery<S> toReturn = type == null ? query : query.setLockMode(type);

		applyQueryHints(toReturn);

		return toReturn;
	}

	private void applyQueryHints(Query query) {

		for (Entry<String, Object> hint : getQueryHints().entrySet()) {
			query.setHint(hint.getKey(), hint.getValue());
		}
	}

	protected Map<String, Object> getQueryHints() {

		if (metadata.getEntityGraph() == null) {
			return metadata.getQueryHints();
		}

		Map<String, Object> hints = new HashMap<String, Object>();
		hints.putAll(metadata.getQueryHints());

		hints.putAll(Jpa21Utils.tryGetFetchGraphHints(getEntityManager(), getEntityGraph(), this.domainClass));

		return hints;
	}

	private JpaEntityGraph getEntityGraph() {

		String fallbackName = this.entityInformation.getEntityName() + "." + metadata.getMethod().getName();
		return new JpaEntityGraph(metadata.getEntityGraph(), fallbackName);
	}

	private <S, U extends T> Root<U> applySpecificationToCriteria(Specification<U> spec, Class<U> domainClass,
			CriteriaQuery<S> query) {

		Assert.notNull(domainClass, "Domain class must not be null!");
		Assert.notNull(query, "CriteriaQuery must not be null!");

		Root<U> root = query.from(domainClass);

		if (spec == null) {
			return root;
		}

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		Predicate predicate = spec.toPredicate(root, query, builder);

		if (predicate != null) {
			query.where(predicate);
		}

		return root;
	}

	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {

		ExampleSpecification<S> spec = new ExampleSpecification<S>(example);
		Class<S> probeType = example.getProbeType();
		TypedQuery<S> query = getQuery(new ExampleSpecification<S>(example), probeType, pageable);

		return pageable == null ? new PageImpl<S>(query.getResultList()) : readPage(query, probeType, pageable, spec);
	}

	protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Pageable pageable) {

		Sort sort = pageable == null ? null : pageable.getSort();
		return getQuery(spec, domainClass, sort);
	}

	public <S extends T> long count(Example<S> example) {

		return executeCountQuery(getCountQuery(new ExampleSpecification<S>(example), example.getProbeType()));
	}

	public <S extends T> boolean exists(Example<S> example) {

		return !getQuery(new ExampleSpecification<S>(example), example.getProbeType(), (Sort) null).getResultList()
				.isEmpty();
	}

	private static class ExampleSpecification<T> implements Specification<T> {

		private final Example<T> example;

		public ExampleSpecification(Example<T> example) {

			Assert.notNull(example, "Example must not be null!");
			this.example = example;
		}

		@Override
		public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			return QueryByExamplePredicateBuilder.getPredicate(root, cb, example);
		}
	}

}
