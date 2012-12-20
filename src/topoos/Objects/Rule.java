package topoos.Objects;

// TODO: Auto-generated Javadoc
/**
 * Class that implements a rule.
 *
 * @author topoos
 */
public class Rule {
	
	/** The id. */
	private Integer id = null;
	
	/** The type. */
	private String type = null;

	/**
	 * Instantiates a new rule.
	 *
	 * @param id the id
	 * @param type the type
	 */
	public Rule(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
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
	 * get the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
