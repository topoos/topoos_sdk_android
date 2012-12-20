package topoos.Objects;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a object Checkin.
 *
 * @author MAJS
 */
public class Checkin {

	/** The id. */
	private Integer id=null;
	
	/** The device_id. */
	private Integer device_id=null;
	
	/** The poi_id. */
	private Integer poi_id=null;
	
	/** The register_time. */
	private Date register_time=null;
	
	/** The timestamp. */
	private Date timestamp=null;
	
	/**
	 * Instantiates a new checkin.
	 *
	 * @param id the id
	 * @param device_id the device_id
	 * @param poi_id the poi_id
	 * @param register_time the register_time
	 * @param timestamp the timestamp
	 */
	public Checkin(Integer id, Integer device_id, Integer poi_id,
			Date register_time, Date timestamp) {
		super();
		this.id = id;
		this.device_id = device_id;
		this.poi_id = poi_id;
		this.register_time = register_time;
		this.timestamp = timestamp;
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
	 * get the device id.
	 *
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	
	/**
	 * Sets the device_id.
	 *
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	
	/**
	 * get the id of the poi.
	 *
	 * @return the poi_id
	 */
	public Integer getPoi_id() {
		return poi_id;
	}
	
	/**
	 * Sets the poi_id.
	 *
	 * @param poi_id the poi_id to set
	 */
	public void setPoi_id(Integer poi_id) {
		this.poi_id = poi_id;
	}
	
	/**
	 * get the register time.
	 *
	 * @return the register_time
	 */
	public Date getRegister_time() {
		return register_time;
	}
	
	/**
	 * Sets the register_time.
	 *
	 * @param register_time the register_time to set
	 */
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	
	/**
	 * get the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
