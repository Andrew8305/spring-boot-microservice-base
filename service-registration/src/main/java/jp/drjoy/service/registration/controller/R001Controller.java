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

package jp.drjoy.service.registration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.drjoy.service.registration.entity.SecUser;
import jp.drjoy.service.registration.service.IR001Service;

@RestController
@RequestMapping("R001")
public class R001Controller {

	@Autowired
	private IR001Service r001Service;

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param baseDto the base dto
	 * @param result the result
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public final ResponseEntity<List<SecUser>> all(HttpServletRequest request) {
		List<SecUser> baseRstDtos;
		baseRstDtos = r001Service.getAllSecUser();
		return new ResponseEntity<>(baseRstDtos, HttpStatus.OK);
	}

}
