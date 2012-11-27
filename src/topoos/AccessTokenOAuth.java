package topoos;


import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
/**
 * 
 * @author MAJS
 *
 */
public class AccessTokenOAuth {



	String AccessToken;
	Long ExpiresIn;
	
	private String KEY_ACCESS_TOKEN="KEY_ACCESS_TOKEN";
	private String KEY_EXPIREIN="KEY_EXPIREIN";
	
	/**
	 * 
	 */
	public AccessTokenOAuth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param token
	 */
	public AccessTokenOAuth(String token) {
		super();
		AccessToken=token;
		ExpiresIn=(long) 0;
	}
	/**
	 * 
	 * @param token
	 * @param expiresIn
	 */
	public AccessTokenOAuth(String token, Long expiresIn) {
		super();
		AccessToken=token;
		ExpiresIn=expiresIn;
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}
	}


	
	/**
	 * @return the expiresIn
	 */
	public Long getExpiresIn() {
		return ExpiresIn;
	}


	/**
	 * @param expiresIn the expiresIn to set
	 */
	public void setExpiresIn(Long expiresIn) {
		ExpiresIn = expiresIn;
	}

	
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return AccessToken;
	}


	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		AccessToken = accessToken;
	}

	/**
	 * 
	 * @param context
	 */
	public synchronized void save_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(KEY_ACCESS_TOKEN,this.AccessToken );
		editor.putLong(KEY_EXPIREIN,this.ExpiresIn );
		editor.commit();	
		if(Constants.DEBUG){
			Log.i(Constants.TAG, this.toStringToken());
		}
	}
	/**
	 * 
	 * @param context
	 */
	private synchronized void load_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		this.AccessToken=settings.getString(KEY_ACCESS_TOKEN,"");
		this.ExpiresIn=settings.getLong(KEY_EXPIREIN,-1);
		//this.RefreshToken=settings.getString(KEY_REFRESHTOKEN,"");
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}
	}	
	/**
	 * 
	 * @param context
	 */
	private synchronized void delete_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		this.AccessToken=settings.getString(KEY_ACCESS_TOKEN,"");
		this.ExpiresIn=settings.getLong(KEY_EXPIREIN,-1);
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}		
	}
	/**
	 * 
	 * @return
	 */
	public boolean isValid(){
		boolean isvalid=true;
		Calendar cal=Calendar.getInstance();
		isvalid=cal.getTimeInMillis()<ExpiresIn || ExpiresIn==0;
		isvalid=isvalid&&(AccessToken!=null &&!AccessToken.equals(""));
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, "Valido: "+isvalid);
		}
		return isvalid;
	}
	
	
	
	/**
	 * 
	 * @param context
	 * @return
	 */
	public static AccessTokenOAuth GetAccessToken(Context context){
		AccessTokenOAuth access=new AccessTokenOAuth();
		access.load_Token(context);
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, access.toStringToken());
		}
		return access;
	}
	
	/**
	 * 
	 * @param context
	 */
	public static void DeleteAccessToken(Context context){
		AccessTokenOAuth access=new AccessTokenOAuth();
		access.delete_Token(context);
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, access.toStringToken());
		}		
	}
	
	private String toStringToken(){
		return "Token: "+this.AccessToken+" Time: "+this.ExpiresIn;
	}
}
