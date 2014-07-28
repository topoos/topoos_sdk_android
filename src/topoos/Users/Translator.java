/**
 * Copyright 2014-present topoos
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package topoos.Users;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

/**
 * 
 * @author topoos
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
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User Get(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		User user = null;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRShow usersUSRShow = new UsersUSRShow("Get", method, format,
					version, accessTokenPregenerated.getAccessToken(), userID);
			UserResult userResult = new UserResult();
			APICaller.ExecuteOperation(usersUSRShow, userResult);
			user = userResult.getUser();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return user;
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
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		boolean groupSet = false;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRAdd_group usersUSRAdd_group = new UsersUSRAdd_group(
					"GroupSet", method, format, version,
					accessTokenPregenerated.getAccessToken(), userID, groupID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(usersUSRAdd_group, genericResult);
			groupSet = genericResult.getCode() != null
					&& genericResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return groupSet;
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
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		boolean groupRemove = false;
		if (accessTokenPregenerated.isValid()) {
			UsersUSRRemove_group usersUSRRemove_group = new UsersUSRRemove_group(
					"GroupRemove", method, format, version,
					accessTokenPregenerated.getAccessToken(), userID, groupID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(usersUSRRemove_group, genericResult);
			groupRemove = genericResult.getCode() != null
					&& genericResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
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
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPOIGet(Integer POIID,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		List<UserIdPosition> list = null;
		UsersNear usersNear = null;
		if (accessTokenPregenerated.isValid()) {
			UsersGet_near usersGet_near = new UsersGet_near("NearPOIGet",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POIID, radius,
					activeTrack, groupID, usersCount);
			UsersNearResult usersNearResult = new UsersNearResult();
			APICaller.ExecuteOperation(usersGet_near, usersNearResult);
			if (usersNearResult.getUsersnear() != null) {
				usersNear = usersNearResult.getUsersnear();
				list = usersNear.getUserPositions();
			}
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
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
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static List<UserIdPosition> NearPositionGet(Double lat, Double lng,
			Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		List<UserIdPosition> list = null;
		UsersNear usersNear = null;
		if (accessTokenPregenerated.isValid()) {
			UsersGet_near usersGet_near = new UsersGet_near("NearPOIGet",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), lat, lng, radius,
					activeTrack, groupID, usersCount);
			UsersNearResult usersNearResult = new UsersNearResult();
			APICaller.ExecuteOperation(usersGet_near, usersNearResult);
			if (usersNearResult.getUsersnear() != null) {
				usersNear = usersNearResult.getUsersnear();
				list = usersNear.getUserPositions();
			}
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return list;
	}

	/**
	 * 
	 * @param context
	 * @param userID
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static User Get(Context context, String userID) throws IOException,
			TopoosException {
		return Get(userID, AccessTokenOAuth.GetAccessToken(context));
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
	public static boolean GroupSet(Context context, String userID,
			Integer groupID) throws IOException, TopoosException {
		return GroupSet(userID, groupID, AccessTokenOAuth.GetAccessToken(context));
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
	public static boolean GroupRemove(Context context, String userID,
			Integer groupID) throws IOException, TopoosException {
		return GroupRemove(userID, groupID, AccessTokenOAuth.GetAccessToken(context));
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
	public static List<UserIdPosition> NearPOIGet(Context context,
			Integer POIID, Integer radius, Integer groupID, Integer usersCount,
			Boolean activeTrack) throws IOException, TopoosException {
		return NearPOIGet(POIID, radius, groupID, usersCount, activeTrack,
				AccessTokenOAuth.GetAccessToken(context));
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
	public static List<UserIdPosition> NearPositionGet(Context context,
			Double lat, Double lng, Integer radius, Integer groupID,
			Integer usersCount, Boolean activeTrack) throws IOException,
			TopoosException {
		return NearPositionGet(lat, lng, radius, groupID, usersCount,
				activeTrack, AccessTokenOAuth.GetAccessToken(context));
	}
	
	
	/***
	 * 
	 * @param api_key
	 * @param username
	 * @return
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Boolean ResetPass (String api_key , String username) throws IOException, TopoosException{
		boolean reset = false;
		UsersResetPass resetPass = new UsersResetPass("Reset_pass", method, format,
					version, api_key, username);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(resetPass, genericResult);
			reset = genericResult.getCode() == 200;
		
		return reset;
	}

}
