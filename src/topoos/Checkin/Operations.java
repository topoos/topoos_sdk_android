package topoos.Checkin;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Checkin;
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
	 * @return Checkin
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Checkin Add(AccessTokenOAuth accessTokenPregenerated,
			Integer POIID, Date timestamp) throws IOException, TopoosException {
		return Translator.Add(POIID, timestamp, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param checkinID
	 * @param accessTokenPregenerated
	 * @return Checkin
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Checkin Get(AccessTokenOAuth accessTokenPregenerated,
			Integer checkinID) throws IOException, TopoosException {
		return Translator.Get(checkinID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param userID
	 * @param accessTokenPregenerated
	 * @return Checkin
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Checkin GetLast(AccessTokenOAuth accessTokenPregenerated,
			String userID) throws IOException, TopoosException {
		return Translator.GetLast(userID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param POIID
	 * @param accessTokenPregenerated
	 * @return List<Checkin>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<Checkin> GetPOI(
			AccessTokenOAuth accessTokenPregenerated, Integer POIID)
			throws IOException, TopoosException {
		return Translator.GetPOI(POIID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @param timestamp
	 * @return Checkin
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Checkin Add(Context context, Integer POIID, Date timestamp)
			throws IOException, TopoosException {
		return Translator.Add(context, POIID, timestamp);
	}

	public static Checkin Get(Context context, Integer checkinID)
			throws IOException, TopoosException {
		return Translator.Get(context, checkinID);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @return Checkin
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Checkin GetLast(Context context, String userID)
			throws IOException, TopoosException {
		return Translator.GetLast(context, userID);
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @return List<Checkin>
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<Checkin> GetPOI(Context context, Integer POIID)
			throws IOException, TopoosException {
		return Translator.GetPOI(context, POIID);
	}
}
