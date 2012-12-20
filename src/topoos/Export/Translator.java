package topoos.Export;
import java.io.IOException;
import java.util.Date;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Translator.
 */
class Translator {
	
	/** The method. */
	private static String method = "GET";
	
	/** The format. */
	private static String format = "json";
	
	/** The version. */
	private static Integer version = topoos.Constants.APIVERSION;
	
	/**
	 * Export track.
	 *
	 * @param trackID the track id
	 * @param export_format the export_format
	 * @param total the total
	 * @param initDate the init date
	 * @param endDate the end date
	 * @param accessTokenPregenerated the access token pregenerated
	 * @return the track resource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (Integer trackID, String export_format, Integer total,Date initDate,Date endDate,  AccessTokenOAuth  accessTokenPregenerated) throws IOException, TopoosException{
		TrackResource trackResource = null;
		if (accessTokenPregenerated.isValid()) {
			ExportLayerTrack exportLayerTrack = new ExportLayerTrack("ExportTrack", method, format,
					version, accessTokenPregenerated.getAccessToken(),
					ExportLayerTrack.TYPE_LAYER, 
					ExportLayerTrack.DATA_TRACK,
					export_format, 
					trackID,
					total, 
					initDate, 
					endDate );
			TrackResourceResult trackResourceResult = new TrackResourceResult();
			APICaller.ExecuteOperation(exportLayerTrack, trackResourceResult);
			trackResource = trackResourceResult.getTrackResource();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return trackResource;
	}
	
	/**
	 * Export track.
	 *
	 * @param context the context
	 * @param trackID the track id
	 * @param export_format the export_format
	 * @param total the total
	 * @param initDate the init date
	 * @param endDate the end date
	 * @return the track resource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (Context context,Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		return ExportTrack(trackID, export_format, total, initDate, endDate, AccessTokenOAuth.GetAccessToken(context));
				}

	
}
