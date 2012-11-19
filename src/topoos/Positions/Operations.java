package topoos.Positions;

import java.util.Date;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.Results.Objects.Position;
import android.content.Context;
/**
 * 
 * @author MAJS
 *
 */
public class Operations {
	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static 	Position Add (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		return Translator.Add(lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	Position AddAlarmEnd(Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		return Translator.AddAlarmEnd(lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	Position AddAlarmInit (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		return Translator.AddAlarmInit(lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	Position AddGPSNo (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		return Translator.AddGPSNo(lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	Position AddGPSOk (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		return Translator.AddGPSOk(lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing, accessTokenPregenerated);}
	/**
	 * 
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	Position AddTrackEnd (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		return Translator.AddTrackEnd(lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param posID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	Position Get (Integer posID, AccessTokenOAuth accessTokenPregenerated){
		return Translator.Get(posID, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param userID
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	Position GetLastUser (String userID, AccessTokenOAuth accessTokenPregenerated){
		return Translator.GetLastUser(userID, accessTokenPregenerated);
	}
	/**
	 * 
	 * @param initDate
	 * @param endDate
	 * @param accessTokenPregenerated
	 * @return
	 */
	public static	List<Position> GetBetweenDays (Date initDate, Date endDate, AccessTokenOAuth accessTokenPregenerated){
		return Translator.GetBetweenDays(initDate, endDate, accessTokenPregenerated);	
	}
	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @return
	 */
	public static 	Position Add (Context context, Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing){
		return Translator.Add(context, lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing);
	}
	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @return
	 */
	public static	Position AddAlarmEnd(Context context, Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing){
		return Translator.AddAlarmEnd(context, lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing);
	}	
	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @return
	 */
	public static	Position AddAlarmInit (Context context, Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing){
		return Translator.AddAlarmInit(context, lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing);
	}
	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @return
	 */
	public static	Position AddGPSNo (Context context, Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing){
		return Translator.AddGPSNo(context, lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing);
	}
	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @return
	 */
	public static	Position AddGPSOk (Context context, Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing){
		return Translator.AddGPSOk(context, lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing);
	}
	/**
	 * 
	 * @param context
	 * @param lat
	 * @param lng
	 * @param trackID
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param bearing
	 * @return
	 */
	public static	Position AddTrackEnd (Context context, Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing){
		return Translator.AddTrackEnd(context, lat, lng, trackID, accuracy, vaccuracy, elevation, timestamp, velocity, bearing);
	}
	/**
	 * 
	 * @param context
	 * @param posID
	 * @return
	 */
	public static	Position Get (Context context, Integer posID){
		return Translator.Get(context, posID);
	}
	/**
	 * 
	 * @param context
	 * @param userID
	 * @return
	 */
	public static	Position GetLastUser (Context context, String userID){
		return Translator.GetLastUser(context, userID);

	}
	/**
	 * 
	 * @param context
	 * @param initDate
	 * @param endDate
	 * @return
	 */
	public static	List<Position> GetBetweenDays (Context context, Date initDate, Date endDate){
		return Translator.GetBetweenDays(context, initDate, endDate);
	}
	
}
