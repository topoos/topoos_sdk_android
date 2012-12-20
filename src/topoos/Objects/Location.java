package topoos.Objects;
// TODO: Auto-generated Javadoc

/**
 * Class that represents a location with a latitude and a longitude.
 *
 * @author MAJS
 */
public class Location {

	/** The latitude. */
	Double latitude=null;
	
	/** The longitude. */
	Double longitude=null;
	
	/**
	 * Instantiates a new location.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public Location(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * get the latitude.
	 *
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude.
	 *
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * get the longitude.
	 *
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude.
	 *
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
