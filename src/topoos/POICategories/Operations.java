package topoos.POICategories;

import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Operations.POISWarning;
import topoos.APIAccess.Results.Objects.POICategory;
import android.content.Context;

public class Operations {
	
	public static final String	TYPE_CLOSED=POISWarning.TYPE_CLOSED;
	public static final String	TYPE_DUPLICATED=POISWarning.TYPE_DUPLICATED;
	public static final String	TYPE_WRONG_INDICATOR=POISWarning.TYPE_WRONG_INDICATOR;
	public static final String	TYPE_WRONG_INFO=POISWarning.TYPE_WRONG_INFO;
	
	public static	List<POICategory> GetAll (AccessTokenOAuth accessTokenPregenerated){
		return Translator.GetAll(accessTokenPregenerated);
	}
	public static	POICategory Add (String name, AccessTokenOAuth accessTokenPregenerated){
		return Translator.Add(name, accessTokenPregenerated);
	}
	
	public static	Boolean Update (Integer categoryID,String name, AccessTokenOAuth accessTokenPregenerated){
		return Translator.Update(categoryID, name, accessTokenPregenerated);	
	}
	
	public static	Boolean Delete (Integer categoryID, AccessTokenOAuth accessTokenPregenerated){
		return Translator.Delete(categoryID, accessTokenPregenerated);
	}
	
	public static	List<POICategory> GetAll (Context context){
		return Translator.GetAll(context);
	}
	public static	POICategory Add (Context context, String name){
		return Translator.Add(context, name);
	}
	public static	Boolean Update (Context context, Integer categoryID,String name){
		return Translator.Update(context, categoryID, name);
	}
	public static	Boolean Delete (Context context, Integer categoryID){
		return Translator.Delete(context, categoryID);
	}	
	

}
