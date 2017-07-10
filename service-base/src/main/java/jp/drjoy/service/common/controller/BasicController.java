package jp.drjoy.service.common.controller;

import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.drjoy.service.common.controller.impl.BaseControllerImpl;
import jp.drjoy.service.common.dto.DTO;
import jp.drjoy.service.common.dto.IdDto;
import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.common.util.BeanUtil;
import jp.drjoy.service.common.util.Envelope;
import jp.drjoy.service.common.util.FormError;
import jp.drjoy.service.common.util.ListJson;
import jp.drjoy.service.common.util.Meta;

/**
 * The Class BaseController.
 *
 * @param <baseForm> the generic type
 */
public abstract class BasicController<BaseForm extends DTO<? extends Serializable>, BaseDxoDto extends DTO<? extends Serializable>, BaseRstDto extends DTO<? extends Serializable>> extends BaseControllerImpl implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	protected abstract Class<BaseDxoDto> getClassOfBaseDxo();

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	protected abstract BaseService<BaseForm, BaseDxoDto, BaseRstDto> getService();

	/** The value. */
	HashMap<String, Object> value = new HashMap<String, Object>();

	/**
	 * Creates the.
	 *
	 * @param baseForm the base dto
	 * @param result the result
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public final ResponseEntity<?> create(@RequestBody @Valid BaseForm baseForm
										, BindingResult result
										, HttpServletRequest request) {

		// msgListError
		if (!FormError.bindingResult(result).isEmpty()) {
			return new ResponseEntity<Object>(FormError.bindingResult(result), HttpStatus.EXPECTATION_FAILED);
		}
		return _create(baseForm, request);
	}

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param baseForm the base dto
	 * @param result the result
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public final ResponseEntity<?> update(@PathVariable Long id
										, @RequestBody @Valid BaseForm baseForm
										, BindingResult result
										, HttpServletRequest request) {

		// msgListError
		if (!FormError.bindingResult(result).isEmpty()) {
			return new ResponseEntity<Object>(FormError.bindingResult(result), HttpStatus.EXPECTATION_FAILED);
		}

		return _update(id, baseForm, request);
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public final ResponseEntity<?> findOne(@PathVariable Long id, HttpServletRequest request) {
		return _findOne(id, request);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public final ResponseEntity<?> delete(@PathVariable Long id, HttpServletRequest request) {
		return _delete(id, request);
	}

	/**
	 * Find all.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public final ResponseEntity<?> findAll(HttpServletRequest request) {
		return _findAll(request);
	}

	/**
	 * Creates the.
	 *
	 * @param baseForm the base dto
	 * @param request the request
	 * @return the response entity
	 */
	protected ResponseEntity<?> _create(BaseForm baseForm, HttpServletRequest request) {
		String entityId;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unchecked")
			BaseDxoDto baseDxoDto = (BaseDxoDto) BeanUtil.createAndCopyPropertiesNative(baseForm, getClassOfBaseDxo());
			entityId = getService().create(baseDxoDto);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		if (entityId == null) {
			throw new UnsupportedOperationException("error when create");
		}

		return new Envelope(new IdDto(entityId)).toResponseEntity(HttpStatus.OK);
	}

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param baseForm the base dto
	 * @param request the request
	 * @return the response entity
	 */
	protected ResponseEntity<?> _update(Long id, BaseForm baseForm, HttpServletRequest request) {
		String entityId;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unchecked")
			BaseDxoDto baseDxoDto = (BaseDxoDto) BeanUtil.createAndCopyPropertiesNative(baseForm, getClassOfBaseDxo());
			entityId = getService().update(id, baseDxoDto);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		if (entityId == null) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}

		return new Envelope(new IdDto(entityId)).toResponseEntity(HttpStatus.OK);
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	protected ResponseEntity<?> _findOne(Long id, HttpServletRequest request) {
		BaseRstDto baseRstDto;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			baseRstDto = getService().findOne(id);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}

		if (baseRstDto == null) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		return new Envelope(baseRstDto).toResponseEntity(HttpStatus.OK);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	protected ResponseEntity<?> _delete(Long id, HttpServletRequest request) {
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			getService().delete(id);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}

		return new Envelope(Meta.OK).toResponseEntity(HttpStatus.OK);
	}

	/**
	 * Find all.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	protected ResponseEntity<?> _findAll(HttpServletRequest request) {
		ListJson<BaseRstDto> baseRstDtos;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			baseRstDtos = getService().findAll();
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		return new Envelope(baseRstDtos).toResponseEntity(HttpStatus.OK);
	}

}
