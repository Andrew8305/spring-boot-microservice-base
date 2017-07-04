package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 医療機関マスタ
 */
@Entity
@Table(name = "medical_offices")
public class MedicalOffice {
    /**
     * 医療機関マスタID
     */
    @Id
    @GeneratedValue
    private int id;
    /**
     * 医療機関名称
     */
    private String name;
    /**
     * 医療機関名称かな
     */
    private String nameKana;
    /**
     * 医療機関名称(イニシャル)
     */
    private String nameInitial;
    /**
     * 医療機関郵便番号
     */
    private String postalCode;
    /**
     * 医療機関所在地
     */
    private String address;
    /**
     * 電話番号
     */
    private String phoneNumber;
    /**
     * 開設者氏名
     */
    private String establisherName;
    /**
     * 管理者氏名
     */
    private String administratorName;
    /**
     * 病院又は診療所の別
     */
    private String type;
    /**
     * 病床数
     */
    private String numberOfBeds;
    /**
     * 診療科
     */
    private String hospitalDepartment;
    /**
     * 医科または歯科の別
     */
    private String subject;
    /**
     * 医療機関番号
     */
    private String medicalOfficeNumber;
    /**
     * 都道府県コード
     */
    private String prefectureCode;
    /**
     * 削除フラグ
     */
    private boolean deleteFlag;

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEstablisherName() {
        return establisherName;
    }

    public void setEstablisherName(String establisherName) {
        this.establisherName = establisherName;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(String numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getHospitalDepartment() {
        return hospitalDepartment;
    }

    public void setHospitalDepartment(String hospitalDepartment) {
        this.hospitalDepartment = hospitalDepartment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMedicalOfficeNumber() {
        return medicalOfficeNumber;
    }

    public void setMedicalOfficeNumber(String medicalOfficeNumber) {
        this.medicalOfficeNumber = medicalOfficeNumber;
    }

    public String getPrefectureCode() {
        return prefectureCode;
    }

    public void setPrefectureCode(String prefectureCode) {
        this.prefectureCode = prefectureCode;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
