package jp.drjoy.service.model.registration;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * 事業所のユーザー
 */
@Document
public class OfficeUser {
    /**
     * 事業所におけるユーザーのID
     * (旧システムのstaffs.idから移行する)
     */
    @Id
    private String id;

    /**
     * 事業所ID
     */
    private String officeId;

    /**
     * 事業所名
     */
    private String officeName;

    /**
     * 所属組織ID
     */
    private String nodeId;

    /**
     * 所属組織名称
     */
    private String nodeName;

    /**
     * 所属組織パス名称
     */
    private String nodePathName;

    /**
     * PHP番号
     */
    private String phsNo;

    /**
     * 顔写真ID
     */
    private int facePhotoId;

    /**
     * 卒業年度 (YYYY)
     */
    private String graduationYear;

    /**
     * 就業開始日付(YYYYMMDD or YYYYMM or YYYY)
     */
    private String hiredDate;

    /**
     * 作成日時
     */
    private Date created;

    /**
     * 削除日時
     */
    private Date deleted;

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

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodePathName() {
        return nodePathName;
    }

    public void setNodePathName(String nodePathName) {
        this.nodePathName = nodePathName;
    }

    public String getPhsNo() {
        return phsNo;
    }

    public void setPhsNo(String phsNo) {
        this.phsNo = phsNo;
    }

    public int getFacePhotoId() {
        return facePhotoId;
    }

    public void setFacePhotoId(int facePhotoId) {
        this.facePhotoId = facePhotoId;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
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
     * 権限区分
     */
    public enum AuthorityType {
        SUPERUSER
    }

    /**
     * 権限クラス
     */
    public static class Authority {
        private AuthorityType type;
        private Boolean allowed;
    }
}
