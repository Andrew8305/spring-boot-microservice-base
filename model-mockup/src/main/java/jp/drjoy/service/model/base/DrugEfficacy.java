package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 薬効分類
 */
@Entity
@Table(name = "drug_efficacies")
public class DrugEfficacy {
    /**
     * 薬効分類ID
     */
    @Id @GeneratedValue
    private int id;

    /**
     * 薬効分類名
     */
    private String efficacyName;

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

    public String getEfficacyName() {
        return efficacyName;
    }

    public void setEfficacyName(String efficacyName) {
        this.efficacyName = efficacyName;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
