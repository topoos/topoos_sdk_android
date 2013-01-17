package topoos.Webmap;

import java.io.IOException;

import topoos.Exception.TopoosException;

/**
 * 
 * @author topoos
 * 
 */
public class Operations {
	
	public static final String TYPE_LAYER= topoos.APIAccess.Operations.ExportLayerTrack.TYPE_LAYER;

	
	/**
	 * 
	 * @param resourceID
	 * @param type
	 * @param apiKey
	 * @return String
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static String GetTrackExportedWebMapURI(String resourceID,
			String type, String apiKey) throws IOException, TopoosException {
		return Translator.GetTrackExportedWebMapURI(resourceID, type, apiKey);
	}

}
