package topoos.Objects;

// TODO: Auto-generated Javadoc
/**
 * Class that implements a object address.
 *
 * @author MAJS
 */
public class Address {
    
    /** The address. */
    public String address =null;
    
    /** The cross_street. */
    public String cross_street =null;
    
    /** The state. */
    public String state =null;
    
    /** The administrative_area. */
    public String administrative_area =null;
    
    /** The country. */
    public String country =null;
    
    /** The postal_code. */
    public String postal_code =null;
	
	/**
	 * Instantiates a new address.
	 *
	 * @param address name of the address
	 * @param cross_street name of the cross street
	 * @param state name of the state
	 * @param administrative_area name of the administrative area
	 * @param country name of the country
	 * @param postal_code postal code
	 */
	public Address(String address, String cross_street, String state,
			String administrative_area, String country, String postal_code) {
		super();
		this.address = address;
		this.cross_street = cross_street;
		this.state = state;
		this.administrative_area = administrative_area;
		this.country = country;
		this.postal_code = postal_code;
	}
	
	/**
	 * get the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * get the cross street.
	 *
	 * @return the cross_street
	 */
	public String getCross_street() {
		return cross_street;
	}
	
	/**
	 * Sets the cross_street.
	 *
	 * @param cross_street the cross_street to set
	 */
	public void setCross_street(String cross_street) {
		this.cross_street = cross_street;
	}
	
	/**
	 * get the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * get the administrative area.
	 *
	 * @return the administrative_area
	 */
	public String getAdministrative_area() {
		return administrative_area;
	}
	
	/**
	 * Sets the administrative_area.
	 *
	 * @param administrative_area the administrative_area to set
	 */
	public void setAdministrative_area(String administrative_area) {
		this.administrative_area = administrative_area;
	}
	
	/**
	 * get the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * get the postal code.
	 *
	 * @return the postal_code
	 */
	public String getPostal_code() {
		return postal_code;
	}
	
	/**
	 * Sets the postal_code.
	 *
	 * @param postal_code the postal_code to set
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
    
    
}
