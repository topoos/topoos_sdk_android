package topoos.Rules;

import java.io.IOException;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Rule;
import android.content.Context;

/**
 * Operations related to rules management
 * 
 * @author MAJS
 * 
 */
public class Operations {
	/**
	 * Create a new rule of one of the following types:TRACK_OUT_OF_BOUNDS.
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param Track
	 *            (required) Track ID that associate the rule
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position
	 * @param radius
	 *            (required) search radius in meters
	 * @return Rule
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Rule AddTrackOutOfBounds(
			AccessTokenOAuth accessTokenPregenerated, Integer track,
			Double lat, Double lng, Integer radius) throws IOException,
			TopoosException {
		return Translator.AddTrackOutOfBounds(track, lat, lng, radius,
				accessTokenPregenerated);
	}

	/**
	 * Create a new rule of one of the following types:TRACK_OUT_OF_BOUNDS.
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param track
	 *            (required) Track ID that associate the rule
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position
	 * @param radius
	 *            (required) search radius in meters
	 * @return Rule
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Rule AddTrackOutOfBounds(Context context, Integer track,
			Double lat, Double lng, Integer radius) throws IOException,
			TopoosException {
		return Translator.AddTrackOutOfBounds(context, track, lat, lng, radius);
	}
}
