package jp.drjoy.service.common.service;

import java.io.Serializable;

import jp.drjoy.service.common.dto.DTO;
import jp.drjoy.service.common.util.ListJson;

public interface BaseService<BaseForm extends DTO<? extends Serializable>
							, BaseDxoDto extends DTO<? extends Serializable>
							, BaseRstDto extends DTO<? extends Serializable>>
					extends Serializable {

	public ListJson<BaseRstDto> findAll();

	public BaseRstDto findOne(Object id);

	public String create(BaseDxoDto baseDxoDto);

	public void delete(Object id);

	public String update(Object id, BaseDxoDto baseDxoDto);

}
