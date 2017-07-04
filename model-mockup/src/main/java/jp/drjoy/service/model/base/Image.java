package jp.drjoy.service.model.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 画像データ
 */
@Entity
@Table(name = "images")
public class Image {
    @Id @GeneratedValue
    private int id;

    /**
     * ファイル名
     */
    private String fileName;

    /**
     * Content-Type
     */
    private String contentType;

    /**
     * 作成日時
     */
    private Date created;

    /**
     * 削除日時
     */
    private Date deleted;

    /**
     * 作成者ユーザーID
     */
    private int creatorUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public int getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(int creatorUserId) {
        this.creatorUserId = creatorUserId;
    }
}
