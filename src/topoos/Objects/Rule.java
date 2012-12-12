package topoos.Objects;

/**
 * Class that implements a rule
 * 
 * @author MAJS
 * 
 */
public class Rule {
	private Integer id = null;
	private String type = null;

	/**
	 * @param id
	 * @param type
	 */
	public Rule(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
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
	 * get the type
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
