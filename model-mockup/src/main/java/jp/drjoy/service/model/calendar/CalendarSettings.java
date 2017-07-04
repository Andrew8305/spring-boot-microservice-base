package jp.drjoy.service.model.calendar;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * ユーザーごとのカレンダー設定
 */
@Document
@CompoundIndexes({
    @CompoundIndex(name = "user_idx", def = "{'officeId': 1, 'officeUserId': 1}", unique = true)
})
public class CalendarSettings {
    @Id
    private String id;

    /**
     * 事業所ID
     */
    private String officeId;

    /**
     * 事業所ユーザーID
     */
    private String officeUserId;

    /**
     * デフォルトの表示タイプ
     */
    private DisplayType defaultDisplayType;

    /**
     * 週の始まり
     */
    private BeginningOfWeek beginningOfWeek;

    /**
     * 「マイカレンダー」の共有フラグ
     */
    private Boolean sharingMyCalendar;

    /**
     * 共有レベル設定
     */
    private ShareLevelType shareLevelType;

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

    public DisplayType getDefaultDisplayType() {
        return defaultDisplayType;
    }

    public void setDefaultDisplayType(DisplayType defaultDisplayType) {
        this.defaultDisplayType = defaultDisplayType;
    }

    public BeginningOfWeek getBeginningOfWeek() {
        return beginningOfWeek;
    }

    public void setBeginningOfWeek(BeginningOfWeek beginningOfWeek) {
        this.beginningOfWeek = beginningOfWeek;
    }

    public Boolean getSharingMyCalendar() {
        return sharingMyCalendar;
    }

    public void setSharingMyCalendar(Boolean sharingMyCalendar) {
        this.sharingMyCalendar = sharingMyCalendar;
    }

    public ShareLevelType getShareLevelType() {
        return shareLevelType;
    }

    public void setShareLevelType(ShareLevelType shareLevelType) {
        this.shareLevelType = shareLevelType;
    }

    public enum DisplayType {
        MONTHLY, WEEKLY
    }

    public enum BeginningOfWeek {
        SUNDAY, MONDAY
    }

    public enum ShareLevelType {
        CHANGEABLE, VIEW_ONLY, MASKED_VIEW
    }
}
