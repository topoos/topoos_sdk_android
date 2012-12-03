package topoos.Objects;
/**
 * Class that represents a location with a latitude and a longitude
 * @author MAJS
 *
 */
public class Location {

	Double latitude=null;
	Double longitude=null;
	/**
	 * @param latitude
	 * @param longitude
	 */
	public Location(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * get the latitude
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
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
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
