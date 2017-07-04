package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 薬剤総称名
 */
@Entity
@Table(name = "drug_generic_names")
public class DrugGenericName {
    @Id @GeneratedValue
    private int id;

    private String genericName;

    private String genericNameKana;

    private Date deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getGenericNameKana() {
        return genericNameKana;
    }

    public void setGenericNameKana(String genericNameKana) {
        this.genericNameKana = genericNameKana;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
