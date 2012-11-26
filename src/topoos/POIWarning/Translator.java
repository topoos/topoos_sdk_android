package topoos.POIWarning;

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

	public static List<POIDataWarning> Get(Integer[] POISID, String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		List<POIDataWarning> pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			String strPOIID = "";
			if (POISID != null) {
				for (int i = 0; i < POISID.length; i++) {
					if (i < POISID.length - 1) {
						strPOIID = strPOIID + POISID[i] + ",";
					} else {
						strPOIID = strPOIID + POISID[i];
					}
				}
			}
			POISWarning pOISWarning = new POISWarning("Get", method, format,
					version, accessTokenPregenerated.getAccessToken(),
					strPOIID, type);
			POIWarningCollectionResult pOIWarningCollectionResult = new POIWarningCollectionResult();
			APICaller.ExecuteOperation(pOISWarning, pOIWarningCollectionResult);
			pOIWarning = pOIWarningCollectionResult.getPOIDataWarnings();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	public static List<POIDataWarning> GetAll(String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		List<POIDataWarning> pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarning pOISWarning = new POISWarning("GetAll", method, format,
					version, accessTokenPregenerated.getAccessToken(), null,
					type);
			POIWarningCollectionResult pOIWarningCollectionResult = new POIWarningCollectionResult();
			APICaller.ExecuteOperation(pOISWarning, pOIWarningCollectionResult);
			pOIWarning = pOIWarningCollectionResult.getPOIDataWarnings();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	public static POIWarning AddClosed(Integer POI_ID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("AddClosed",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_CLOSED);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	public static POIWarning AddDuplicated(Integer POI_ID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("GetAll",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_DUPLICATED);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	public static POIWarning AddWrongIndicator(Integer POI_ID, Double lat,
			Double lng, Double accuracy, Double vaccuracy, Double elevation,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningAdd pOISWarningAdd = new POISWarningAdd(
					"AddWrongIndicator", method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_WRONG_INDICATOR, lat, lng, accuracy,
					vaccuracy, elevation);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	public static POIWarning AddWrongInfo(Integer POI_ID, String name,
			Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		POIWarning pOIWarning = null;
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
			POISWarningAdd pOISWarningAdd = new POISWarningAdd("AddWrongInfo",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POI_ID,
					POISWarningAdd.TYPE_WRONG_INFO,
					!strcategories.equals("") ? strcategories : null, name,
					desc, address, cross_street, city, country, postal_code,
					phone, twitter);
			POIWarningResult pOIWarningResult = new POIWarningResult();
			APICaller.ExecuteOperation(pOISWarningAdd, pOIWarningResult);
			pOIWarning = pOIWarningResult.getPoiWarning();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return pOIWarning;
	}

	public static Boolean Delete(Integer[] POISID, String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Boolean delete = null;
		if (accessTokenPregenerated.isValid()) {
			String strPOIID = "";
			if (POISID != null) {
				for (int i = 0; i < POISID.length; i++) {
					if (i < POISID.length - 1) {
						strPOIID = strPOIID + POISID[i] + ",";
					} else {
						strPOIID = strPOIID + POISID[i];
					}
				}
			}
			POISWarningDelete pOISWarningDelete = new POISWarningDelete(
					"Delete", method, format, version,
					accessTokenPregenerated.getAccessToken(),
					!strPOIID.equals("") ? strPOIID : null, type);
			GenericResult genenicResult = new GenericResult();
			APICaller.ExecuteOperation(pOISWarningDelete, genenicResult);
			delete = genenicResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}

	public static Boolean DeleteAll(String type,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Boolean delete = null;
		if (accessTokenPregenerated.isValid()) {
			POISWarningDelete pOISWarningDelete = new POISWarningDelete(
					"DeleteAll", method, format, version,
					accessTokenPregenerated.getAccessToken(), null, type);
			GenericResult genenicResult = new GenericResult();
			APICaller.ExecuteOperation(pOISWarningDelete, genenicResult);
			delete = genenicResult.getCode().equals(200);
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}

	public static List<POIDataWarning> Get(Context context, Integer[] POIID,
			String type) throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Get(POIID, type, accessTokenPregenerated);
	}

	public static List<POIDataWarning> GetAll(Context context, String type)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetAll(type, accessTokenPregenerated);
	}

	public static POIWarning AddClosed(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddClosed(POI_ID, accessTokenPregenerated);
	}

	public static POIWarning AddDuplicated(Context context, Integer POI_ID)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddDuplicated(POI_ID, accessTokenPregenerated);
	}

	public static POIWarning AddWrongIndicator(Context context, Integer POI_ID,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddWrongIndicator(POI_ID, lat, lng, accuracy, vaccuracy,
				elevation, accessTokenPregenerated);
	}

	public static POIWarning AddWrongInfo(Context context, Integer POI_ID,
			String name, Integer[] categories, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddWrongInfo(POI_ID, name, categories, desc, address,
				cross_street, city, country, postal_code, phone, twitter,
				accessTokenPregenerated);
	}

	public static Boolean Delete(Context context, Integer[] POIID, String type)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Delete(POIID, type, accessTokenPregenerated);
	}

	public static Boolean DeleteAll(Context context, String type)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return DeleteAll(type, accessTokenPregenerated);
	}
}
