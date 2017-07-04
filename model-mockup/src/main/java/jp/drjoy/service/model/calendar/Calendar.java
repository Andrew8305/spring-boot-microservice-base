package jp.drjoy.service.model.calendar;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * カレンダー
 */
@Document
public class Calendar {
    @Id
    private String id;

    /**
     * 事業所ID
     * #registration.Office.id
     */
    private String officeId;

    /**
     * オフィスユーザーID
     * #registration.OfficeUser.id
     */
    private String officeUserId;

    /**
     * グループID
     * #group.Group.id
     */
    private String groupId;

    /**
     * カレンダー区分
     */
    private CalendarType calendarType;

    /**
     * 外部接続区分
     */
    private ExternalType externalType;

    /**
     * 表示色（Webカラーコード）
     */
    private String color;

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

    public CalendarType getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(CalendarType calendarType) {
        this.calendarType = calendarType;
    }

    public ExternalType getExternalType() {
        return externalType;
    }

    public void setExternalType(ExternalType externalType) {
        this.externalType = externalType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static class OAuthToken {
        private String userId;
        private String syncToken;
    }

    public enum CalendarType {
        SELF,
        GROUP,
        EXTERNAL
    }

    public enum ExternalType {
        GOOGLE,
        OUTLOOK,
        GAROON
    }
}
