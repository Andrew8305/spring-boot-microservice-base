package jp.drjoy.service.model.meeting;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * 面会
 */
@Document
public class Meeting {
    @Id
    private String id;
}
