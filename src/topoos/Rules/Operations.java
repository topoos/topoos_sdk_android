package topoos.Rules;

import java.io.IOException;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Rule;
import android.content.Context;

public class Operations {
	public static Rule AddTrackOutOfBounds(
			AccessTokenOAuth accessTokenPregenerated, Integer track,
			Double lat, Double lng, Integer radius) throws IOException,
			TopoosException {
		return Translator.AddTrackOutOfBounds(track, lat, lng, radius,
				accessTokenPregenerated);
	}

	public static Rule AddTrackOutOfBounds(Context context, Integer track,
			Double lat, Double lng, Integer radius) throws IOException,
			TopoosException {
		return Translator.AddTrackOutOfBounds(context, track, lat, lng, radius);
	}
}
