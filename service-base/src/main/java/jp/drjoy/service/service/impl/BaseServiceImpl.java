package jp.drjoy.service.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import jp.drjoy.service.dto.DTO;
import jp.drjoy.service.dto.PO;
import jp.drjoy.service.repository.BaseRepository;
import jp.drjoy.service.service.BaseService;
import jp.drjoy.service.util.common.ListJson;

public abstract class BaseServiceImpl<Entity extends PO<Long>, BaseDto extends DTO<? extends Serializable>>
		implements BaseService<BaseDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract BaseRepository<Entity, Long> getRepository();

	public abstract BaseDto createBaseDto(Entity entity, Long size);

	public abstract Entity createEntity(BaseDto baseDtos);

	public abstract void updateEntity(Entity entity, BaseDto baseDtos) throws RuntimeException;

	public static final Sort DEFAULT_SORT = new Sort(new Order(Direction.ASC, PO.COLUMNNAME_ID));

	// FINDALL
	@Override
	public ListJson<BaseDto> findAll() {

		List<BaseDto> baseDtos = new ArrayList<BaseDto>();

		List<Entity> entitys = getRepository().findAll(DEFAULT_SORT);
		Long size = Long.valueOf(entitys.size());
		for (Entity entity : entitys) {
			baseDtos.add(createBaseDto(entity, size));
		}
		return new ListJson<BaseDto>(baseDtos, Long.valueOf(baseDtos.size()));
	}

	// FINDONE
	@Override
	public BaseDto findOne(Object _id) {

		Long id = parse(_id, null);
		if (id == null) {
			throw new RuntimeException();
		}
		Entity entity = getRepository().findOne(id);
		if (entity == null) {
			throw new RuntimeException();
		}
		return createBaseDto(entity, 1L);
	}

	// CREATE
	@Override
	public String create(BaseDto baseDto) {

		Entity entity = createEntity(baseDto);
		if (entity == null) {
			throw new RuntimeException();
		}
		try {
			entity = getRepository().save(entity);
		} catch (RuntimeException e) {
			throw e;
		}
		return entity.getId().toString();
	}

	// UPDATE
	@Override
	public String update(Object _id, BaseDto baseDto) throws RuntimeException {
		Long id = parse(_id, null);
		if (id == null) {
			throw new RuntimeException();
		}

		Entity entity = getRepository().findOne(id);
		if (entity == null) {
			throw new RuntimeException();
		}
		updateEntity(entity, baseDto);
		entity = getRepository().save(entity);
		return entity.getId().toString();
	}

	// DELETE
	@Override
	public void delete(Object _id) {

		Long id = parse(_id, null);
		if (id == null) {
			throw new RuntimeException();
		}
		try {
			getRepository().delete(id);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	protected ListJson<BaseDto> paging(Integer page, Integer size, List<BaseDto> list) {
		long resultSize = list.size();

		List<BaseDto> listAfterPagingDto = new ArrayList<BaseDto>();

		if (page != null && size != null && size > 0) {
			int begin = page * size;
			int end = page * size + size;

			if (begin > resultSize)
				return new ListJson<BaseDto>(listAfterPagingDto, resultSize);
			else if (end > resultSize) {
				end = (int) resultSize;
			}
			listAfterPagingDto = list.subList(begin, end);
		} else
			return new ListJson<BaseDto>(list, resultSize);
		return new ListJson<BaseDto>(listAfterPagingDto, resultSize);
	}

	public Long parse(Object value, Long defaultValue) {
		if (value == null)
			return defaultValue;

		if (value instanceof Long)
			return (Long) value;

		if (value instanceof Integer)
			return new Long((Integer) value);

		if (value instanceof Float)
			return ((Float) value).longValue();

		if (value instanceof Double)
			return ((Double) value).longValue();

		if (value instanceof BigDecimal)
			return ((BigDecimal) value).longValue();

		if (value instanceof String) {
			try {
				return Long.parseLong((String) value);
			} catch (RuntimeException e) {
				throw e;
			}
		}

		try {
			return Long.parseLong(value.toString());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return defaultValue;
	}

}
