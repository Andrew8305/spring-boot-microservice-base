package jp.drjoy.service.common.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import jp.drjoy.service.common.dto.DTO;
import jp.drjoy.service.common.dto.PO;
import jp.drjoy.service.common.repository.BaseRepository;
import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.common.util.ListJson;

public abstract class BaseServiceImpl<Entity extends PO<Long>
									, BaseForm extends DTO<? extends Serializable>
									, BaseDxoDto extends DTO<? extends Serializable>
									, BaseRstDto extends DTO<? extends Serializable>>
						implements BaseService<BaseForm, BaseDxoDto, BaseRstDto> {

	private static final long serialVersionUID = 1L;

	public abstract BaseRepository<Entity, Long> getRepository();

	public abstract BaseRstDto createBaseDto(Entity entity, Long size);

	public abstract Entity createEntity(BaseDxoDto baseDxoDto);

	public abstract void updateEntity(Entity entity, BaseDxoDto baseDxoDto) throws RuntimeException;

	public static final Sort DEFAULT_SORT = new Sort(new Order(Direction.ASC, PO.COLUMNNAME_ID));

	@Override
	public ListJson<BaseRstDto> findAll() {

		List<BaseRstDto> baseDtos = new ArrayList<>();

		List<Entity> entitys = getRepository().findAll(DEFAULT_SORT);
		Long size = Long.valueOf(entitys.size());
		for (Entity entity : entitys) {
			baseDtos.add(createBaseDto(entity, size));
		}
		return new ListJson<BaseRstDto>(baseDtos, Long.valueOf(baseDtos.size()));
	}

	@Override
	public BaseRstDto findOne(Object _id) {

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

	@Override
	public String create(BaseDxoDto baseDxoDto) {

		Entity entity = createEntity(baseDxoDto);
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

	@Override
	public String update(Object _id, BaseDxoDto baseDxoDto) throws RuntimeException {
		Long id = parse(_id, null);
		if (id == null) {
			throw new RuntimeException();
		}

		Entity entity = getRepository().findOne(id);
		if (entity == null) {
			throw new RuntimeException();
		}
		updateEntity(entity, baseDxoDto);
		entity = getRepository().save(entity);
		return entity.getId().toString();
	}

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

	protected ListJson<BaseRstDto> paging(Integer page, Integer size, List<BaseRstDto> list) {
		long resultSize = list.size();

		List<BaseRstDto> listAfterPagingDto = new ArrayList<BaseRstDto>();

		if (page != null && size != null && size > 0) {
			int begin = page * size;
			int end = page * size + size;

			if (begin > resultSize)
				return new ListJson<BaseRstDto>(listAfterPagingDto, resultSize);
			else if (end > resultSize) {
				end = (int) resultSize;
			}
			listAfterPagingDto = list.subList(begin, end);
		} else
			return new ListJson<BaseRstDto>(list, resultSize);
		return new ListJson<BaseRstDto>(listAfterPagingDto, resultSize);
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
