package topoos;

import java.net.URLEncoder;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Implements the login activity
 * 
 * @author topoos
 * 
 */
@SuppressLint("SetJavaScriptEnabled")
public class LoginActivity extends Activity {

	public static final int RESULT_OK = Activity.RESULT_OK;
	public static final int RESULT_CANCELED = Activity.RESULT_CANCELED;
	public static final int RESULT_FIRST_USER = Activity.RESULT_FIRST_USER;
	public static final int RESULT_TOPOOSERROR = 2;
	public static final String SCOPE_OFFLINE_ACCESS="offline_access";
	public static final String SCOPE_EMAIL="email";
	public static final String SCOPE_PROFILE="profile";
	

	public static final String CLIENT_ID = "client_id";
	public static final String REDIRECT_URI = "redirect_uri";
	
	private String url_login = Constants.TOPOOSURILOGIN + "/oauth/authtoken";
	private String param_redirect_uri = "redirect_uri";
	private String value_redirect_uri = Constants.TOPOOSURILOGIN
			+ "/oauth/dummy";
	private String param_response_type = "response_type";
	private String value_response_type = "token";
	private String param_scope = "scope";
	private String value_scope = "";
	private String param_client_id = "client_id";
	private String value_client_id = "";
	private String param_agent = "agent";
	private String value_agent = "mobile";
	private Activity activity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity = this;
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Intent intent = this.getIntent();
		Bundle extras = intent.getExtras();
		if (extras != null && extras.containsKey("client_id")) {
			value_client_id = extras.getString("client_id");
			if (extras.containsKey("redirect_uri")) {
				value_redirect_uri = extras.getString("redirect_uri");
			}
			value_scope=null;
			if (extras.getBoolean(SCOPE_OFFLINE_ACCESS)){
				value_scope=SCOPE_OFFLINE_ACCESS;
			}
			if (extras.getBoolean(SCOPE_EMAIL)){
				if(value_scope==null)
					value_scope=SCOPE_EMAIL;
				else
					value_scope=value_scope+","+SCOPE_EMAIL;
			}
			if (extras.getBoolean(SCOPE_PROFILE)){
				if(value_scope==null)
					value_scope=SCOPE_PROFILE;
				else
					value_scope=value_scope+","+SCOPE_PROFILE;
			}
			if(value_scope==null)
				value_scope="";
			WebView webview = new WebView(this);
			setContentView(webview);
			webview.setWebChromeClient(new LoginViewChromeClient());
			webview.setWebViewClient(new LoginViewClient());
			webview.getSettings().setJavaScriptEnabled(true);
			webview.clearCache(true);
			webview.getUrl();
			CookieSyncManager.createInstance(getApplicationContext());
			CookieManager cookieManager = CookieManager.getInstance();
			cookieManager.removeAllCookie();
			String language = Locale.getDefault().getLanguage(); // en-us
			if (language == "es")
				language = language + "-ES";
			else
				language = language + "-GB";

			webview.getSettings()
					.setUserAgentString(
							"Mozilla/5.0 (Linux; U; Android 2.0; "
									+ language
									+ " ; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
			String scope="";
			if(!value_scope.equals("")){
				scope="&"+param_scope+"="+URLEncoder.encode(value_scope);
			}
			webview.loadUrl(url_login + "?" + param_response_type + "="
					+ value_response_type + "&" + param_client_id + "="
					+ value_client_id + "&" + param_redirect_uri + "="
					+ URLEncoder.encode(value_redirect_uri) + "&" + param_agent
					+ "=" + value_agent
					+scope
					);
		} else {
			setResult(RESULT_CANCELED);
			this.finish();

		}

	}
	
	@Override
	public void onBackPressed() {
		setResult(RESULT_CANCELED);
		super.onBackPressed();
	}
	
	private class LoginViewClient extends WebViewClient {
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
			if (Constants.DEBUG)
				Log.i(Constants.TAG, url);
			AccessTokenOAuth access = WebInterface.GetAccessToken(url,
					value_redirect_uri);
			if (access != null) {
				access.save_Token(activity);
				setResult(RESULT_OK);
				activity.finish();
			}
		}
	}

	private class LoginViewChromeClient extends WebChromeClient {
		@Override
		public boolean onJsAlert(WebView view, String url, String message,
				JsResult result) {
			if (Constants.DEBUG)
				Log.i(Constants.TAG, "JsAlert: " + message);
			new AlertDialog.Builder(view.getContext()).setMessage(message).setTitle("Alert")
					.setCancelable(true).show();
			result.confirm();
			return true;
		}
	}



}
