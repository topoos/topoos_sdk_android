package topoos.Objects;
/**
 * Class that implements a type of position
 * @author MAJS
 *
 */
public class PositionType {
	String id = null;
	String description = null;

	/**
	 * @param id
	 * @param description
	 */
	public PositionType(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	/**
	 * get the id
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * get the description
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

}