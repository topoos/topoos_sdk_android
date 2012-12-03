package topoos.Objects;

import java.util.Date;
/**
 * Class that implements a position
 * @author FBP
 *
 */
public class Position {

	Integer id = null;
	String device = null;
	Date timestamp = null;
	Date registerTime = null;
	Double latitude = null;
	Double longitude = null;
	Double elevation = null;
	PositionType positionType = null;
	Double accuracy = null;
	Double vaccuracy = null;
	Double bearing = null;
	Double velocity = null;
	String track_id = null;

	/**
	 * @param id
	 * @param device
	 * @param timestamp
	 * @param registerTime
	 * @param latitude
	 * @param longitude
	 * @param elevation
	 * @param positionType
	 * @param accuracy
	 * @param vaccuracy
	 * @param bearing
	 * @param velocity
	 * @param track_id
	 */
	public Position(Integer id, String device,
			Date timestamp, Date registerTime, Double latitude,
			Double longitude, Double elevation, PositionType positionType,
			Double accuracy, Double vaccuracy, Double bearing, Double velocity,
			String track_id) {
		this.id = id;
		this.device = device;
		this.timestamp = timestamp;
		this.registerTime = registerTime;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.positionType = positionType;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.bearing = bearing;
		this.velocity = velocity;
		this.track_id = track_id;
	}


	/**
	 * get the id
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
	 * get the device
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device
	 *            the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * get the time stamp
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * get the register time
	 * @return the registerTime
	 */
	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * @param registerTime
	 *            the registerTime to set
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * get the latitude
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * get the longitude
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * get the elevation
	 * @return the elevation
	 */
	public Double getElevation() {
		return elevation;
	}

	/**
	 * @param elevation
	 *            the elevation to set
	 */
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	/**
	 * get the position type
	 * @return the positionType
	 */
	public PositionType getPositionType() {
		return positionType;
	}

	/**
	 * @param positionType
	 *            the positionType to set
	 */
	public void setPositionType(PositionType positionType) {
		this.positionType = positionType;
	}

	/**
	 * get the accuracy
	 * @return the accuracy
	 */
	public Double getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy
	 *            the accuracy to set
	 */
	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * get the vaccuracy
	 * @return the vaccuracy
	 */
	public Double getVaccuracy() {
		return vaccuracy;
	}

	/**
	 * @param vaccuracy
	 *            the vaccuracy to set
	 */
	public void setVaccuracy(Double vaccuracy) {
		this.vaccuracy = vaccuracy;
	}

	/**
	 * get the bearing 
	 * @return the bearing
	 */
	public Double getBearing() {
		return bearing;
	}

	/**
	 * @param bearing
	 *            the bearing to set
	 */
	public void setBearing(Double bearing) {
		this.bearing = bearing;
	}

	/**
	 * get the velocity
	 * @return the velocity
	 */
	public Double getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity
	 *            the velocity to set
	 */
	public void setVelocity(Double velocity) {
		this.velocity = velocity;
	}

	/**
	 * get the track id
	 * @return the track_id
	 */
	public String getTrack_id() {
		return track_id;
	}

	/**
	 * @param track_id
	 *            the track_id to set
	 */
	public void setTrack_id(String track_id) {
		this.track_id = track_id;
	}

	
}