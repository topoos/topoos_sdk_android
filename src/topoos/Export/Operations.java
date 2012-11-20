package topoos.Export;

import java.io.IOException;
import java.util.Date;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.*;
import topoos.Exception.TopoosException;

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
