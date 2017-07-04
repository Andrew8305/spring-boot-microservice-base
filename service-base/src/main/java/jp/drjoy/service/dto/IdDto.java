package jp.drjoy.service.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class IdDto.
 */
public class IdDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5042675909233566226L;
    
    /** The id. */
    private String id;
    
    /**
     * Instantiates a new id dto.
     *
     * @param id the id
     */
    public IdDto(String id) {
        super();
        
        this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }
}
