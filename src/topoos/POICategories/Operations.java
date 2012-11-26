package topoos.POICategories;

import java.io.IOException;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Operations.POISWarning;
import topoos.Exception.TopoosException;
import topoos.Objects.POICategory;
import android.content.Context;

/**
 * Operations related to POICategories management
 * 
 * @author MAJS
 * 
 */
public class Operations {

	public static final String TYPE_CLOSED = POISWarning.TYPE_CLOSED;
	public static final String TYPE_DUPLICATED = POISWarning.TYPE_DUPLICATED;
	public static final String TYPE_WRONG_INDICATOR = POISWarning.TYPE_WRONG_INDICATOR;
	public static final String TYPE_WRONG_INFO = POISWarning.TYPE_WRONG_INFO;

	/**
	 * Gets the list of POI categories.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return List<POICategory>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<POICategory> GetAll(
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.GetAll(accessTokenPregenerated);
	}
	
	/**
	 * 
	 * @param name
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static POICategory Add(String name,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.Add(name, accessTokenPregenerated);
	}

	public static Boolean Update(Integer categoryID, String name,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.Update(categoryID, name, accessTokenPregenerated);
	}

	public static Boolean Delete(Integer categoryID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.Delete(categoryID, accessTokenPregenerated);
	}

	public static List<POICategory> GetAll(Context context) throws IOException,
			TopoosException {
		return Translator.GetAll(context);
	}

	public static POICategory Add(Context context, String name)
			throws IOException, TopoosException {
		return Translator.Add(context, name);
	}

	public static Boolean Update(Context context, Integer categoryID,
			String name) throws IOException, TopoosException {
		return Translator.Update(context, categoryID, name);
	}

	public static Boolean Delete(Context context, Integer categoryID)
			throws IOException, TopoosException {
		return Translator.Delete(context, categoryID);
	}

}
