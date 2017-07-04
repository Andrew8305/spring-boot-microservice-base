package jp.drjoy.service.repository;

import jp.drjoy.service.model.base.MedicalOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gmaeda on 2017/06/06.
 */
@Repository
public interface MedicalOfficeRepository extends JpaRepository<MedicalOffice, Integer> {
}
