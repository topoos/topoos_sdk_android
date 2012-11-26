package topoos.Export;

import java.io.IOException;
import java.util.Date;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

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
	 * @param trackID
	 * @param export_format
	 * @param total
	 * @param initDate
	 * @param endDate
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static TrackResource ExportTrack (Integer trackID, String export_format, Integer total,Date initDate,Date endDate,  AccessTokenOAuth  accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.ExportTrack(trackID, export_format, total, initDate, endDate, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param context
	 * @param trackID
	 * @param export_format
	 * @param total
	 * @param initDate
	 * @param endDate
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static TrackResource ExportTrack (Context context,Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		return Translator.ExportTrack(context, trackID, export_format, total, initDate, endDate);
	}
	
}
