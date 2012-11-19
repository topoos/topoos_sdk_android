package topoos.APIAccess.Results.Objects;


/**
 * 
 * @author MAJS
 *
 */
public class GeocodingData {

    public Address address =null;
    public Location location =null;
    public ViewportType bounds =null;
	/**
	 * @param address
	 * @param location
	 * @param bounds
	 */
	public GeocodingData(Address address, Location location, ViewportType bounds) {
		super();
		this.address = address;
		this.location = location;
		this.bounds = bounds;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * @return the bounds
	 */
	public ViewportType getBounds() {
		return bounds;
	}
	/**
	 * @param bounds the bounds to set
	 */
	public void setBounds(ViewportType bounds) {
		this.bounds = bounds;
	}
	
    
    
}
