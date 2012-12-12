package topoos.Objects;

/**
 * Class that implements a category of a POI
 * 
 * @author MAJS
 * 
 */
public class POICategory {
	private Integer id = null;
	private String description = null;
	private Boolean isSystem = null;

	/**
	 * @param id
	 * @param description
	 * @param isSystem
	 */
	public POICategory(Integer id, String description, Boolean isSystem) {
		super();
		this.id = id;
		this.description = description;
		this.isSystem = isSystem;
	}

	/**
	 * get the id
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * get the description
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get the is system status
	 * 
	 * @return the isSystem
	 */
	public Boolean getIsSystem() {
		return isSystem;
	}

	/**
	 * @param isSystem
	 *            the isSystem to set
	 */
	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}

}