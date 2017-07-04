package jp.drjoy.service.model.calendar;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * カレンダーイベント
 */
@Document
public class Event {
    @Id
    private String id;

    private String officeId;

    private String officeUserId;

    private Date start;

    private String end;

    private Boolean allDay;

    private String repeatRule;

    private PublishType publishType;

    private PublishType meetingPublishType;

    private String title;

    private String place;

    private String node;

    private Date deleted;

    private Date created;

    private Date modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getOfficeUserId() {
        return officeUserId;
    }

    public void setOfficeUserId(String officeUserId) {
        this.officeUserId = officeUserId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public String getRepeatRule() {
        return repeatRule;
    }

    public void setRepeatRule(String repeatRule) {
        this.repeatRule = repeatRule;
    }

    public PublishType getPublishType() {
        return publishType;
    }

    public void setPublishType(PublishType publishType) {
        this.publishType = publishType;
    }

    public PublishType getMeetingPublishType() {
        return meetingPublishType;
    }

    public void setMeetingPublishType(PublishType meetingPublishType) {
        this.meetingPublishType = meetingPublishType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public enum PublishType {
        DISPLAY_AS_BUSY,
        INVISIBLE
    }
}
