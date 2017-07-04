package jp.drjoy.service.controller.base;

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

import jp.drjoy.service.dto.DTO;
import jp.drjoy.service.dto.IdDto;
import jp.drjoy.service.service.BaseService;
import jp.drjoy.service.util.common.Envelope;
import jp.drjoy.service.util.common.FormError;
import jp.drjoy.service.util.common.ListJson;
import jp.drjoy.service.util.common.Meta;

/**
 * The Class BaseController.
 *
 * @param <BaseDto> the generic type
 */
public abstract class BaseController<BaseDto extends DTO<? extends Serializable>> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	protected abstract BaseService<BaseDto> getService();

	/** The value. */
	HashMap<String, Object> value = new HashMap<String, Object>();

	/**
	 * Creates the.
	 *
	 * @param baseDto the base dto
	 * @param result the result
	 * @param request the request
	 * @return the response entity
	 */
	// CREATE
	@RequestMapping(value = "", method = RequestMethod.POST)
	public final ResponseEntity<?> create(@RequestBody @Valid BaseDto baseDto, BindingResult result,
			HttpServletRequest request) {

		// msgListError
		if (!FormError.bindingResult(result).isEmpty()) {
			return new ResponseEntity<Object>(FormError.bindingResult(result), HttpStatus.EXPECTATION_FAILED);
		}

		return _create(baseDto, request);
	}

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param baseDto the base dto
	 * @param result the result
	 * @param request the request
	 * @return the response entity
	 */
	// UPDATE
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public final ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid BaseDto baseDto,
			BindingResult result, HttpServletRequest request) {

		// msgListError
		if (!FormError.bindingResult(result).isEmpty()) {
			return new ResponseEntity<Object>(FormError.bindingResult(result), HttpStatus.EXPECTATION_FAILED);
		}

		return _update(id, baseDto, request);
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	// FINDONE
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
	// DELETE
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
	// FINDALL
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public final ResponseEntity<?> findAll(HttpServletRequest request) {
		return _findAll(request);
	}

	/**
	 * Creates the.
	 *
	 * @param baseDto the base dto
	 * @param request the request
	 * @return the response entity
	 */
	// CREATE
	protected ResponseEntity<?> _create(BaseDto baseDto, HttpServletRequest request) {
		String entityId;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			entityId = getService().create(baseDto);
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
	 * @param baseDto the base dto
	 * @param request the request
	 * @return the response entity
	 */
	// UPDATE
	protected ResponseEntity<?> _update(Long id, BaseDto baseDto, HttpServletRequest request) {
		String entityId;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			entityId = getService().update(id, baseDto);
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
	// FINDONE
	protected ResponseEntity<?> _findOne(Long id, HttpServletRequest request) {
		BaseDto baseDto;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			baseDto = getService().findOne(id);
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}

		if (baseDto == null) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		return new Envelope(baseDto).toResponseEntity(HttpStatus.OK);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @param request the request
	 * @return the response entity
	 */
	// DELETE
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
	// FINDALL
	protected ResponseEntity<?> _findAll(HttpServletRequest request) {
		ListJson<BaseDto> baseDtos;
		HashMap<String, Object> value = new HashMap<String, Object>();
		try {
			baseDtos = getService().findAll();
		} catch (RuntimeException e) {
			return new ResponseEntity<Object>(value, HttpStatus.EXPECTATION_FAILED);
		}
		return new Envelope(baseDtos).toResponseEntity(HttpStatus.OK);
	}

}
