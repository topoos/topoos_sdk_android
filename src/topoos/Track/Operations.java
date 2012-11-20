package topoos.Track;

import java.io.IOException;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.Track;
import topoos.Exception.TopoosException;
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
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Track Add(String name,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {

		return Translator.Add(name, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param trackID
	 * @param numberPositions
	 * @param layers
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Track Get(Integer trackID, Integer numberPositions,
			String[] layers, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.Get(trackID, numberPositions, layers, accessTokenPregenerated);

	}

	/**
	 * 
	 * @param numberPOIS
	 * @param layers
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Track GetLast(Integer numberPOIS, String[] layers,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.GetLast(numberPOIS, layers, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param name
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Track Add(Context context, String name) throws IOException, TopoosException {
		return Translator.Add(context, name);
	}
	
	/**
	 * 
	 * @param context
	 * @param trackID
	 * @param numberPositions
	 * @param layers
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Track Get(Context context, Integer trackID, Integer numberPositions,
			String[] layers) throws IOException, TopoosException {
		return Translator.Get(context, trackID, numberPositions, layers);

	}
	
	/**
	 * 
	 * @param context
	 * @param numberPOIS
	 * @param layers
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Track GetLast(Context context, Integer numberPOIS, String[] layers) throws IOException, TopoosException {
		return Translator.GetLast(context, numberPOIS, layers);

	}
	
	
}
