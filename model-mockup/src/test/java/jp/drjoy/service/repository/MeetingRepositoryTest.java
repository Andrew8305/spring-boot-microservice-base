package jp.drjoy.service.repository;

import jp.drjoy.service.model.meeting.Meeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by gmaeda on 2017/06/06.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingRepositoryTest {
    @Autowired
    private MeetingRepository meetingRepository;

    @Test
    public void insert() {
        meetingRepository.deleteAll();

        Meeting sample = new Meeting();
        meetingRepository.save(sample);
        long count = meetingRepository.count();
        assertThat(count, is(1L));
    }
}
