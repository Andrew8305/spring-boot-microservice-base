package jp.drjoy.service.registration.repository;

import java.util.List;

import jp.drjoy.service.common.repository.BaseRepository;
import jp.drjoy.service.registration.dto.TimesheetsDto;
import jp.drjoy.service.registration.entity.Timesheets;

public interface TimesheetRepository extends BaseRepository<Timesheets, Long> {

	public List<Timesheets> findTimeSheetsByTypeAndContent(TimesheetsDto timesheetsDto);

}
