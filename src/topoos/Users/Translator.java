package topoos.Users;

import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.APIAccess.Results.Objects.*;

/**
 * 
 * @author MAJS
 *
 */
class Translator {

	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	/**
	 * 
	 * @param userID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static User Get(String userID,
			AccessTokenOAuth accessTokenPregenerated) {
		User user = null;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRShow usersUSRShow = new UsersUSRShow("Get",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), userID);
			UserResult userResult = new UserResult();
			APICaller.ExecuteOperation(usersUSRShow, userResult);
			user = userResult.getUser();
		}
		return user;
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static boolean GroupSet(String userID, Integer groupID,
			AccessTokenOAuth accessTokenPregenerated) {
		boolean groupSet = false;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRAdd_group usersUSRAdd_group = new UsersUSRAdd_group(
					"GroupSet", method, format, version,
					accessTokenPregenerated.getAccessToken(), userID, groupID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(usersUSRAdd_group, genericResult);
			groupSet = genericResult.getCode() != null
					&& genericResult.getCode().equals(200);
		}
		return groupSet;
	}

	/**
	 * 
	 * @param userID
	 * @param groupID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static boolean GroupRemove(String userID, Integer groupID,
			AccessTokenOAuth accessTokenPregenerated) {
		boolean groupRemove = false;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRRemove_group usersUSRRemove_group = new UsersUSRRemove_group(
					"GroupRemove", method, format, version,
					accessTokenPregenerated.getAccessToken(), userID, groupID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(usersUSRRemove_group, genericResult);
			groupRemove = genericResult.getCode() != null
					&& genericResult.getCode().equals(200);
		}
		return groupRemove;

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
	 */
	public static List<UserIdPosition> NearPOIGet(Integer POIID,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated) {
		List<UserIdPosition> list = null;
		UsersNear usersNear = null;
		if (accessTokenPregenerated.isValid()) {
			UsersGet_near usersGet_near = new UsersGet_near(
					"NearPOIGet", method, format, version,
					accessTokenPregenerated.getAccessToken(), POIID, radius,
					activeTrack, groupID, usersCount);
			UsersNearResult usersNearResult = new UsersNearResult();
			APICaller.ExecuteOperation(usersGet_near, usersNearResult);
			if (usersNearResult.getUsersnear() != null) {
				usersNear = usersNearResult.getUsersnear();
				list = usersNear.getUserPositions();
			}
		}
		return list;
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
	 */
	public static List<UserIdPosition> NearPositionGet(Double lat,
			Double lng, Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated) {
		List<UserIdPosition> list = null;
		UsersNear usersNear = null;
		if (accessTokenPregenerated.isValid()) {
			UsersGet_near usersGet_near = new UsersGet_near(
					"NearPOIGet", method, format, version,
					accessTokenPregenerated.getAccessToken(), lat, lng, radius,
					activeTrack, groupID, usersCount);
			UsersNearResult usersNearResult = new UsersNearResult();
			APICaller.ExecuteOperation(usersGet_near, usersNearResult);
			if (usersNearResult.getUsersnear() != null) {
				usersNear = usersNearResult.getUsersnear();
				list = usersNear.getUserPositions();
			}
		}
		return list;
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @return
	 */
	public static User Get(Context context, String userID) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Get(userID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @param groupID
	 * @return
	 */
	public static boolean GroupSet(Context context, String userID, Integer groupID) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GroupSet(userID, groupID, accessTokenPregenerated);
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @param groupID
	 * @return
	 */
	public static boolean GroupRemove(Context context, String userID, Integer groupID) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GroupRemove(userID, groupID, accessTokenPregenerated);
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
	 */
	public static List<UserIdPosition> NearPOIGet(Context context, Integer POIID,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return NearPOIGet(POIID, radius, groupID, usersCount, activeTrack, accessTokenPregenerated);
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
	 */
	public static List<UserIdPosition> NearPositionGet(Context context, Double lat,
			Double lng, Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return NearPositionGet(lat, lng, radius, groupID, usersCount, activeTrack, accessTokenPregenerated);
	}

}
