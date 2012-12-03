package topoos.Objects;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class that implements a point of interest
 * 
 * @author MAJS
 * 
 */
public class POI {

	private Integer id = null;
	private String name = null;
	private String description = null;
	private Double latitude = null;
	private Double longitude = null;
	private Double elevation = null;
	private Double accuracy = null;
	private Double vaccuracy = null;
	private Date registertime = null;
	private ArrayList<POICategory> categories = null;
	private String address = null;
	private String crossStreet = null;
	private String city = null;
	private String country = null;
	private String postalCode = null;
	private String phone = null;
	private String twitter = null;
	private Date lastUpdate = null;
	private POIWarningCount warningcount = null;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param latitude
	 * @param longitude
	 * @param elevation
	 * @param accuracy
	 * @param vaccuracy
	 * @param registertime
	 * @param categories
	 * @param address
	 * @param crossStreet
	 * @param city
	 * @param country
	 * @param postalCode
	 * @param phone
	 * @param twitter
	 * @param lastUpdate
	 * @param warningcount
	 */
	public POI(Integer id, String name, String description, Double latitude,
			Double longitude, Double elevation, Double accuracy,
			Double vaccuracy, Date registertime,
			ArrayList<POICategory> categories, String address,
			String crossStreet, String city, String country, String postalCode,
			String phone, String twitter, Date lastUpdate,
			POIWarningCount warningcount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.registertime = registertime;
		this.categories = categories;
		this.address = address;
		this.crossStreet = crossStreet;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.phone = phone;
		this.twitter = twitter;
		this.lastUpdate = lastUpdate;
		this.warningcount = warningcount;
	}

	/**
	 * Get the id of the poi
	 * 
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
	 * get the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the description
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get the latitude
	 * 
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
	 * 
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
	 * 
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
	 * get the accuracy
	 * 
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
	 * 
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
	 * get the register time
	 * 
	 * @return the registertime
	 */
	public Date getRegistertime() {
		return registertime;
	}

	/**
	 * @param registertime
	 *            the registertime to set
	 */
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	/**
	 * get a list of the categories
	 * 
	 * @return the categories
	 */
	public ArrayList<POICategory> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(ArrayList<POICategory> categories) {
		this.categories = categories;
	}

	/**
	 * get the address
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * get the cross street
	 * 
	 * @return the crossStreet
	 */
	public String getCrossStreet() {
		return crossStreet;
	}

	/**
	 * @param crossStreet
	 *            the crossStreet to set
	 */
	public void setCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
	}

	/**
	 * get the city
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * get the country
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * get the postal code
	 * 
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * get the phone
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * get the twitter id
	 * 
	 * @return the twitter
	 */
	public String getTwitter() {
		return twitter;
	}

	/**
	 * @param twitter
	 *            the twitter to set
	 */
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	/**
	 * get the last update
	 * 
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate
	 *            the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * get the warning count
	 * 
	 * @return the warningcount
	 */
	public POIWarningCount getWarningcount() {
		return warningcount;
	}

	/**
	 * @param warningcount
	 *            the warningcount to set
	 */
	public void setWarningcount(POIWarningCount warningcount) {
		this.warningcount = warningcount;
	}

}