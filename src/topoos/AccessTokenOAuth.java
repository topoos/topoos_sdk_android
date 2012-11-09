package topoos;


import java.io.Serializable;
import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;

public class AccessTokenOAuth implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3333451415638359179L;
	
	String AccessToken;
	Long ExpiresIn;
	String RefreshToken;
	String TokenType;
	
	private String KEY_ACCESS_TOKEN="";
	private String KEY_EXPIREIN="";
	private String KEY_REFRESHTOKEN="";
	private String KEY_TOKENTYPE="";
	
	/*private static final String ParamKey_AccessToken = "access_token";
	private static final String ParamKey_ExpiresIn = "expires_in";
	private static final String ParamKey_TokenType = "token_type";
	private static final String ParamKey_RefrestToken = "refresh_token";
	 */
	public AccessTokenOAuth(String token, Long expiresIn, String refreshToken, String tokenType) {
		super();
		AccessToken=token;
		ExpiresIn=expiresIn;
		RefreshToken=refreshToken;
		TokenType=tokenType;		
	}
	

	
	public String getAccessToken() {
		return AccessToken;
	}

	public void setAccessToken(String token) {
		AccessToken = token;
	}
	
	public synchronized void Save_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(KEY_ACCESS_TOKEN,this.AccessToken );
		editor.putLong(KEY_EXPIREIN,this.ExpiresIn );
		editor.putString(KEY_REFRESHTOKEN,this.RefreshToken );
		editor.putString(KEY_TOKENTYPE,this.TokenType );
		editor.commit();	
	}
	
	public synchronized void Load_Token(Context context){
		SharedPreferences settings = context.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		this.AccessToken=settings.getString(KEY_ACCESS_TOKEN,"");
		this.ExpiresIn=settings.getLong(KEY_EXPIREIN,-1);
		this.RefreshToken=settings.getString(KEY_REFRESHTOKEN,"");
		this.TokenType=settings.getString(KEY_TOKENTYPE,"");
	}	
	
	public boolean isValid(){
		boolean isvalid=true;
		Calendar cal=Calendar.getInstance();
		isvalid=cal.getTimeInMillis()<ExpiresIn;
		isvalid=isvalid&&(AccessToken!=null &&!AccessToken.equals(""));
		isvalid=isvalid&&(RefreshToken!=null &&!RefreshToken.equals(""));
		isvalid=isvalid&&(TokenType!=null &&!TokenType.equals(""));
		return isvalid;
	}

	/*private static void SavePreferences_Token(Context cntx, AccessTokenOAuth access) {
		SharedPreferences settings = cntx.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		try {
			editor.putString("AccessToken", AccessTokenOAuth.toString(access));
		} catch (IOException e) {
			e.printStackTrace();
		}
		editor.commit();
	}

	private static AccessTokenOAuth LoadPreferences_Token(Context cntx) {
		AccessTokenOAuth access=null;
		SharedPreferences settings = cntx.getSharedPreferences(
				"PREFER", Context.MODE_PRIVATE);
		String str_access=settings.getString("AccessToken","");
		if(str_access!=null && !str_access.equals("")){
			try {
				access= (AccessTokenOAuth) AccessTokenOAuth.fromString(str_access);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return access;
	}*/
	
    /** Read the object from Base64 string. */
    /*private static Object fromString( String s ) throws IOException ,
                                                        ClassNotFoundException {
        byte [] data = Base64Coder.decode( s );
        ObjectInputStream ois = new ObjectInputStream( 
                                        new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }*/

    /** Write the object to a Base64 string. */
    /*private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return new String( Base64Coder.encode( baos.toByteArray() ) );
    }*/
}
