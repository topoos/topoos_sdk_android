package topoos.POIWarning;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.Operations.POISWarningAdd;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * Operations related to POI Warnings management.
 * 
 * @author MAJS
 * 
 */
public class Operations {

	public static final String TYPE_CLOSED = POISWarningAdd.TYPE_CLOSED;
	public static final String TYPE_DUPLICATED = POISWarningAdd.TYPE_DUPLICATED;
	public static final String TYPE_WRONG_INDICATOR = POISWarningAdd.TYPE_WRONG_INDICATOR;
	public static final String TYPE_WRONG_INFO = POISWarningAdd.TYPE_WRONG_INFO;

	/**
	 * Gets the list of error messages related to a point of interest.
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param POISID
	 *            (optional) List of identifier whose warnings POI want to
	 *            retrieve.
	 * @param type
	 *            (optional) List of type whose warnings POI want to retrieve.
	 * @return List<POIDataWarning>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POIDataWarning> Get(
			AccessTokenOAuth accessTokenPregenerated, Integer[] POISID,
			String type) throws IOException, TopoosException {
		return Translator.Get(POISID, type, accessTokenPregenerated);
	}

	/**
	 * Gets the list of all error messages related to a type.
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param type (required) Type of warning (TYPE_CLOSED, TYPE_DUPLICATED,
	 *         TYPE_WRONG_INDICATOR, TYPE_WRONG_INFO)
	 * @return List<POIDataWarning>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POIDataWarning> GetAll(
			AccessTokenOAuth accessTokenPregenerated, String type)
			throws IOException, TopoosException {
		return Translator.GetAll(type, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddClosed(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddClosed(POI_ID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddDuplicated(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddDuplicated(POI_ID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @param lat
	 * @param lng
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddWrongIndicator(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) throws IOException, TopoosException {
		return Translator.AddWrongIndicator(POI_ID, lat, lng, accuracy,
				vaccuracy, elevation, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @param name
	 * @param categories
	 * @param desc
	 * @param address
	 * @param cross_street
	 * @param city
	 * @param country
	 * @param postal_code
	 * @param phone
	 * @param twitter
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddWrongInfo(
			AccessTokenOAuth accessTokenPregenerated, Integer POI_ID,
			String name, Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.AddWrongInfo(POI_ID, name, categories, desc, address,
				cross_street, city, country, postal_code, phone, twitter,
				accessTokenPregenerated);
	}

	/**
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param POISID
	 * @param type
	 * @return Boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean Delete(AccessTokenOAuth accessTokenPregenerated,
			Integer[] POISID, String type) throws IOException, TopoosException {
		return Translator.Delete(POISID, type, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param type
	 * @return Boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean DeleteAll(AccessTokenOAuth accessTokenPregenerated,
			String type) throws IOException, TopoosException {
		return Translator.DeleteAll(type, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POIID
	 *            (optional) List of identifier whose warnings POI want to
	 *            retrieve.
	 * @param type
	 *            (optional) List of type whose warnings POI want to retrieve.
	 * @return List<POIDataWarning>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POIDataWarning> Get(Context context, Integer[] POIID,
			String type) throws IOException, TopoosException {
		return Translator.Get(context, POIID, type);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param type (required) Type of warning (TYPE_CLOSED, TYPE_DUPLICATED,
	 *         TYPE_WRONG_INDICATOR, TYPE_WRONG_INFO)
	 * @return List<POIDataWarning>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POIDataWarning> GetAll(Context context, String type)
			throws IOException, TopoosException {
		return Translator.GetAll(context, type);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddClosed(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddClosed(context, POI_ID);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddDuplicated(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		return Translator.AddDuplicated(context, POI_ID);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @param lat
	 * @param lng
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddWrongIndicator(Context context, Integer POI_ID,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) throws IOException, TopoosException {
		return Translator.AddWrongIndicator(context, POI_ID, lat, lng,
				accuracy, vaccuracy, elevation);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POI_ID
	 *            (required) POI ID that we assign this warning.
	 * @param name
	 * @param categories
	 * @param desc
	 * @param address
	 * @param cross_street
	 * @param city
	 * @param country
	 * @param postal_code
	 * @param phone
	 * @param twitter
	 * @return POIWarning
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POIWarning AddWrongInfo(Context context, Integer POI_ID,
			String name, Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		return Translator.AddWrongInfo(context, POI_ID, name, categories, desc,
				address, cross_street, city, country, postal_code, phone,
				twitter);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param POIID
	 * @param type
	 * @return Boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean Delete(Context context, Integer[] POIID, String type)
			throws IOException, TopoosException {
		return Translator.Delete(context, POIID, type);
	}

	/**
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param type
	 * @return Boolean
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean DeleteAll(Context context, String type)
			throws IOException, TopoosException {
		return Translator.DeleteAll(context, type);
	}

}
