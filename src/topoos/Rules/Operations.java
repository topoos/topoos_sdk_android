package topoos.Rules;

import java.io.IOException;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.Rule;
import topoos.Exception.TopoosException;
import android.content.Context;

public class Operations {
	public static Rule AddTrackOutOfBounds (Double lat, Double lng, Integer radius, AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException{
		return Translator.AddTrackOutOfBounds(lat, lng, radius, accessTokenPregenerated);		
	}
	
	public static Rule AddTrackOutOfBounds (Context context, Double lat, Double lng, Integer radius) throws IOException, TopoosException{
		return Translator.AddTrackOutOfBounds(context, lat, lng, radius);
	}
}
