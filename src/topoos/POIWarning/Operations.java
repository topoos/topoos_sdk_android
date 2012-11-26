package topoos.POIWarning;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.Operations.POISWarningAdd;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

public class Operations {
	
		public static final String	TYPE_CLOSED=POISWarningAdd.TYPE_CLOSED;
		public static final String	TYPE_DUPLICATED=POISWarningAdd.TYPE_DUPLICATED;
		public static final String	TYPE_WRONG_INDICATOR=POISWarningAdd.TYPE_WRONG_INDICATOR;
		public static final String	TYPE_WRONG_INFO=POISWarningAdd.TYPE_WRONG_INFO;

		public static List<POIDataWarning> Get(Integer[] POISID, String type,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.Get(POISID, type, accessTokenPregenerated);
		}

		public static List<POIDataWarning> GetAll(String type,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.GetAll(type, accessTokenPregenerated);
		}

		public static POIWarning AddClosed(Integer POI_ID,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.AddClosed(POI_ID, accessTokenPregenerated);
		}

		public static POIWarning AddDuplicated(Integer POI_ID,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.AddDuplicated(POI_ID, accessTokenPregenerated);
		}

		public static POIWarning AddWrongIndicator(Integer POI_ID, Double lat,
				Double lng, Double accuracy, Double vaccuracy, Double elevation,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.AddWrongIndicator(POI_ID, lat, lng, accuracy, vaccuracy, elevation, accessTokenPregenerated);
		}

		public static POIWarning AddWrongInfo(Integer POI_ID, String name,
				Integer[] categories, String desc, String address,
				String cross_street, String city, String country,
				String postal_code, String phone, String twitter,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.AddWrongInfo(POI_ID, name, categories, desc, address, cross_street, city, country, postal_code, phone, twitter, accessTokenPregenerated);
		}

		public static Boolean Delete(Integer[] POISID, String type,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.Delete(POISID, type, accessTokenPregenerated);
		}

		public static Boolean DeleteAll(String type,
				AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
			return Translator.DeleteAll(type, accessTokenPregenerated);
		}

		public static List<POIDataWarning> Get(Context context, Integer[] POIID,
				String type) throws IOException, TopoosException {
			return Translator.Get(context, POIID, type);
		}

		public static List<POIDataWarning> GetAll(Context context, String type) throws IOException, TopoosException {
			return Translator.GetAll(context, type);
		}

		public static POIWarning AddClosed(Context context, Integer POI_ID) throws IOException, TopoosException {
			return Translator.AddClosed(context, POI_ID);
		}

		public static POIWarning AddDuplicated(Context context, Integer POI_ID) throws IOException, TopoosException {
			return Translator.AddDuplicated(context, POI_ID);
		}

		public static POIWarning AddWrongIndicator(Context context, Integer POI_ID,
				Double lat, Double lng, Double accuracy, Double vaccuracy,
				Double elevation) throws IOException, TopoosException {
			return Translator.AddWrongIndicator(context, POI_ID, lat, lng, accuracy, vaccuracy, elevation);
		}

		public static POIWarning AddWrongInfo(Context context, Integer POI_ID,
				String name, Integer[] categories, String desc, String address,
				String cross_street, String city, String country,
				String postal_code, String phone, String twitter) throws IOException, TopoosException {
			return Translator.AddWrongInfo(context, POI_ID, name, categories, desc, address, cross_street, city, country, postal_code, phone, twitter);
		}

		public static Boolean Delete(Context context, Integer[] POIID, String type) throws IOException, TopoosException {
			return Translator.Delete(context, POIID, type);
		}

		public static Boolean DeleteAll(Context context, String type) throws IOException, TopoosException {
			return Translator.DeleteAll(context, type);
		}


}
