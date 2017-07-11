package jp.drjoy.service.registration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.drjoy.service.common.controller.impl.BaseControllerImpl;
import jp.drjoy.service.common.util.BeanUtil;
import jp.drjoy.service.common.util.Envelope;
import jp.drjoy.service.registration.constant.TrasitionConst;
import jp.drjoy.service.registration.dto.dxo.R001DxoDto;
import jp.drjoy.service.registration.dto.form.R001Form;
import jp.drjoy.service.registration.dto.rst.R001RstDto;
import jp.drjoy.service.registration.service.IR001Service;

@RestController
@RequestMapping(TrasitionConst.API.REGISTRATION.R001)
public class R001Controller extends BaseControllerImpl{

	@Autowired
	private IR001Service r001Service;

	/**
	 * Get All data.
	 *
	 * @param id the id
	 * @param baseDto the base dto
	 * @param result the result
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = ACTION_ALL, method = RequestMethod.GET)
	public final ResponseEntity<?> all(HttpServletRequest request) {
		R001DxoDto dxo = new R001DxoDto();
		dxo.setSecUserId(1l);
		List<R001RstDto> r001RstDto = r001Service.getAllSecUserRole(dxo);
		return (new ResponseEntity<>(r001RstDto, HttpStatus.OK));
	}

	/**
	 * Add.
	 *
	 * @param id the id
	 * @param baseDto the base dto
	 * @param result the result
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = ACTION_ADD, method = RequestMethod.POST)
	public final ResponseEntity<?> add(@RequestBody @Valid R001Form r001Form, HttpServletRequest request) {
		R001DxoDto dxo = (R001DxoDto) BeanUtil.createAndCopyPropertiesNative(r001Form, R001DxoDto.class);
		String rs = r001Service.add(dxo);
		return new Envelope(rs).toResponseEntity(HttpStatus.OK);
	}

}
