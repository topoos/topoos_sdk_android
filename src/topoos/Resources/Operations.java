package topoos.Resources;

import java.util.List;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.GeocodingData;
import topoos.APIAccess.Results.Objects.Location;
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
	 * @param resolution
	 * @param latCenter
	 * @param lngCenter
	 * @param radius
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static List<Location> GetCircle(Integer resolution,
			Double latCenter, Double lngCenter, Double radius,
			AccessTokenOAuth accessTokenPregenerated) {
		return Translator.GetCircle(resolution, latCenter, lngCenter, radius,
				accessTokenPregenerated);
	}

	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static List<GeocodingData> GetGeocode(Double lat, Double lng,
			AccessTokenOAuth accessTokenPregenerated) {
		return Translator.GetGeocode(lat, lng, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param resourceID
	 * @param type
	 * @param format
	 * @param apiKey
	 * @return
	 */
	public static Track GetTrackExported(Integer resourceID, String type,
			String format, String apiKey) {
		return Translator.GetTrackExported(resourceID, type, format, apiKey);
	}

	/**
	 * 
	 * @param resourceID
	 * @param type
	 * @param apiKey
	 * @return
	 */
	public static String GetTrackExportedWebMapURI(String resourceID,
			String type, String apiKey) {
		return Translator.GetTrackExportedWebMapURI(resourceID, type, apiKey);
	}

	/**
	 * 
	 * @param context
	 * @param resolution
	 * @param latCenter
	 * @param lngCenter
	 * @param radius
	 * @return
	 */
	public static List<Location> GetCircle(Context context, Integer resolution,
			Double latCenter, Double lngCenter, Double radius) {
		return Translator.GetCircle(context, resolution, latCenter, lngCenter,
				radius);

	}

	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @return
	 */
	public static List<GeocodingData> GetGeocode(Context context, Double lat,
			Double lng) {
		return Translator.GetGeocode(context, lat, lng);
	}
}
