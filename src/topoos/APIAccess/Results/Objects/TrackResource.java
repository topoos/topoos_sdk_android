package topoos.APIAccess.Results.Objects;

public class TrackResource {

	private Integer id=null;
	private String Type=null;
	private String Format=null;

	/**
	 * @param id
	 * @param type
	 * @param format
	 */
	public TrackResource(Integer id, String type, String format) {
		super();
		this.id = id;
		Type = type;
		Format = format;
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
		return Type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		Format = format;
	}
	
	
	
}
