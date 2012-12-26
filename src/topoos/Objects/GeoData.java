package topoos.Objects;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class GeoData.
 */
public class GeoData implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id = null;
	
	/** The position_id. */
	private Integer position_id = null;
	
	/** The poi_id. */
	private Integer poi_id = null;
	
	/**
	 * Instantiates a new geo data.
	 *
	 * @param id the id
	 * @param position_id the position_id
	 * @param poi_id the poi_id
	 */
	public GeoData(Integer id, Integer position_id, Integer poi_id) {
		super();
		this.id = id;
		this.position_id = position_id;
		this.poi_id = poi_id;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the position_id.
	 *
	 * @return the position_id
	 */
	public Integer getPosition_id() {
		return position_id;
	}
	
	/**
	 * Sets the position_id.
	 *
	 * @param position_id the position_id to set
	 */
	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}
	
	/**
	 * Gets the poi_id.
	 *
	 * @return the poi_id
	 */
	public Integer getPoi_id() {
		return poi_id;
	}
	
	/**
	 * Sets the poi_id.
	 *
	 * @param poi_id the poi_id to set
	 */
	public void setPoi_id(Integer poi_id) {
		this.poi_id = poi_id;
	}

	
	
}
