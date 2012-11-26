package topoos.POI;

import java.io.IOException;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.POI;
import android.content.Context;

public class Operations {
	
	public static	POI Add (String name, Double lat,Double lng, Integer[] categories,Double accuracy,Double vaccuracy,Double elevation, String desc, String address,String cross_street, String city,String country, String postal_code,String phone,String twitter, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.Add(name, lat, lng, categories, accuracy, vaccuracy, elevation, desc, address, cross_street, city, country, postal_code, phone, twitter, accessTokenPregenerated);
	}
	
	public static	POI Get (Integer POIID,AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.Get(POIID, accessTokenPregenerated);
	}
	
	public static	List<POI> GetNear (Double lat,Double lng,Integer radius,Integer[] categories, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.GetNear(lat, lng, radius, categories, accessTokenPregenerated);
	}
	
	public static List<POI> GetWhere(Integer[] categories, Integer[] POIS, String city,String country,String postal_code,String q, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.GetWhere(categories, POIS, city, country, postal_code, q, accessTokenPregenerated);
	}
	
	
	public static Boolean Update (Integer POIID,String name, Double lat, Double lng, Integer[] categories, Double accuracy,Double vaccuracy,Double elevation,String desc,String address, String cross_stret, String city, String country, String postal_code, String phone, String twitter, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.Update(POIID, name, lat, lng, categories, accuracy, vaccuracy, elevation, desc, address, cross_stret, city, country, postal_code, phone, twitter, accessTokenPregenerated);
	}
	
	public static	Boolean Delete (Integer POIID,AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.Delete(POIID, accessTokenPregenerated);
	}
	
	
	public static	POI Add (Context context, String name, Double lat,Double lng, Integer[] categories,Double accuracy,Double vaccuracy,Double elevation, String desc, String address,String cross_street, String city,String country, String postal_code,String phone,String twitter) throws IOException, TopoosException{
		return Translator.Add(context, name, lat, lng, categories, accuracy, vaccuracy, elevation, desc, address, cross_street, city, country, postal_code, phone, twitter);
	}
	
	public static	POI Get (Context context, Integer POIID) throws IOException, TopoosException{
		return Translator.Get(context, POIID);
	}
	
	public static	List<POI> GetNear (Context context, Double lat,Double lng,Integer radius,Integer[] categories) throws IOException, TopoosException{
		return Translator.GetNear(context, lat, lng, radius, categories);
		
	}
	
	public static List<POI> GetWhere(Context context, Integer[] categories, Integer[] POIS, String city,String country,String postal_code,String q) throws IOException, TopoosException{
		return Translator.GetWhere(context, categories, POIS, city, country, postal_code, q);
	}
	
	
	public static Boolean Update (Context context,Integer POIID,String name, Double lat, Double lng, Integer[] categories, Double accuracy,Double vaccuracy,Double elevation,String desc,String address, String cross_stret, String city, String country, String postal_code, String phone, String twitter) throws IOException, TopoosException{
		return Translator.Update(context, POIID, name, lat, lng, categories, accuracy, vaccuracy, elevation, desc, address, cross_stret, city, country, postal_code, phone, twitter);
	}
	
	public static	Boolean Delete (Context context, Integer POIID) throws IOException, TopoosException{
		return Translator.Delete(context, POIID);
	}
	
}
