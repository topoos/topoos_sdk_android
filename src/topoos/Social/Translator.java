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

package topoos.Social;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

class Translator {

	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	public static Relationship AddFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Relationship rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialAddFollow relAdd = new SocialAddFollow("SocialFollowAdd", method, format, version,
					accessTokenPregenerated.getAccessToken(), targetUserId);
			SocialRelationshipResult relResult = new SocialRelationshipResult();
			APICaller.ExecuteOperation(relAdd, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationship();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}

	public static Relationship DeleteFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Relationship rel = null;
		if (accessTokenPregenerated.isValid()) {
			SocialDeleteFollow relDelete = new SocialDeleteFollow("SocialFollowDelete", method, format, version,
					accessTokenPregenerated.getAccessToken(), targetUserId);
			SocialRelationshipResult relResult = new SocialRelationshipResult();
			APICaller.ExecuteOperation(relDelete, relResult, APICaller.SERVICE_SOCIAL);
			rel = relResult.getRelationship();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return rel;
	}
	
	/*
	
	
	
	
	
	
	
	public static POI GetFriendship(Integer POIID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POI poi = null;
		if (accessTokenPregenerated.isValid()) {
			POISGet pOISGet = new POISGet("Get", method, format, version,
					accessTokenPregenerated.getAccessToken(), POIID);
			POIResult poiResult = new POIResult();
			APICaller.ExecuteOperation(pOISGet, poiResult);
			poi = poiResult.getPoi();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return poi;
	}

	public static List<POI> GetFollowed(Double lat, Double lng, Integer radius,
			Integer[] categories,Integer total, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		List<POI> poilist = null;
		if (accessTokenPregenerated.isValid()) {
			String strcategories = "";
			if (categories != null) {
				for (int i = 0; i < categories.length; i++) {
					if (i < categories.length - 1) {
						strcategories = strcategories + categories[i] + ",";
					} else {
						strcategories = strcategories + categories[i];
					}
				}
			}
			POISGet_near pOISGet_near = new POISGet_near("GetNear", method,
					format, version, accessTokenPregenerated.getAccessToken(),
					lat, lng, radius, !strcategories.equals("") ? strcategories
							: null, total);
			POICollectionResult pOICollectionResult = new POICollectionResult();
			APICaller.ExecuteOperation(pOISGet_near, pOICollectionResult);
			poilist = pOICollectionResult.getPoicollection().getPoiList();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return poilist;
	}

	public static List<POI> GetFollowers(Integer[] categories, Integer[] POIS,
			String city, String country, String postal_code, String q,Integer total,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		List<POI> poilist = null;
		if (accessTokenPregenerated.isValid()) {
			String strcategories = "";
			if (categories != null) {
				for (int i = 0; i < categories.length; i++) {
					if (i < categories.length - 1) {
						strcategories = strcategories + categories[i] + ",";
					} else {
						strcategories = strcategories + categories[i];
					}
				}
			}
			String strpois = "";
			if (POIS != null) {
				for (int i = 0; i < POIS.length; i++) {
					if (i < POIS.length - 1) {
						strpois = strpois + POIS[i] + ",";
					} else {
						strpois = strpois + POIS[i];
					}
				}
			}
			POISGet_where pOISGet_where = new POISGet_where("GetWhere", method,
					format, version, accessTokenPregenerated.getAccessToken(),
					!strpois.equals("") ? strpois : null,
					!strcategories.equals("") ? strcategories : null, city,
					country, postal_code, q, total);
			POICollectionResult pOICollectionResult = new POICollectionResult();
			APICaller.ExecuteOperation(pOISGet_where, pOICollectionResult);
			poilist = pOICollectionResult.getPoicollection().getPoiList();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return poilist;
	}


	public static Boolean DeleteFollow(Integer POIID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		boolean delete = false;
		if (accessTokenPregenerated.isValid()) {
			POISDelete pOISDelete = new POISDelete("Delete", method, format,
					version, accessTokenPregenerated.getAccessToken(), POIID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(pOISDelete, genericResult);
			delete = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}

	public static POI Add(Context context, String name, Double lat, Double lng,
			Boolean geocode, Integer[] categories, Double accuracy, Double vaccuracy,
			Double elevation, String desc, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter) throws IOException, TopoosException {
		return Add(name, lat, lng, geocode, categories, accuracy, vaccuracy, elevation,
				desc, address, cross_street, city, country, postal_code, phone,
				twitter, AccessTokenOAuth.GetAccessToken(context));
	}

	public static POI GetCounters(Context context, Integer POIID) throws IOException,
			TopoosException {
		return Get(POIID, AccessTokenOAuth.GetAccessToken(context));
	}

	public static List<POI> GetFriendsRecommendation(Context context, Double lat, Double lng,
			Integer radius, Integer[] categories, Integer total) throws IOException,
			TopoosException {
		return GetNear(lat, lng, radius, categories,total, AccessTokenOAuth.GetAccessToken(context));

	}
*/

}
