package topoos.Objects;
/**
 * Class that implements a resource of the track
 * @author MAJS
 *
 */
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
	 * get the id
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
	 * get the type
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
	 * get the format
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
