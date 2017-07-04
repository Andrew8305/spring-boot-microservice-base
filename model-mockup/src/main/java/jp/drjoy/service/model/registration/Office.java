package jp.drjoy.service.model.registration;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * 利用登録済みの事業所
 * Dr.JOY/Pr.JOY共通
 */
@Document
public class Office {
    /**
     * 事業所ID（旧システムのoffices.idから移行する）
     */
    @Id
    private String id;

    /**
     * 業者マスタID（医療機関でない場合）
     * baseサービスを参照
     */
    private Integer companyId;

    /**
     * 医療機関マスタID（医療機関の場合）
     * baseサービスを参照
     */
    private Integer medicalOfficeId;

    /**
     * オフィス名称
     */
    private String officeName;

    /**
     * オフィス名称（カナ）
     */
    private String officeNameKana;

    /**
     * オフィス名称（イニシャル）
     */
    private String officeNameInitial;

    /**
     * 事業所区分
     */
    private OfficeType officeType;

    /**
     * 代表者ユーザーID
     */
    private int presidentUserId;

    /**
     * 郵便番号
     */
    private String postalCode;

    /**
     * 都道府県コード
     */
    private String prefCode;

    /**
     * 住所1
     */
    private String address1;

    /**
     * 住所2
     */
    private String address2;

    /**
     * 電話番号
     */
    private String phoneNo;

    /**
     * FAX番号
     */
    private String faxNo;

    /**
     * 代表メールアドレス
     */
    private String mailAddress;

    /**
     * ホームページURL
     */
    private String homepageUrl;

    /**
     * ブログURL
     */
    private String blogUrl;

    /**
     * Facebookアカウント
     */
    private String snsFacebook;

    /**
     * Twitterアカウント
     */
    private String snsTwitter;

    /**
     * 診療時間
     */
    private String consultationHour;

    /**
     * 会社からのメッセージ
     */
    private String message;

    /**
     * カバー写真
     */
    private int coverImageId;

    /**
     * 作成日時
     */
    private Date created;

    /**
     * 削除日時
     */
    private Date deleted;
    /**
     * 組織構造
     */
    private Node organization;

    public Node getOrganization() {
        return organization;
    }

    public void setOrganization(Node organization) {
        this.organization = organization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getMedicalOfficeId() {
        return medicalOfficeId;
    }

    public void setMedicalOfficeId(Integer medicalOfficeId) {
        this.medicalOfficeId = medicalOfficeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeNameKana() {
        return officeNameKana;
    }

    public void setOfficeNameKana(String officeNameKana) {
        this.officeNameKana = officeNameKana;
    }

    public String getOfficeNameInitial() {
        return officeNameInitial;
    }

    public void setOfficeNameInitial(String officeNameInitial) {
        this.officeNameInitial = officeNameInitial;
    }

    public int getPresidentUserId() {
        return presidentUserId;
    }

    public void setPresidentUserId(int presidentUserId) {
        this.presidentUserId = presidentUserId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrefCode() {
        return prefCode;
    }

    public void setPrefCode(String prefCode) {
        this.prefCode = prefCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getSnsFacebook() {
        return snsFacebook;
    }

    public void setSnsFacebook(String snsFacebook) {
        this.snsFacebook = snsFacebook;
    }

    public String getSnsTwitter() {
        return snsTwitter;
    }

    public void setSnsTwitter(String snsTwitter) {
        this.snsTwitter = snsTwitter;
    }

    public String getConsultationHour() {
        return consultationHour;
    }

    public void setConsultationHour(String consultationHour) {
        this.consultationHour = consultationHour;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCoverImageId() {
        return coverImageId;
    }

    public void setCoverImageId(int coverImageId) {
        this.coverImageId = coverImageId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    /**
     * 所属
     */
    public static class Node {
        private String id;
        /**
         * 所属名
         */
        private String name;
        /**
         * 所属名（カナ）
         */
        private String nameKana;
        /**
         * サブ表示
         */
        private String subName;
        /**
         * 小階層の所属
         */
        private List<?> children;

        public Node() {
        }

        public Node(String id, String name, String nameKana) {
            this.id = id;
            this.name = name;
            this.nameKana = nameKana;
        }

        public List<?> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }
    }

    /**
     * 事業所区分
     */
    public enum OfficeType {
        /**
         * 医療機関
         */
        MEDICAL,
        /**
         * 製薬企業
         */
        PHARMACY,
        /**
         * その他
         */
        OTHER
    }
}
