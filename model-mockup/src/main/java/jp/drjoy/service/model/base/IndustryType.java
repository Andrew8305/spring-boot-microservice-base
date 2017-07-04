package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 業種マスタ
 */
@Entity
@Table(name = "industry_type")
public class IndustryType {
    /**
     * システムキー
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * 業種コード
     */
    private String industryCode;

    /**
     * 業種名
     */
    private String name;

    /**
     * 表示順
     */
    private int displayOrder;

    /**
     * 削除日時
     */
    private Date deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
