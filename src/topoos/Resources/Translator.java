package topoos.Resources;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.APIAccess.Results.Objects.*;
import topoos.Exception.TopoosException;

/**
 * 
 * @author MAJS
 *
 */
class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	public static	List<Location> GetCircle (Integer resolution,Double latCenter,Double lngCenter,Double radius, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		List<Location> list = null;
		if (accessTokenPregenerated.isValid()) {
			ResourcesGet_polygon Get_polygon = new ResourcesGet_polygon("GetCircle", method, format,
					version, accessTokenPregenerated.getAccessToken(), ResourcesGet_polygon.SHAPE_CIRCLE,resolution,
					latCenter, lngCenter, radius);		
			
			PolygonResult polygonResult = new PolygonResult();
			APICaller.ExecuteOperation(Get_polygon, polygonResult);
			list = polygonResult.getPolygon();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return list;
	}

	public static	List<GeocodingData> GetGeocode (Double lat, Double lng, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		List<GeocodingData> Geocoding = null;
		if (accessTokenPregenerated.isValid()) {
			ResourcesGeocode resourcesGeocode = new ResourcesGeocode("GetGeocode", method, format,
					version, accessTokenPregenerated.getAccessToken(), lat,
					lng);
			GeocodingResult geocodingResult = new GeocodingResult();
			APICaller.ExecuteOperation(resourcesGeocode, geocodingResult);
			Geocoding = geocodingResult.getGeocoding();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return Geocoding;
	}
	
	public static Track GetTrackExported (Integer resourceID,String type, String format,String apiKey){
		Track track=null;
		return track;
	}
	
	
	public static String GetTrackExportedWebMapURI (String resourceID,String type,String apiKey) throws IOException, TopoosException{
		String GetTrackExportedWebMapURI = null;
		if (apiKey!=null) {
			ResourceWebmap resourceWebmap = new ResourceWebmap("GetTrackExportedWebMapURI", method, format,
					version, apiKey, type,
					resourceID);
			APICallResult aPICallResult = new APICallResult();
			APICaller.ExecuteOperation(resourceWebmap, aPICallResult);
			GetTrackExportedWebMapURI = aPICallResult.getResult();
		}
		return GetTrackExportedWebMapURI;
	}
	
	
	public static	List<Location> GetCircle (Context context, Integer resolution,Double latCenter,Double lngCenter,Double radius) throws IOException, TopoosException{
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetCircle(resolution, latCenter, lngCenter, radius, accessTokenPregenerated);
	
	}

	public static	List<GeocodingData> GetGeocode (Context context, Double lat, Double lng) throws IOException, TopoosException{
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetGeocode(lat, lng, accessTokenPregenerated);
	}
	
	
	
}
