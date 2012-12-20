package topoos.Objects;

// TODO: Auto-generated Javadoc
/**
 * Class that implements a category of a POI.
 *
 * @author topoos
 */
public class POICategory {
	
	/** The id. */
	private Integer id = null;
	
	/** The description. */
	private String description = null;
	
	/** The is system. */
	private Boolean isSystem = null;

	/**
	 * Instantiates a new pOI category.
	 *
	 * @param id the id
	 * @param description the description
	 * @param isSystem the is system
	 */
	public POICategory(Integer id, String description, Boolean isSystem) {
		super();
		this.id = id;
		this.description = description;
		this.isSystem = isSystem;
	}

	/**
	 * get the id.
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
	 * get the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get the is system status.
	 *
	 * @return the isSystem
	 */
	public Boolean getIsSystem() {
		return isSystem;
	}

	/**
	 * Sets the checks if is system.
	 *
	 * @param isSystem the isSystem to set
	 */
	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}

}