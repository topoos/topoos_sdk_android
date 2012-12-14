package topoos.Objects;

import java.util.Date;
/**
 * 
 * @author MAJS
 *
 */
public class Image {

	private String id = null;
	private String client_id = null;
	private String user_id = null;
	private String filename = null;
	private String filename_unique = null;
	private String file_ext = null;
	private String uri = null;
	private Date register_date = null;
	private GeoData geo_data = null;
	
	/**
	 * @param id
	 * @param client_id
	 * @param user_id
	 * @param filename
	 * @param filename_unique
	 * @param file_ext
	 * @param uri
	 * @param register_date
	 * @param geo_data
	 */
	public Image(String id, String client_id, String user_id, String filename,
			String filename_unique, String file_ext, String uri,
			Date register_date, GeoData geo_data) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.user_id = user_id;
		this.filename = filename;
		this.filename_unique = filename_unique;
		this.file_ext = file_ext;
		this.uri = uri;
		this.register_date = register_date;
		this.geo_data = geo_data;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the client_id
	 */
	public String getClient_id() {
		return client_id;
	}

	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the filename_unique
	 */
	public String getFilename_unique() {
		return filename_unique;
	}

	/**
	 * @param filename_unique the filename_unique to set
	 */
	public void setFilename_unique(String filename_unique) {
		this.filename_unique = filename_unique;
	}

	/**
	 * @return the file_ext
	 */
	public String getFile_ext() {
		return file_ext;
	}

	/**
	 * @param file_ext the file_ext to set
	 */
	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the register_date
	 */
	public Date getRegister_date() {
		return register_date;
	}

	/**
	 * @param register_date the register_date to set
	 */
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	/**
	 * @return the geo_data
	 */
	public GeoData getGeo_data() {
		return geo_data;
	}

	/**
	 * @param geo_data the geo_data to set
	 */
	public void setGeo_data(GeoData geo_data) {
		this.geo_data = geo_data;
	}

	
	
}
