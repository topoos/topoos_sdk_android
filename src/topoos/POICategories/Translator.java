package topoos.POICategories;

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

	public static List<POICategory> GetAll(
			AccessTokenOAuth accessTokenPregenerated) {
		List<POICategory> GetAll = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategories pOISCategories = new POISCategories("GetAll",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), true);
			POICategoryCollectionResult pOICategoryCollectionResult = new POICategoryCollectionResult();
			APICaller.ExecuteOperation(pOISCategories,
					pOICategoryCollectionResult);
			GetAll = pOICategoryCollectionResult.getPoiCategoryCollection()
					.getCategories();
		}
		return GetAll;
	}

	public static POICategory Add(String name,
			AccessTokenOAuth accessTokenPregenerated) {
		POICategory pOICategory = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesAdd pOISCategoriesAdd = new POISCategoriesAdd("Add",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), name);
			POICategoryResult pOICategoryResult = new POICategoryResult();
			APICaller.ExecuteOperation(pOISCategoriesAdd, pOICategoryResult);
			pOICategory = pOICategoryResult.getPoiCategory();
		}
		return pOICategory;
	}

	public static Boolean Update(Integer categoryID, String name,
			AccessTokenOAuth accessTokenPregenerated) {
		POICategory pOICategory = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesAdd pOISCategoriesAdd = new POISCategoriesAdd("Add",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), name);
			POICategoryResult pOICategoryResult = new POICategoryResult();
			APICaller.ExecuteOperation(pOISCategoriesAdd, pOICategoryResult);
			pOICategory = pOICategoryResult.getPoiCategory();
		}
		return pOICategory != null;
	}

	public static Boolean Delete(Integer categoryID,
			AccessTokenOAuth accessTokenPregenerated) {
		boolean delete = false;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesDelete pOISCategoriesDelete = new POISCategoriesDelete(
					"Delete", method, format, version,
					accessTokenPregenerated.getAccessToken(), categoryID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(pOISCategoriesDelete, genericResult);
			delete = genericResult.getCode() == 200;
		}
		return delete;
	}

	public static List<POICategory> GetAll(Context context) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetAll(accessTokenPregenerated);
	}

	public static POICategory Add(Context context, String name) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Add(name, accessTokenPregenerated);
	}

	public static Boolean Update(Context context, Integer categoryID,
			String name) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Update(categoryID, name, accessTokenPregenerated);
	}

	public static Boolean Delete(Context context, Integer categoryID) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Delete(categoryID, accessTokenPregenerated);
	}

}
