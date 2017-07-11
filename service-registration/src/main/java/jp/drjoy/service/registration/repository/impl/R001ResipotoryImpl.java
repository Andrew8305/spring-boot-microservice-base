package jp.drjoy.service.registration.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jp.drjoy.service.registration.dto.prm.R001Prm;
import org.springframework.stereotype.Repository;

import jp.drjoy.service.common.repository.impl.BaseRepositoryImpl;
import jp.drjoy.service.registration.entity.R001Entity;
import jp.drjoy.service.registration.entitygenerate.SecUserRole;
import jp.drjoy.service.registration.repository.IR001Repository;

@Repository
public class R001ResipotoryImpl extends BaseRepositoryImpl<SecUserRole, Long> implements IR001Repository {
	public List<R001Entity> getAllSecUserRole(R001Prm prm) {
		List<R001Entity> rs = new ArrayList<>();
		EntityManager entityManager = getEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ")
			.append("	su.ID as userId,")
			.append("	su.username,")
			.append("	sr.ID as roleId")
			.append(" FROM")
			.append("	sec_user_role sur")
			.append(" INNER JOIN sec_user su ON sur.user_id = su. ID")
			.append(" INNER JOIN sec_role sr ON sur.role_id = sr. ID")
			.append(" WHERE")
			.append("	su.id = :pr_su_id");
		
		Query query = entityManager.createNativeQuery(sql.toString());
		query.setParameter("pr_su_id", prm.getUserId());
		@SuppressWarnings("unchecked")
		List<Object[]> set = query.getResultList();
		if (set != null && set.size() > 0) {
			for (int i=0; i< set.size(); i++){
				Long userId= Long.parseLong((set.get(i)[0]).toString());
				String username =(set.get(i)[1]).toString();
				Long roleId = Long.parseLong((set.get(i)[2]).toString());
				rs.add(new R001Entity(userId,username, roleId ));
			}
		}
		return rs;
	}
}
