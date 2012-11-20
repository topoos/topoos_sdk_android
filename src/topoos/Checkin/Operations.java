package topoos.Checkin;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.Checkin;
import topoos.Exception.TopoosException;
import android.content.Context;

/**
 * 
 * @author MAJS
 * 
 */
public class Operations {
	/**
	 * 
	 * @param POIID
	 * @param timestamp
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Checkin Add(Integer POIID, Date timestamp,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.Add(POIID, timestamp, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param checkinID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Checkin Get(Integer checkinID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.Get(checkinID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param userID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Checkin GetLast(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.GetLast(userID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param POIID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<Checkin> GetPOI(Integer POIID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.GetPOI(POIID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @param timestamp
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Checkin Add(Context context, Integer POIID, Date timestamp) throws IOException, TopoosException {
		return Translator.Add(context, POIID, timestamp);
	}

	public static Checkin Get(Context context, Integer checkinID) throws IOException, TopoosException {
		return Translator.Get(context, checkinID);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static Checkin GetLast(Context context, String userID) throws IOException, TopoosException {
		return Translator.GetLast(context, userID);
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<Checkin> GetPOI(Context context, Integer POIID) throws IOException, TopoosException {
		return Translator.GetPOI(context, POIID);
	}
}
