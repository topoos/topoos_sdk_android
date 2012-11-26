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

class Translator {
	
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;
	
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
	
	public static TrackResource ExportTrack (Context context,Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return ExportTrack(trackID, export_format, total, initDate, endDate, accessTokenPregenerated);
	}

	
}
