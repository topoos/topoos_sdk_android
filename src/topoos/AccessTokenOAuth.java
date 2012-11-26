package topoos;


import java.io.Serializable;
import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
/**
 * 
 * @author MAJS
 *
 */
public class AccessTokenOAuth implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3333451415638359179L;
	
	String AccessToken;
	Long ExpiresIn;
	String RefreshToken;
	String TokenType;
	
	private String KEY_ACCESS_TOKEN="KEY_ACCESS_TOKEN";
	private String KEY_EXPIREIN="KEY_EXPIREIN";
	private String KEY_REFRESHTOKEN="KEY_REFRESHTOKEN";
	private String KEY_TOKENTYPE="KEY_TOKENTYPE";

	public static final String TOKEN_TYPE_ADMIN="Admin";
	public static final String TOKEN_TYPE_BEARER="bearer";
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
		RefreshToken=null;
		TokenType=TOKEN_TYPE_ADMIN;	
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}
	}
	/**
	 * 
	 * @param token
	 * @param expiresIn
	 * @param refreshToken
	 * @param tokenType
	 */
	public AccessTokenOAuth(String token, Long expiresIn, String refreshToken, String tokenType) {
		super();
		AccessToken=token;
		ExpiresIn=expiresIn;
		RefreshToken=refreshToken;
		TokenType=tokenType;	
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
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return RefreshToken;
	}


	/**
	 * @param refreshToken the refreshToken to set
	 */
	public void setRefreshToken(String refreshToken) {
		RefreshToken = refreshToken;
	}


	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return TokenType;
	}


	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		TokenType = tokenType;
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
	public synchronized void Save_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(KEY_ACCESS_TOKEN,this.AccessToken );
		editor.putLong(KEY_EXPIREIN,this.ExpiresIn );
		editor.putString(KEY_REFRESHTOKEN,this.RefreshToken );
		editor.putString(KEY_TOKENTYPE,this.TokenType );
		editor.commit();	
		if(Constants.DEBUG){
			Log.i(Constants.TAG, this.toStringToken());
		}
	}
	/**
	 * 
	 * @param context
	 */
	public synchronized void Load_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		this.AccessToken=settings.getString(KEY_ACCESS_TOKEN,"");
		this.ExpiresIn=settings.getLong(KEY_EXPIREIN,-1);
		//this.RefreshToken=settings.getString(KEY_REFRESHTOKEN,"");
		this.TokenType=settings.getString(KEY_TOKENTYPE,"");
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, this.toStringToken());
		}
	}	
	/**
	 * 
	 * @param context
	 */
	public synchronized void Delete_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		this.AccessToken=settings.getString(KEY_ACCESS_TOKEN,"");
		this.ExpiresIn=settings.getLong(KEY_EXPIREIN,-1);
		//this.RefreshToken=settings.getString(KEY_REFRESHTOKEN,"");
		this.TokenType=settings.getString(KEY_TOKENTYPE,"");
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
		//isvalid=isvalid&&(RefreshToken!=null &&!RefreshToken.equals(""));
		isvalid=isvalid&&(TokenType!=null &&!TokenType.equals(""));
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
		access.Load_Token(context);
		if(Constants.DEBUG){
			//Log.i(Constants.TAG, access.toStringToken());
		}
		return access;
	}
	
	private String toStringToken(){
		return "Token: "+this.AccessToken+" Time: "+this.ExpiresIn+" TokenType: "+this.TokenType+" RefreshToken "+ this.RefreshToken;
	}
}
