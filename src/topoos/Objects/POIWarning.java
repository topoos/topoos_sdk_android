package topoos.Objects;

import java.util.Date;
/**
 * Class that implements a poi warning
 * @author MAJS
 *
 */
public class POIWarning {

	private Integer id=null;
	private Integer poi_id=null;
	private String type=null;
	private String user_id=null;
	private Date timestamp=null;
	private POIWarningData data=null;
	
	
	/**
	 * @param id
	 * @param poi_id
	 * @param type
	 * @param user_id
	 * @param timestamp
	 * @param data
	 */
	public POIWarning(Integer id, Integer poi_id, String type, String user_id,
			Date timestamp, POIWarningData data) {
		super();
		this.id = id;
		this.poi_id = poi_id;
		this.type = type;
		this.user_id = user_id;
		this.timestamp = timestamp;
		this.data = data;
	}
	/**
	 * get the id of the warning
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
	 * get the id of the poi
	 * @return the poi_id
	 */
	public Integer getPoi_id() {
		return poi_id;
	}
	/**
	 * @param poi_id the poi_id to set
	 */
	public void setPoi_id(Integer poi_id) {
		this.poi_id = poi_id;
	}
	/**
	 * get the type
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
	/**
	 * get the id of the user
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
	 * get the time stamp
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * get the data of the warning
	 * @return the data
	 */
	public POIWarningData getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(POIWarningData data) {
		this.data = data;
	}

	
}
