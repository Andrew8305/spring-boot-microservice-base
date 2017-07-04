package jp.drjoy.service.service;

import java.io.Serializable;

import jp.drjoy.service.dto.DTO;
import jp.drjoy.service.util.common.ListJson;

public interface BaseService<BaseDto extends DTO<? extends Serializable>> extends Serializable {

	public ListJson<BaseDto> findAll();

	public BaseDto findOne(Object id);

	public String create(BaseDto baseDto);

	public void delete(Object id);

	public String update(Object id, BaseDto dto);

}
