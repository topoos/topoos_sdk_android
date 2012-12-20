package topoos.Objects;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a type of position.
 *
 * @author topoos
 */
public class PositionType {
	
	/** The id. */
	String id = null;
	
	/** The description. */
	String description = null;

	/**
	 * Instantiates a new position type.
	 *
	 * @param id the id
	 * @param description the description
	 */
	public PositionType(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	/**
	 * get the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {
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

}