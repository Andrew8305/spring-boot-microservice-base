package jp.drjoy.service.admin.repository;

import java.util.List;

import jp.drjoy.service.admin.dto.TimesheetsDto;
import jp.drjoy.service.admin.entity.Timesheets;
import jp.drjoy.service.common.repository.BaseRepository;

public interface TimesheetRepository extends BaseRepository<Timesheets, Long> {

	public List<Timesheets> findTimeSheetsByTypeAndContent(TimesheetsDto timesheetsDto);

}
