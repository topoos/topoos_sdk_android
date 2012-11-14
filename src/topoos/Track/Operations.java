package topoos.Track;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.Track;
import android.content.Context;
/**
 * 
 * @author MAJS
 *
 */
public class Operations {
	/**
	 * 
	 * @param name
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static Track Add(String name,
			AccessTokenOAuth accessTokenPregenerated) {

		return Translator.Add(name, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param trackID
	 * @param numberPositions
	 * @param layers
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static Track Get(Integer trackID, Integer numberPositions,
			String[] layers, AccessTokenOAuth accessTokenPregenerated) {
		return Translator.Get(trackID, numberPositions, layers, accessTokenPregenerated);

	}

	/**
	 * 
	 * @param numberPOIS
	 * @param layers
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static Track GetLast(Integer numberPOIS, String[] layers,
			AccessTokenOAuth accessTokenPregenerated) {
		return Translator.GetLast(numberPOIS, layers, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param name
	 * @return
	 */
	public static Track Add(Context context, String name) {
		return Translator.Add(context, name);
	}
	
	/**
	 * 
	 * @param context
	 * @param trackID
	 * @param numberPositions
	 * @param layers
	 * @return
	 */
	public static Track Get(Context context, Integer trackID, Integer numberPositions,
			String[] layers) {
		return Translator.Get(context, trackID, numberPositions, layers);

	}
	
	/**
	 * 
	 * @param context
	 * @param numberPOIS
	 * @param layers
	 * @return
	 */
	public static Track GetLast(Context context, Integer numberPOIS, String[] layers) {
		return Translator.GetLast(context, numberPOIS, layers);

	}
	
	
}
