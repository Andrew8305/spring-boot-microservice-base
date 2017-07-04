package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 薬剤マスタ
 */
@Entity
@Table(name = "drugs")
public class Drug {
    /**
     * システムキー
     */
    @Id @GeneratedValue
    private int id;

    /**
     * JAPICコード
     */
    private String japicCode;

    /**
     * 薬価コード（厚労省コード）
     */
    private String drugCode;

    /**
     * 成分別の区分
     */
    private ComponentType componentType;

    /**
     * 製品名
     */
    private String productName;

    private String productNameKana;

    private String productNameInitial;

    private BigDecimal price;

    private String priceUnit;

    private String salesReleaseDate;

    private int efficacyId;

    private int genericNameId;

    private GenerationType generationType;

    private Date deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJapicCode() {
        return japicCode;
    }

    public void setJapicCode(String japicCode) {
        this.japicCode = japicCode;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNameKana() {
        return productNameKana;
    }

    public void setProductNameKana(String productNameKana) {
        this.productNameKana = productNameKana;
    }

    public String getProductNameInitial() {
        return productNameInitial;
    }

    public void setProductNameInitial(String productNameInitial) {
        this.productNameInitial = productNameInitial;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getSalesReleaseDate() {
        return salesReleaseDate;
    }

    public void setSalesReleaseDate(String salesReleaseDate) {
        this.salesReleaseDate = salesReleaseDate;
    }

    public int getEfficacyId() {
        return efficacyId;
    }

    public void setEfficacyId(int efficacyId) {
        this.efficacyId = efficacyId;
    }

    public int getGenericNameId() {
        return genericNameId;
    }

    public void setGenericNameId(int genericNameId) {
        this.genericNameId = genericNameId;
    }

    public GenerationType getGenerationType() {
        return generationType;
    }

    public void setGenerationType(GenerationType generationType) {
        this.generationType = generationType;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public enum ComponentType {
        NONE("無"),
        INTERNAL("内用薬"),
        INJECTION("注射薬"),
        EXTERNAL("外用薬"),
        DENTAL("歯科用薬剤")
        ;
        private String name;
        private ComponentType(String name) {
            this.name = name;
        }
    }

    public enum GenerationType {
        NONE("無"),
        ORIGINAL("先発品"),
        GENERIC("後発品")
        ;
        private String name;
        private GenerationType(String name) {
            this.name = name;
        }
    }
}
