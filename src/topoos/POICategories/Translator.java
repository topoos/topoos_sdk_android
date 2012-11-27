package topoos.POICategories;

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
 * @author MAJS
 * 
 */
class Translator {

	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	public static List<POICategory> GetAll(
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
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
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return GetAll;
	}

	public static POICategory Add(String name,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POICategory pOICategory = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesAdd pOISCategoriesAdd = new POISCategoriesAdd("Add",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), name);
			POICategoryResult pOICategoryResult = new POICategoryResult();
			APICaller.ExecuteOperation(pOISCategoriesAdd, pOICategoryResult);
			pOICategory = pOICategoryResult.getPoiCategory();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOICategory;
	}

	public static Boolean Update(Integer categoryID, String name,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POICategory pOICategory = null;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesAdd pOISCategoriesAdd = new POISCategoriesAdd(
					"Update", method, format, version,
					accessTokenPregenerated.getAccessToken(), name);
			POICategoryResult pOICategoryResult = new POICategoryResult();
			APICaller.ExecuteOperation(pOISCategoriesAdd, pOICategoryResult);
			pOICategory = pOICategoryResult.getPoiCategory();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOICategory != null;
	}

	public static Boolean Delete(Integer categoryID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		boolean delete = false;
		if (accessTokenPregenerated.isValid()) {
			POISCategoriesDelete pOISCategoriesDelete = new POISCategoriesDelete(
					"Delete", method, format, version,
					accessTokenPregenerated.getAccessToken(), categoryID);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(pOISCategoriesDelete, genericResult);
			delete = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}

	public static List<POICategory> GetAll(Context context) throws IOException,
			TopoosException {
		return GetAll(AccessTokenOAuth.GetAccessToken(context));
	}

	public static POICategory Add(Context context, String name)
			throws IOException, TopoosException {
		return Add(name, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Boolean Update(Context context, Integer categoryID,
			String name) throws IOException, TopoosException {
		return Update(categoryID, name, AccessTokenOAuth.GetAccessToken(context));
	}

	public static Boolean Delete(Context context, Integer categoryID)
			throws IOException, TopoosException {
		return Delete(categoryID, AccessTokenOAuth.GetAccessToken(context));
	}

}
