package jp.drjoy.service.registration.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import jp.drjoy.service.common.repository.impl.BaseRepositoryImpl;
import jp.drjoy.service.registration.dto.TimesheetsDto;
import jp.drjoy.service.registration.entity.Timesheets;
import jp.drjoy.service.registration.repository.TimesheetRepository;

@Repository
public class TimeSheetResipotoryImpl extends BaseRepositoryImpl<Timesheets, Long> implements TimesheetRepository {

	@Override
	public List<Timesheets> findTimeSheetsByTypeAndContent(TimesheetsDto timesheetsDto) {

		StringBuilder sql = new StringBuilder("select time FROM Timesheets time ");
		sql.append("where time.type = :type ");
		sql.append("and time.content = :content");

		TypedQuery<Timesheets> query = getEntityManager().createQuery(sql.toString(), Timesheets.class);

		query.setParameter("type", Integer.parseInt(timesheetsDto.getType()));

		query.setParameter("content", timesheetsDto.getContent());

		List<Timesheets> timesheets = query.getResultList();

		return timesheets;
	}

}
