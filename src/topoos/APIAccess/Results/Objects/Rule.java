package topoos.APIAccess.Results.Objects;

public class Rule {
	private Integer id=null;
	private String type=null;
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
