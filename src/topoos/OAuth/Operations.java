package topoos.OAuth;

import java.net.URLEncoder;
import topoos.AccessTokenOAuth;
import topoos.Constants;
import android.content.Context;

/**
 * 
 * @author MAJS
 * 
 */
public class Operations {

	/*private static final String ParamKey_AccessToken = "access_token";
	private static final String ParamKey_ExpiresIn = "expires_in";
	private static final String ParamKey_TokenType = "token_type";
	private static final String ParamKey_RefreshToken = "refresh_token";*/

	/**
	 * 
	 * @param clientID
	 * @return
	 */
	public String GetLoginClientSideURI(String clientID) {
		String url = Constants.TOPOOSURILOGIN+"/oauth/authtoken?response_type=token&client_id="
				+ clientID
				+ "&redirect_uri="
				+ URLEncoder.encode("https://login.topoos.com/oauth/dummy")
				+ "&agent=mobile";
		return url;
	}

	/**
	 * 
	 * @param clientID
	 * @return
	 */
	public String GetLoginServerSideURI(String clientID) {
		String url = Constants.TOPOOSURILOGIN+"/oauth/authtoken?client_id="
				+ clientID + "&redirect_uri="
				+ URLEncoder.encode(Constants.TOPOOSURILOGIN+"/oauth/dummy")
				+ "&response_type=code";
		return url;
	}

/*
	public AccessTokenOAuth RefreshAccessToken(Context context,
			String clientID, String clientSecret, String refreshToken) {
		AccessTokenOAuth RefreshAccessToken = null;

		AccessTokenOAuth accessTokenPregenerated = AccessTokenOAuth.GetAccessToken(context);
		if (!accessTokenPregenerated.isValid()
				& accessTokenPregenerated.getRefreshToken() != null) {
			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("https://login.topoos.com");
				// httppost.setHeader("Accept", "application/json");
				httppost.setHeader("Content-Type",
						"application/x-www-form-urlencoded");
				HttpParams httpParams = httpclient.getParams();
				HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
				HttpConnectionParams.setSoTimeout(httpParams, 5000);

				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("grant_type",
						"resfresh_token".toString()));
				nameValuePairs.add(new BasicNameValuePair("client_id", clientID
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("refresh_token",
						refreshToken.toString()));
				nameValuePairs.add(new BasicNameValuePair("client_secret",
						clientSecret));
				try {
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpclient.execute(httppost);
					String statusResult = null;
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						statusResult = EntityUtils.toString(response
								.getEntity());
					}
					if (statusResult != null) {
						JSONObject jObject = (JSONObject) new JSONTokener(
								statusResult).nextValue();
						RefreshAccessToken = new AccessTokenOAuth(
								jObject.getString("Access_token"),
								jObject.getLong("expires_in"),
								jObject.getString("refresh_token"), "bearer");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			} catch (Exception e) {
				System.out.println("EXc=" + e);
			}
		}
		RefreshAccessToken.Save_Token(context);
		return RefreshAccessToken;
	}


	public AccessTokenOAuth GetAccessToken(String url, String redirect_uri) {
		AccessTokenOAuth Access = null;

		// Capturamos el access token si procede
		if (url.startsWith(redirect_uri)) {
			String AuxAccessToken = "";
			String AuxExpiresIn = "";
			String AuxTokenType = "";
			String AuxRefreshToken = "";

			String[] urlFragment = url.split("#");

			if (urlFragment.length > 1) // #key1=value1&key2=value2...
			{
				String[] Params = urlFragment[1].split("&"); // key1=value1
				for (String param : Params) {
					String[] pair = param.split("=");

					String key = URLDecoder.decode(pair[0]);
					String value = URLDecoder.decode(pair[1]);

					if (key.equalsIgnoreCase(ParamKey_AccessToken)) {
						AuxAccessToken = value;
					} else if (key.equalsIgnoreCase(ParamKey_ExpiresIn)) {
						AuxExpiresIn = value;
					} else if (key.equalsIgnoreCase(ParamKey_RefreshToken)) {
						AuxExpiresIn = value;
					} else if (key.equalsIgnoreCase(ParamKey_TokenType)) {
						AuxExpiresIn = value;
					}
				}
			}
			// Calendar calendar= new Calen
			Calendar cal = Calendar.getInstance();
			cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, Integer.parseInt(AuxExpiresIn));
			Access = new AccessTokenOAuth(AuxAccessToken,
					cal.getTimeInMillis(), AuxRefreshToken, AuxTokenType);
		}

		return Access;
	}
*/
	/**
	 * 
	 * @param accessTokenOAuth
	 * @return
	 */
	public boolean CheckAccessToken(AccessTokenOAuth accessTokenOAuth) {
		return accessTokenOAuth.isValid();
	}

	/**
	 * 
	 * @param context
	 * @return
	 */
	public boolean CheckAccessToken(Context context) {
		return AccessTokenOAuth.GetAccessToken(context).isValid();
	}

}
