package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 事業所区分マスタ
 */
@Entity
@Table(name = "office_types")
public class OfficeType {
    @Id
    private int id;

    /**
     * 区分名
     */
    private String name;

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
}
