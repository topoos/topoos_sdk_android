package topoos.Export;

import java.util.Date;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.*;

/**
 * 
 * @author MAJS
 *
 */
public class Operations {
	/**
	 * 
	 * @param trackID
	 * @param export_format
	 * @param total
	 * @param initDate
	 * @param endDate
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static TrackResource ExportTrack (Integer trackID, String export_format, Integer total,Date initDate,Date endDate,  AccessTokenOAuth  accessTokenPregenerated){
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
	 */
	public static TrackResource ExportTrack (Context context,Integer trackID, String export_format, Integer total,Date initDate,Date endDate){
		return Translator.ExportTrack(context, trackID, export_format, total, initDate, endDate);
	}
	
}
