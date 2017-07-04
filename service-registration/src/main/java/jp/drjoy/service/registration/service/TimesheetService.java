package jp.drjoy.service.registration.service;

import jp.drjoy.service.common.service.BaseService;
import jp.drjoy.service.common.util.ListJson;
import jp.drjoy.service.registration.dto.TimesheetsDto;

public interface TimesheetService extends BaseService<TimesheetsDto> {

	public ListJson<TimesheetsDto> findTimeSheetsByTypeAndContent(TimesheetsDto timesheetsDto);

}
