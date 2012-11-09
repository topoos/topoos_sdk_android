package topoos.OAuth;

public class Operations {
	//OAuthAuthtoken
	public void GetLoginClientSideURI (String clientID, String scope){
		
	}
	//OAuthAccesstoken_Resfresh
	public void GetLoginServerSideURI (String clientID, String clientSecret, String scope){

	}
	
	//OAuthAccesstoken_Getaccess
	public void RefreshAccessToken(String clienID, String clientSecret, String refreshToken){
		
	}
	
	public void GetAccessToken ( String clientID, String clientSecret, String code, String redirectURI){
		//OAuthAccesstoken_Resfresh
	}
	
	//CheckAccessToken
	public void CheckAccessToken (String accessTokenPregenerated){
		//
	}

}
