package topoos.Checkin;

import java.util.Date;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.Checkin;
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
	 */
	public static Checkin Add(Integer POIID, Date timestamp,
			AccessTokenOAuth accessTokenPregenerated) {
		return Translator.Add(POIID, timestamp, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param checkinID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static Checkin Get(Integer checkinID,
			AccessTokenOAuth accessTokenPregenerated) {
		return Translator.Get(checkinID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param userID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static Checkin GetLast(String userID,
			AccessTokenOAuth accessTokenPregenerated) {
		return Translator.GetLast(userID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param POIID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static List<Checkin> GetPOI(Integer POIID,
			AccessTokenOAuth accessTokenPregenerated) {
		return Translator.GetPOI(POIID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @param timestamp
	 * @return
	 */
	public static Checkin Add(Context context, Integer POIID, Date timestamp) {
		return Translator.Add(context, POIID, timestamp);
	}

	public static Checkin Get(Context context, Integer checkinID) {
		return Translator.Get(context, checkinID);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @return
	 */
	public static Checkin GetLast(Context context, String userID) {
		return Translator.GetLast(context, userID);
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @return
	 */
	public static List<Checkin> GetPOI(Context context, Integer POIID) {
		return Translator.GetPOI(context, POIID);
	}
}
