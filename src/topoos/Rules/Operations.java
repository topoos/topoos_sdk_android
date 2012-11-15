package topoos.Rules;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.Rule;
import android.content.Context;

public class Operations {
	public static Rule AddTrackOutOfBounds (Double lat, Double lng, Integer radius, AccessTokenOAuth accessTokenPregenerated){
		return Translator.AddTrackOutOfBounds(lat, lng, radius, accessTokenPregenerated);		
	}
	
	public static Rule AddTrackOutOfBounds (Context context, Double lat, Double lng, Integer radius){
		return Translator.AddTrackOutOfBounds(context, lat, lng, radius);
	}
}
