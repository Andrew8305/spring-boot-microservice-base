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

package jp.drjoy.service.registration.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.drjoy.service.common.repository.BaseRepository;
import jp.drjoy.service.common.service.impl.BaseServiceImpl;
import jp.drjoy.service.common.util.BeanUtil;
import jp.drjoy.service.common.util.ListJson;
import jp.drjoy.service.registration.dto.TimesheetsDto;
import jp.drjoy.service.registration.entity.Timesheets;
import jp.drjoy.service.registration.repository.TimesheetRepository;
import jp.drjoy.service.registration.service.TimesheetService;

@Service("timesheetService")
public class TimesheetServiceImpl extends BaseServiceImpl<Timesheets, TimesheetsDto> implements TimesheetService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Override
	public BaseRepository<Timesheets, Long> getRepository() {
		return timesheetRepository;
	}

	@Override
	public TimesheetsDto createBaseDto(Timesheets entity, Long size) {
		TimesheetsDto simpleDto = new TimesheetsDto();
		BeanUtil.copyPropertiesNative(entity, simpleDto);
		simpleDto.setCount(size);
		return simpleDto;
	}

	@Override
	public Timesheets createEntity(TimesheetsDto timesheetsDto) {
		Timesheets entity = new Timesheets();
		BeanUtil.copyPropertiesNative(timesheetsDto, entity);
		return entity;
	}

	@Override
	public void updateEntity(Timesheets entity, TimesheetsDto timesheetsDto) throws RuntimeException {
		timesheetsDto.setId(entity.getId());
		BeanUtil.copyPropertiesNative(timesheetsDto, entity);
	}

	@Override
	public ListJson<TimesheetsDto> findTimeSheetsByTypeAndContent(TimesheetsDto timesheetsDto) {

		List<Timesheets> listJson = timesheetRepository.findTimeSheetsByTypeAndContent(timesheetsDto);
		List<TimesheetsDto> dtos = new ArrayList<TimesheetsDto>();
		for (Timesheets domain : listJson) {
			TimesheetsDto dto = new TimesheetsDto();
			BeanUtil.copyPropertiesNative(domain, dto);
			dtos.add(dto);
		}
		ListJson<TimesheetsDto> jsonDtos = new ListJson<TimesheetsDto>(dtos, (long) dtos.size());
		return jsonDtos;
	}

}