package topoos;

import java.net.URLDecoder;
import java.util.Calendar;


// TODO: Auto-generated Javadoc
/*
 * Clase que actua como interfaz a la parte nativa de la aplicaci�n, y viceversa
 */
/**
 * Class that acting as interface to the native side of the application and vice versa.
 *
 * @author topoos
 */
class WebInterface {
	
	/** The Constant ParamKey_AccessToken. */
	private static final String ParamKey_AccessToken = "access_token";
	
	/** The Constant ParamKey_ExpiresIn. */
	private static final String ParamKey_ExpiresIn = "expires_in";
	//private static final String ParamKey_TokenType = "token_type";
	//private static final String ParamKey_RefreshToken = "refresh_token";	
	/**
	 * Gets the access token.
	 *
	 * @param url the url
	 * @param redirect_uri the redirect_uri
	 * @return the access token o auth
	 */
	public static AccessTokenOAuth GetAccessToken (String url, String redirect_uri)
	{
		AccessTokenOAuth Access = null;
		
    	if (url.startsWith(redirect_uri))
    	{
    		String AuxAccessToken = "";
    		String AuxExpiresIn = "";
    		//String AuxTokenType= "";
    		//String AuxRefreshToken= "";
    		
    		String[] urlFragment = url.split("#");
    		
    		if (urlFragment.length > 1) //#key1=value1&key2=value2...
    		{   			
    			String[] Params = urlFragment[1].split("&"); //key1=value1
    			for (String param : Params)
    			{
    				String[] pair = param.split("=");
    				
    				String key = URLDecoder.decode(pair[0]);
    				String value = URLDecoder.decode(pair[1]);
    				
    				if (key.equalsIgnoreCase(ParamKey_AccessToken))
    				{
    					AuxAccessToken = value;
    				}
    				else if (key.equalsIgnoreCase(ParamKey_ExpiresIn))
    				{
    					AuxExpiresIn = value;
    				}
    				/*else if (key.equalsIgnoreCase(ParamKey_RefreshToken))
    				{
    					AuxRefreshToken = value;
    				}
    				else if (key.equalsIgnoreCase(ParamKey_TokenType))
    				{
    					AuxTokenType = value;
    				}*/
    			}
    		}
    		//Calendar calendar= new Calen
    		Calendar cal = Calendar.getInstance();
			cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, Integer.parseInt(AuxExpiresIn));
    		Access = new AccessTokenOAuth(AuxAccessToken, cal.getTimeInMillis());
    	}
    	
    	return Access;
	}
}
