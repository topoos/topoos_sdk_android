package topoos.Export;

import java.io.IOException;
import java.util.Date;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Operations.
 *
 * @author MAJS
 */
public class Operations {
	
	/** The Constant DATA_TRACK. */
	public static final String DATA_TRACK= topoos.APIAccess.Operations.ExportLayerTrack.DATA_TRACK;
	
	/** The Constant TYPE_LAYER. */
	public static final String TYPE_LAYER= topoos.APIAccess.Operations.ExportLayerTrack.TYPE_LAYER;
	
	/** The Constant EXPORT_FORMAT. */
	public static final String EXPORT_FORMAT=topoos.APIAccess.Operations.ExportLayerTrack.EXPORT_FORMAT;
	
	/**
	 * Export track.
	 *
	 * @param accessTokenPregenerated the access token pregenerated
	 * @param trackID the track id
	 * @param export_format the export_format
	 * @param total the total
	 * @param initDate the init date
	 * @param endDate the end date
	 * @return TrackResource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (AccessTokenOAuth accessTokenPregenerated, Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		return Translator.ExportTrack(trackID, export_format, total, initDate, endDate, accessTokenPregenerated);
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
	 * @return TrackResource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TopoosException the topoos exception
	 */
	public static TrackResource ExportTrack (Context context,Integer trackID, String export_format, Integer total,Date initDate,Date endDate) throws IOException, TopoosException{
		return Translator.ExportTrack(context, trackID, export_format, total, initDate, endDate);
	}
	
}
