package topoos.Objects;

import java.util.Date;

public class Checkin {

	private Integer id=null;
	private Integer device_id=null;
	private Integer poi_id=null;
	private Date register_time=null;
	private Date timestamp=null;
	/**
	 * @param id
	 * @param device_id
	 * @param poi_id
	 * @param register_time
	 * @param timestamp
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
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	/**
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
	 * @return the register_time
	 */
	public Date getRegister_time() {
		return register_time;
	}
	/**
	 * @param register_time the register_time to set
	 */
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	/**
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
	
	
}
