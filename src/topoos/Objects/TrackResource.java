package topoos.Objects;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a resource of the track.
 *
 * @author MAJS
 */
public class TrackResource {

	/** The id. */
	private Integer id=null;
	
	/** The Type. */
	private String Type=null;
	
	/** The Format. */
	private String Format=null;

	/**
	 * Instantiates a new track resource.
	 *
	 * @param id the id
	 * @param type the type
	 * @param format the format
	 */
	public TrackResource(Integer id, String type, String format) {
		super();
		this.id = id;
		Type = type;
		Format = format;
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
		return Type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * get the format.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * Sets the format.
	 *
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		Format = format;
	}
	
	
	
}
