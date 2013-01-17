package topoos.Webmap;

import java.io.IOException;

import topoos.APIAccess.Operations.Webmap;
import topoos.Exception.TopoosException;

/**
 * 
 * @author topoos
 *
 */
class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;
	
	
	public static String GetTrackExportedWebMapURI (String resourceID,String type,String apiKey) throws IOException, TopoosException{
		String getTrackExportedWebMapURI = null;
		if (apiKey!=null) {
			Webmap resourceWebmap = new Webmap("GetTrackExportedWebMapURI", method, format,
					version, apiKey, type,
					resourceID);
			getTrackExportedWebMapURI=resourceWebmap.ConcatParams();
		}
		return getTrackExportedWebMapURI;
	}
	
	
}
