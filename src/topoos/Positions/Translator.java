package topoos.Positions;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import android.content.Context;
import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.*;
import topoos.APIAccess.Results.*;
import topoos.APIAccess.Results.Objects.*;
import topoos.Exception.TopoosException;

class Translator {
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	private static Position AddPrivate(Integer Type, Double lat, Double lng,
			Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity,
			Integer bearing, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsAdd positionsAdd = new PositionsAdd("Add", method, format,
					version, accessTokenPregenerated.getAccessToken(), null,
					lat, lng, accuracy, vaccuracy, elevation, timestamp,
					velocity, Type, bearing, trackID);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsAdd, positionResult);
			position = positionResult.getPosition();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return position;
	}

	public static Position Add(Double lat, Double lng, Integer trackID,
			Integer accuracy, Integer vaccuracy, Integer elevation,
			Date timestamp, Integer velocity, Integer bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.POS, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddAlarmEnd(Double lat, Double lng, Integer trackID,
			Integer accuracy, Integer vaccuracy, Integer elevation,
			Date timestamp, Integer velocity, Integer bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.ALARM_END, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddAlarmInit(Double lat, Double lng,
			Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity,
			Integer bearing, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return AddPrivate(PositionsAdd.ALARM_INIT, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddGPSNo(Double lat, Double lng, Integer trackID,
			Integer accuracy, Integer vaccuracy, Integer elevation,
			Date timestamp, Integer velocity, Integer bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.GPS_NO, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddGPSOk(Double lat, Double lng, Integer trackID,
			Integer accuracy, Integer vaccuracy, Integer elevation,
			Date timestamp, Integer velocity, Integer bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.GPS_OK, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position AddTrackEnd(Double lat, Double lng, Integer trackID,
			Integer accuracy, Integer vaccuracy, Integer elevation,
			Date timestamp, Integer velocity, Integer bearing,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return AddPrivate(PositionsAdd.TRACK_END, lat, lng, trackID, accuracy,
				vaccuracy, elevation, timestamp, velocity, bearing,
				accessTokenPregenerated);
	}

	public static Position Get(Integer posID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsGet positionsGet = new PositionsGet("AddTrackEnd", method,
					format, version, accessTokenPregenerated.getAccessToken(),
					posID, null, null);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsGet, positionResult);
			position = positionResult.getPosition();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return position;
	}

	public static Position GetLastUser(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Position position = null;
		if (accessTokenPregenerated.isValid()) {
			PositionsGet positionsGet = new PositionsGet("AddTrackEnd", method,
					format, version, accessTokenPregenerated.getAccessToken(),
					null, userID, null);
			PositionResult positionResult = new PositionResult();
			APICaller.ExecuteOperation(positionsGet, positionResult);
			position = positionResult.getPosition();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return position;
	}

	public static List<Position> GetBetweenDays(Date initDate, Date endDate,
			AccessTokenOAuth accessTokenPregenerated) {
		List<Position> positions = null;
		/*
		 * if (accessTokenPregenerated.isValid()) { PositionsGet_between
		 * positionsGet_between = new PositionsGet_between("AddTrackEnd",
		 * method, format, version,
		 * accessTokenPregenerated.getAccessToken(),initDate,endDate,null);
		 * PositionResult positionResult = new PositionResult();
		 * APICaller.ExecuteOperation(positionsGet_between, positionResult);
		 * position = positionResult.getPosition(); }
		 */
		return positions;
	}

	public static Position Add(Context context, Double lat, Double lng,
			Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity, Integer bearing)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Add(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, accessTokenPregenerated);
	}

	public static Position AddAlarmEnd(Context context, Double lat, Double lng,
			Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity, Integer bearing)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddAlarmEnd(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, accessTokenPregenerated);
	}

	public static Position AddAlarmInit(Context context, Double lat,
			Double lng, Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity, Integer bearing)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddAlarmInit(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, accessTokenPregenerated);
	}

	public static Position AddGPSNo(Context context, Double lat, Double lng,
			Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity, Integer bearing)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddGPSNo(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, accessTokenPregenerated);
	}

	public static Position AddGPSOk(Context context, Double lat, Double lng,
			Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity, Integer bearing)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddGPSOk(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, accessTokenPregenerated);
	}

	public static Position AddTrackEnd(Context context, Double lat, Double lng,
			Integer trackID, Integer accuracy, Integer vaccuracy,
			Integer elevation, Date timestamp, Integer velocity, Integer bearing)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return AddTrackEnd(lat, lng, trackID, accuracy, vaccuracy, elevation,
				timestamp, velocity, bearing, accessTokenPregenerated);
	}

	public static Position Get(Context context, Integer posID)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Get(posID, accessTokenPregenerated);
	}

	public static Position GetLastUser(Context context, String userID)
			throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetLastUser(userID, accessTokenPregenerated);

	}

	public static List<Position> GetBetweenDays(Context context, Date initDate,
			Date endDate) {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetBetweenDays(initDate, endDate, accessTokenPregenerated);
	}

}
