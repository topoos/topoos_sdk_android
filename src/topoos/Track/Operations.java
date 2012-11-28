package topoos.Track;

import java.io.IOException;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Track;
import android.content.Context;

/**
 * Operations related to position management
 * 
 * @author MAJS
 * 
 */
public class Operations {

	public static final String LAYER_DEFAULT = topoos.APIAccess.Operations.TracksGet.LAYER_DEFAULT;
	public static final String LAYER_BEARING = topoos.APIAccess.Operations.TracksGet.LAYER_BEARING;
	public static final String LAYER_TRACKLINE = topoos.APIAccess.Operations.TracksGet.LAYER_TRACKLINE;

	/**
	 * Create a new Track. A Track is a sequence of positions recorded during a
	 * session
	 * 
	 * @param name
	 *            (optional) description of the Track
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Track
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Track Add(AccessTokenOAuth accessTokenPregenerated,
			String name) throws IOException, TopoosException {

		return Translator.Add(name, accessTokenPregenerated);
	}

	/**
	 * Obtain information from a Track
	 * 
	 * @param trackID
	 *            (required) requested identifier Track
	 * @param numberPositions
	 *            (optional) if you specify a value N, N shows the latest
	 *            positions
	 * @param layers
	 *            (optional) requested KML layers, separated by commas
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Track
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Track Get(AccessTokenOAuth accessTokenPregenerated,
			Integer trackID, Integer numberPositions, String[] layers)
			throws IOException, TopoosException {
		return Translator.Get(trackID, numberPositions, layers,
				accessTokenPregenerated);

	}

	/**
	 * Gets a document that represents the last track recorded by a device
	 * 
	 * @param numberPOIS
	 *            (optional) if you specify a value N, N positions get the
	 *            latest Track
	 * @param layers
	 *            (Optional) requested KML layers, separated by commas
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Track GetLast(AccessTokenOAuth accessTokenPregenerated,
			Integer numberPOIS, String[] layers) throws IOException,
			TopoosException {
		return Translator.GetLast(numberPOIS, layers, accessTokenPregenerated);
	}

	/**
	 * Create a new Track. A Track is a sequence of positions recorded during a
	 * session
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param name
	 *            (optional) description of the Track
	 * @return Track
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Track Add(Context context, String name) throws IOException,
			TopoosException {
		return Translator.Add(context, name);
	}

	/**
	 * Obtain information from a Track
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param trackID
	 * @param numberPositions
	 * @param layers
	 * @return Track
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Track Get(Context context, Integer trackID,
			Integer numberPositions, String[] layers) throws IOException,
			TopoosException {
		return Translator.Get(context, trackID, numberPositions, layers);

	}

	/**
	 * Gets a document that represents the last track recorded by a device
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param numberPOIS
	 *            (optional) if you specify a value N, N positions get the
	 *            latest Track
	 * @param layers
	 *            (Optional) requested KML layers, separated by commas
	 * @return Track
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Track GetLast(Context context, Integer numberPOIS,
			String[] layers) throws IOException, TopoosException {
		return Translator.GetLast(context, numberPOIS, layers);

	}

}
