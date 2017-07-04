/**
* Copyright (c) Acroquest Technology Co., Ltd. All Rights Reserved.
* Please read the associated COPYRIGHTS file for more details.
*
* THE SOFTWARE IS PROVIDED BY Acroquest Technology Co., Ltd.,
* WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
* CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

package jp.drjoy.service.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.drjoy.service.admin.dto.TimesheetsDto;
import jp.drjoy.service.admin.service.TimesheetService;
import jp.drjoy.service.common.controller.BaseController;
import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.common.util.Envelope;
import jp.drjoy.service.common.util.FormError;
import jp.drjoy.service.common.util.ListJson;

@RestController
@RequestMapping("timesheet")
public class TimesheetController extends BaseController<TimesheetsDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TimesheetService timesheetService;

	@Override
	protected BaseService<TimesheetsDto> getService() {
		return timesheetService;
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	private final ResponseEntity<?> search(@RequestBody @Valid TimesheetsDto timesheetsDto, BindingResult result,
			HttpServletRequest request) {

		ListJson<TimesheetsDto> jsonDtos = new ListJson<TimesheetsDto>();

		// msgListError
		if (!FormError.bindingResult(result).isEmpty()) {
			return new ResponseEntity<Object>(FormError.bindingResult(result), HttpStatus.EXPECTATION_FAILED);
		}

		jsonDtos = timesheetService.findTimeSheetsByTypeAndContent(timesheetsDto);

		return new Envelope(jsonDtos).toResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String demo(){

		return "hello";
	}
}
