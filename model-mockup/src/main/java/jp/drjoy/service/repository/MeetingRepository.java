package jp.drjoy.service.repository;

import jp.drjoy.service.model.meeting.Meeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gmaeda on 2017/06/06.
 */
@Repository
public interface MeetingRepository extends MongoRepository<Meeting, String> {
}
