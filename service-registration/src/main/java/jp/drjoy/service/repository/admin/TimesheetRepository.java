package jp.drjoy.service.repository.admin;

import java.util.List;

import jp.drjoy.service.dto.admin.TimesheetsDto;
import jp.drjoy.service.entity.Timesheets;
import jp.drjoy.service.repository.BaseRepository;

public interface TimesheetRepository extends BaseRepository<Timesheets, Long> {

	public List<Timesheets> findTimeSheetsByTypeAndContent(TimesheetsDto timesheetsDto);

}
