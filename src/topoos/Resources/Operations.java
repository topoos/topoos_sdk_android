package topoos.Resources;

import java.io.IOException;
import java.util.List;
import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.GeocodingData;
import topoos.Objects.Location;
import topoos.Objects.Track;
import android.content.Context;

/**
 * 
 * @author MAJS
 * 
 */
public class Operations {
	
	public static final String DATA_TRACK= topoos.APIAccess.Operations.ExportLayerTrack.DATA_TRACK;
	public static final String TYPE_LAYER= topoos.APIAccess.Operations.ExportLayerTrack.TYPE_LAYER;
	public static final String EXPORT_FORMAT=topoos.APIAccess.Operations.ExportLayerTrack.EXPORT_FORMAT;
	
	
	/**
	 * 
	 * @param resolution
	 * @param latCenter
	 * @param lngCenter
	 * @param radius
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<Location> GetCircle(AccessTokenOAuth accessTokenPregenerated, Integer resolution,
			Double latCenter, Double lngCenter, Double radius
			) throws IOException, TopoosException {
		return Translator.GetCircle(resolution, latCenter, lngCenter, radius,
				accessTokenPregenerated);
	}

	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<GeocodingData> GetGeocode(AccessTokenOAuth accessTokenPregenerated, Double lat, Double lng) throws IOException, TopoosException {
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
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static String GetTrackExportedWebMapURI(String resourceID,
			String type, String apiKey) throws IOException, TopoosException {
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
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<Location> GetCircle(Context context, Integer resolution,
			Double latCenter, Double lngCenter, Double radius) throws IOException, TopoosException {
		return Translator.GetCircle(context, resolution, latCenter, lngCenter,
				radius);

	}

	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<GeocodingData> GetGeocode(Context context, Double lat,
			Double lng) throws IOException, TopoosException {
		return Translator.GetGeocode(context, lat, lng);
	}
}
