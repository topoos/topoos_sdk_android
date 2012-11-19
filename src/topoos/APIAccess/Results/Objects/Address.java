package topoos.APIAccess.Results.Objects;

/**
 * 
 * @author MAJS
 *
 */
public class Address {
    public String address =null;
    public String cross_street =null;
    public String state =null;
    public String administrative_area =null;
    public String country =null;
    public String postal_code =null;
	/**
	 * @param address
	 * @param cross_street
	 * @param state
	 * @param administrative_area
	 * @param country
	 * @param postal_code
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the cross_street
	 */
	public String getCross_street() {
		return cross_street;
	}
	/**
	 * @param cross_street the cross_street to set
	 */
	public void setCross_street(String cross_street) {
		this.cross_street = cross_street;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the administrative_area
	 */
	public String getAdministrative_area() {
		return administrative_area;
	}
	/**
	 * @param administrative_area the administrative_area to set
	 */
	public void setAdministrative_area(String administrative_area) {
		this.administrative_area = administrative_area;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the postal_code
	 */
	public String getPostal_code() {
		return postal_code;
	}
	/**
	 * @param postal_code the postal_code to set
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
    
    
}
