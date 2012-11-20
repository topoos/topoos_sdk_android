package topoos.Users;

import java.io.IOException;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.User;
import topoos.APIAccess.Results.Objects.UserIdPosition;
import topoos.Exception.TopoosException;
import android.content.Context;

public class Operations {

	/**
	 * 
	 * @param userID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static User Get(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.Get(userID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static boolean GroupSet(String userID, Integer groupID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.GroupSet(userID, groupID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static boolean GroupRemove(String userID, Integer groupID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.GroupRemove(userID, groupID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param POIID
	 * @param radius
	 * @param groupID
	 * @param usersCount
	 * @param activeTrack
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<UserIdPosition> NearPOIGet(Integer POIID,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.NearPOIGet(POIID, radius, groupID, usersCount, activeTrack, accessTokenPregenerated);  
	}

	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param radius
	 * @param groupID
	 * @param numberUsers
	 * @param activeTrack
	 * @param accessTokenPregenerated
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<UserIdPosition> NearPositionGet(Double lat,
			Double lng, Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		return Translator.NearPositionGet(lat, lng, radius, groupID, usersCount, activeTrack, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static User Get(Context context, String userID) throws IOException, TopoosException {
		return Translator.Get(context, userID);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @param groupID
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static boolean GroupSet(Context context, String userID, Integer groupID) throws IOException, TopoosException {
		return Translator.GroupSet(context, userID, groupID);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @param groupID
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static boolean GroupRemove(Context context, String userID, Integer groupID) throws IOException, TopoosException {
		return Translator.GroupRemove(context, userID, groupID);
	}

	/**
	 * 
	 * @param context
	 * @param POIID
	 * @param radius
	 * @param groupID
	 * @param usersCount
	 * @param activeTrack
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<UserIdPosition> NearPOIGet(Context context, Integer POIID,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack) throws IOException, TopoosException {
		return Translator.NearPOIGet(context, POIID, radius, groupID, usersCount, activeTrack);
	}

	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param radius
	 * @param groupID
	 * @param numberUsers
	 * @param activeTrack
	 * @return
	 * @throws IOException 
	 * @throws TopoosException 
	 */
	public static List<UserIdPosition> NearPositionGet(Context context, Double lat,
			Double lng, Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack) throws IOException, TopoosException {
		return Translator.NearPositionGet(context, lat, lng, radius, groupID, usersCount, activeTrack);
	}
	
}
