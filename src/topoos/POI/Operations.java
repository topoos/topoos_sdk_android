package topoos.POI;

import java.io.IOException;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.POI;
import android.content.Context;

/**
 * 
 * @author MAJS
 * 
 */
public class Operations {

	/**
	 * Add a new point of interest (POI).Fields like address, cross_street,
	 * city, country, and postalCode not specified, it will attempt to
	 * automatically generate
	 * 
	 * @param name
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param desc
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return POI
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Add(AccessTokenOAuth accessTokenPregenerated,
			String name, Double lat, Double lng, Integer[] categories,
			Double accuracy, Double vaccuracy, Double elevation, String desc,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.Add(name, lat, lng, categories, accuracy, vaccuracy,
				elevation, desc, address, cross_street, city, country,
				postal_code, phone, twitter, accessTokenPregenerated);
	}

	/**
	 * Gets information from a point of interest
	 * 
	 * @param POIID
	 *            (required) point of interest identifier
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return POI
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POI Get(Integer POIID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.Get(POIID, accessTokenPregenerated);
	}

	/**
	 * Gets a collection of points of interest near a location
	 * 
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param radius
	 *            (required) search radius in meters
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return List<POI>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POI> GetNear(AccessTokenOAuth accessTokenPregenerated,
			Double lat, Double lng, Integer radius, Integer[] categories)
			throws IOException, TopoosException {
		return Translator.GetNear(lat, lng, radius, categories,
				accessTokenPregenerated);
	}

	/**
	 * Gets a collection of collection of points filtering by various criteria
	 * 
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param POIS
	 *            (optional) list of identifiers of POI you want to retrieve,
	 *            separated by commas
	 * @param city
	 *            (optional) gets the POI in the city specified
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param q
	 *            (optional) gets the POI whose name or description matched the
	 *            pattern
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return List<POI>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POI> GetWhere(AccessTokenOAuth accessTokenPregenerated,
			Integer[] categories, Integer[] POIS, String city, String country,
			String postal_code, String q) throws IOException, TopoosException {
		return Translator.GetWhere(categories, POIS, city, country,
				postal_code, q, accessTokenPregenerated);
	}

	/**
	 * Upgrade the point of interest with the new information provided. If you
	 * want to erase
	 * 
	 * @param POIID
	 * @param name
	 * @param lat
	 * @param lng
	 * @param categories
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param desc
	 * @param address
	 * @param cross_stret
	 * @param city
	 * @param country
	 * @param postal_code
	 * @param phone
	 * @param twitter
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean Update(AccessTokenOAuth accessTokenPregenerated,
			Integer POIID, String name, Double lat, Double lng,
			Integer[] categories, Double accuracy, Double vaccuracy,
			Double elevation, String desc, String address, String cross_stret,
			String city, String country, String postal_code, String phone,
			String twitter) throws IOException, TopoosException {
		return Translator.Update(POIID, name, lat, lng, categories, accuracy,
				vaccuracy, elevation, desc, address, cross_stret, city,
				country, postal_code, phone, twitter, accessTokenPregenerated);
	}

	public static Boolean Delete(Integer POIID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.Delete(POIID, accessTokenPregenerated);
	}

	public static POI Add(Context context, String name, Double lat, Double lng,
			Integer[] categories, Double accuracy, Double vaccuracy,
			Double elevation, String desc, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter) throws IOException, TopoosException {
		return Translator.Add(context, name, lat, lng, categories, accuracy,
				vaccuracy, elevation, desc, address, cross_street, city,
				country, postal_code, phone, twitter);
	}

	public static POI Get(Context context, Integer POIID) throws IOException,
			TopoosException {
		return Translator.Get(context, POIID);
	}

	public static List<POI> GetNear(Context context, Double lat, Double lng,
			Integer radius, Integer[] categories) throws IOException,
			TopoosException {
		return Translator.GetNear(context, lat, lng, radius, categories);

	}

	public static List<POI> GetWhere(Context context, Integer[] categories,
			Integer[] POIS, String city, String country, String postal_code,
			String q) throws IOException, TopoosException {
		return Translator.GetWhere(context, categories, POIS, city, country,
				postal_code, q);
	}

	public static Boolean Update(Context context, Integer POIID, String name,
			Double lat, Double lng, Integer[] categories, Double accuracy,
			Double vaccuracy, Double elevation, String desc, String address,
			String cross_stret, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.Update(context, POIID, name, lat, lng, categories,
				accuracy, vaccuracy, elevation, desc, address, cross_stret,
				city, country, postal_code, phone, twitter);
	}

	public static Boolean Delete(Context context, Integer POIID)
			throws IOException, TopoosException {
		return Translator.Delete(context, POIID);
	}

}
