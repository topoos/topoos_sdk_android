package topoos.Positions;

import java.util.Date;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.APIAccess.Results.Objects.*;
class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;
	
	//Las operaciones que acceden a contenidos privados de topoos deben tener siempre un parámetro opcional AccessTokenPregenerated
	
	
	//Existe un grupo de operaciones que no utiliza token de acceso de ningún tipo. 


	//Existe otro grupo de operaciones que en lugar de token de acceso, utiliza una clave API_Key (que deberá proporcionar el desarrollador) que no requiere ningún tratamiento especial. Estas operaciones son las que acceden o consumen contenidos públicos de topoos. 

	public static 	Position Add (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("Add",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.POS, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position AddAlarmEnd(Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("AddAlarmEnd",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.ALARM_END, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position AddAlarmInit (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("AddAlarmInit",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.ALARM_INIT, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position AddGSMNo (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("AddGSMNo",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.GPS_NO, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position AddGSMOk (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("AddGSMOk",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.GPS_OK, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position AddGPSNo (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("AddGPSNo",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.GPS_NO, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position AddGPSOk (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("AddGPSOk",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.GPS_OK, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position AddTrackEnd (Double lat,Double lng, Integer trackID ,Integer accuracy,Integer vaccuracy, Integer elevation,Date timestamp,Integer velocity,Integer bearing, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("AddTrackEnd",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null, lat,
					lng,  accuracy, vaccuracy, elevation,
					timestamp, velocity, PositionsAdd.TRACK_END, bearing,
					trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position Get (Integer posID, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsGet positionsGet = new PositionsGet("AddTrackEnd",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),posID,null,null);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsGet, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	public static	Position GetLastUser (String userID, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsGet positionsGet = new PositionsGet("AddTrackEnd",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),null,userID,null);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsGet, positionResult);
			position = positionResult.getPosition();
		}
		return position;
	}
	
	/*public static	List<Position> GetBetweenDays (Date initDate, Date endDate, AccessTokenOAuth accessTokenPregenerated){
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsGet_between positionsGet_between = new PositionsGet_between("AddTrackEnd",
					method, format, version,
					accessTokenPregenerated.getAccessToken(),initDate,endDate,null);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsGet_between, positionResult);
			position = positionResult.getPosition();
		}
		return position;		
	}
	 */
}
