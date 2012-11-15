package topoos.POICategories;

import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.POICategory;
import android.content.Context;

public class Operations {

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
