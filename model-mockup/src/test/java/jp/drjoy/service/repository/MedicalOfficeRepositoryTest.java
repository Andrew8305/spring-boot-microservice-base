package jp.drjoy.service.repository;

import jp.drjoy.service.model.base.MedicalOffice;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by gmaeda on 2017/06/06.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalOfficeRepositoryTest {
    @Autowired
    private MedicalOfficeRepository medicalOfficeRepository;

    @Test
    public void insert() throws Exception {
        MedicalOffice sample = new MedicalOffice();
        MedicalOffice sample2 = new MedicalOffice();
        medicalOfficeRepository.save(sample);
        medicalOfficeRepository.save(sample2);
        long count = medicalOfficeRepository.count();
        assertThat(count, is(2L));
    }
}