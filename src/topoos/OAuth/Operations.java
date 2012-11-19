package topoos.OAuth;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.AccessTokenOAuth;
import topoos.Constants;
import topoos.APIAccess.Operations.APIOperation;
import topoos.APIAccess.Results.APICallResult;
import android.content.Context;
import android.util.Log;

public class Operations {
	//OAuthAuthtoken
	public String GetLoginClientSideURI (String clientID){
		String url="https://login.topoos.com/oauth/authtoken?response_type=token&client_id="+clientID+"&redirect_uri=https://login.topoos.com/oauth/dummy&agent=mobile";
			HttpClient hc = new DefaultHttpClient();
			String OpURI = url;
			if (Constants.DEBUG)
				Log.d(Constants.TAG, OpURI);
			HttpPost post = new HttpPost(OpURI);

			HttpResponse rp = hc.execute(post);

			HttpParams httpParams = hc.getParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					Constants.HTTP_WAITING_MILISECONDS);
			HttpConnectionParams.setSoTimeout(httpParams,
					Constants.HTTP_WAITING_MILISECONDS);
			if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result.setResult(EntityUtils.toString(rp.getEntity()));
				result.setError(null);
				result.setParameters();
			} else {
				result.setResult(null);
				result.setError("" + rp.getStatusLine().getStatusCode());
			}
		}
		return page;
	}
	
	//OAuthAccesstoken_Resfresh
	public void GetLoginServerSideURI (String clientID, String clientSecret, String scope){

	}
	
	//OAuthAccesstoken_Getaccess
	public AccessTokenOAuth RefreshAccessToken(Context context, String clientID, String clientSecret, String refreshToken){
		AccessTokenOAuth RefreshAccessToken=null;
		
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		if(!accessTokenPregenerated.isValid()&accessTokenPregenerated.getRefreshToken()!=null){
			int statusCode = -1;
			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("https://login.topoos.com");
				//httppost.setHeader("Accept", "application/json");
				httppost.setHeader("Content-Type",
						"application/x-www-form-urlencoded");
				HttpParams httpParams = httpclient.getParams();
				HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
				HttpConnectionParams.setSoTimeout(httpParams, 5000);

				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair(
						"grant_type", "resfresh_token"
								.toString()));
				nameValuePairs.add(new BasicNameValuePair(
						"client_id", clientID
								.toString()));
				nameValuePairs.add(new BasicNameValuePair(
						"refresh_token", refreshToken
								.toString()));
				nameValuePairs.add(new BasicNameValuePair(
						"client_secret", clientSecret));
				try {
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpclient.execute(httppost);
					StatusLine statusLine = response.getStatusLine();
					statusCode = statusLine.getStatusCode();
					String statusResult =null;
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						statusResult=EntityUtils.toString(response.getEntity());
					}
					if(statusResult!=null){
						JSONObject jObject=(JSONObject) new JSONTokener(statusResult).nextValue();
						RefreshAccessToken= new AccessTokenOAuth( jObject.getString("Access_token"),  jObject.getLong("expires_in"), jObject.getString("refresh_token"), "bearer");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			} catch (Exception e) {
				System.out.println("EXc=" + e);
			}
		}
		return RefreshAccessToken;
	}
	
	public void GetAccessToken ( String clientID, String clientSecret, String code, String redirectURI){
		//OAuthAccesstoken_Resfresh
		
	}
	
	//CheckAccessToken
	public boolean CheckAccessToken (AccessTokenOAuth accessTokenOAuth){
		return accessTokenOAuth.isValid();
	}
	//CheckAccessToken
	public boolean CheckAccessToken (Context context){
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return accessTokenPregenerated.isValid();
	}

}
