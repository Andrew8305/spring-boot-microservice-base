package jp.drjoy.service.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DTO.
 *
 * @param <K> the key type
 */
public abstract class DTO<K extends Serializable> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -862151765440311950L;

	/** The id. */
	protected K id;

	/** The count. */
	private Long count;

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * Instantiates a new dto.
	 */
	public DTO() {
		super();

		this.id = null;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public K getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(K id) {
		this.id = id;
	}

}
