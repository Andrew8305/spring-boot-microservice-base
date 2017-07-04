package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 業者マスタ
 */
@Entity
@Table(name = "companies")
public class Company {
    /**
     * システムキー
     */
    @Id @GeneratedValue
    private int id;

    /**
     * 業者名
     */
    private String name;

    /**
     * 業者名（カナ）
     */
    private String nameKana;

    /**
     * 業者名（イニシャル）
     */
    private String nameInitial;

    /**
     * 業者名（略称）
     */
    private String shortOfficeName;

    /**
     * 作成日時
     */
    private Date created;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKana() {
        return nameKana;
    }

    public void setNameKana(String nameKana) {
        this.nameKana = nameKana;
    }

    public String getNameInitial() {
        return nameInitial;
    }

    public void setNameInitial(String nameInitial) {
        this.nameInitial = nameInitial;
    }

    public String getShortOfficeName() {
        return shortOfficeName;
    }

    public void setShortOfficeName(String shortOfficeName) {
        this.shortOfficeName = shortOfficeName;
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
}
