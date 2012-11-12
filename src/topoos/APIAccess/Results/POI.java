package topoos.APIAccess.Results;

import java.util.ArrayList;

public class POI extends APICallResult{
	
	private String  Id=null;
	private String  Name=null;
	private String 	Description=null;
	private String 	Latitude=null;
	private String 	Longitude=null;
	private String 	Elevation=null;
	private String 	Accuracy=null;
	private String 	Vaccuracy=null;
	private String 	Registertime=null;
	private ArrayList<POICategory> Categories=null;
	private String 	Address=null;
	private String 	CrossStreet=null;
	private String 	City=null;
	private String 	Country=null;
	private String 	PostalCode=null;
	private String 	Phone=null;
	private String 	Twitter=null;
	private String 	LastUpdate=null;

	/**
	 * @param error
	 * @param result
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
	 */
	public POI(String error, String result, String id, String name,
			String description, String latitude, String longitude,
			String elevation, String accuracy, String vaccuracy,
			String registertime, ArrayList<POICategory> categories,
			String address, String crossStreet, String city, String country,
			String postalCode, String phone, String twitter, String lastUpdate) {
		super(error, result);
		Id = id;
		Name = name;
		Description = description;
		Latitude = latitude;
		Longitude = longitude;
		Elevation = elevation;
		Accuracy = accuracy;
		Vaccuracy = vaccuracy;
		Registertime = registertime;
		Categories = categories;
		Address = address;
		CrossStreet = crossStreet;
		City = city;
		Country = country;
		PostalCode = postalCode;
		Phone = phone;
		Twitter = twitter;
		LastUpdate = lastUpdate;
	}

	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		
	}
	
	public class POICategory{
		
	}
}