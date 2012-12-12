package topoos.Objects;

import java.util.ArrayList;
/**
 * class that implements the warning data of the pois
 * @author MAJS
 *
 */
public class POIWarningData {

	private Integer id =null;
    private Double latitude =null;
    private Double longitude =null;
    private Double accuracy =null;
    private Double vaccuracy =null;
    private Double elevation =null;
    private String name =null;
    private String address =null;
    private String cross_street =null;
    private String city =null;
    private String country =null;
    private String postal_code =null;
    private String phone =null;
    private String twitter =null;
    private String description =null;
    private ArrayList<POICategory> categories =null;
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param name
	 * @param address
	 * @param cross_street
	 * @param city
	 * @param country
	 * @param postal_code
	 * @param phone
	 * @param twitter
	 * @param description
	 * @param categories
	 */
	public POIWarningData(Integer id, Double latitude, Double longitude,
			Double accuracy, Double vaccuracy, Double elevation, String name,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			String description, ArrayList<POICategory> categories) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.name = name;
		this.address = address;
		this.cross_street = cross_street;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.phone = phone;
		this.twitter = twitter;
		this.description = description;
		this.categories = categories;
	}
	/**
	 * get the id
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
	/**
	 * get the accuracy
	 * @return the accuracy
	 */
	public Double getAccuracy() {
		return accuracy;
	}
	/**
	 * @param accuracy the accuracy to set
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
	 * @param vaccuracy the vaccuracy to set
	 */
	public void setVaccuracy(Double vaccuracy) {
		this.vaccuracy = vaccuracy;
	}
	/**
	 * get the elevation
	 * @return the elevation
	 */
	public Double getElevation() {
		return elevation;
	}
	/**
	 * @param elevation the elevation to set
	 */
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
	/**
	 * get the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get the address
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
	 * get the cross street
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
	 * get the city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * get the country
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
	 * get the postal code
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
	/**
	 * get the phone
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * get the twitter
	 * @return the twitter
	 */
	public String getTwitter() {
		return twitter;
	}
	/**
	 * @param twitter the twitter to set
	 */
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	/**
	 * get the description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * get the categories
	 * @return the categories
	 */
	public ArrayList<POICategory> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(ArrayList<POICategory> categories) {
		this.categories = categories;
	}
	
    
    
}
