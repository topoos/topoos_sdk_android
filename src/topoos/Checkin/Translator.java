package topoos.Checkin;
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

public class Translator {
	
	private static String method = "GET";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;
	
	public static Checkin Add(Integer POIID, Date timestamp,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		Checkin checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinAdd checkinAdd = new CheckinAdd("Add", method, format,
					version, accessTokenPregenerated.getAccessToken(), POIID,
					null, timestamp);
			CheckinResult checkinResult = new CheckinResult();
			APICaller.ExecuteOperation(checkinAdd, checkinResult);
			checkin = checkinResult.getCheckin();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	public static Checkin Get(Integer checkinID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		Checkin checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinGet checkinGet = new CheckinGet("Get", method, format,
					version, accessTokenPregenerated.getAccessToken(),
					checkinID);
			CheckinResult checkinResult = new CheckinResult();
			APICaller.ExecuteOperation(checkinGet, checkinResult);
			checkin = checkinResult.getCheckin();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	public static Checkin GetLast(String userID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		Checkin checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinGet_last checkinGet_last = new CheckinGet_last("GetLast",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), userID);
			CheckinResult checkinResult = new CheckinResult();
			APICaller.ExecuteOperation(checkinGet_last, checkinResult);
			checkin = checkinResult.getCheckin();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	public static List<Checkin> GetPOI(Integer POIID,
			AccessTokenOAuth accessTokenPregenerated) throws IOException, TopoosException {
		List<Checkin> checkin = null;
		if (accessTokenPregenerated.isValid()) {
			CheckinGet_where checkinGet_where = new CheckinGet_where("GetPOI",
					method, format, version,
					accessTokenPregenerated.getAccessToken(), POIID);
			CheckinCollectionResult checkinResult = new CheckinCollectionResult();
			APICaller.ExecuteOperation(checkinGet_where, checkinResult);
			checkin = checkinResult.getCheckinCollection().getCheckIns();
		} else { throw new TopoosException(TopoosException.NOT_VALID_TOKEN); }
		return checkin;
	}

	public static Checkin Add(Context context, Integer POIID, Date timestamp) throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Add(POIID, timestamp, accessTokenPregenerated);
	}

	public static Checkin Get(Context context, Integer checkinID) throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return Get(checkinID, accessTokenPregenerated);
	}

	public static Checkin GetLast(Context context, String userID) throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetLast(userID, accessTokenPregenerated);
	}

	public static List<Checkin> GetPOI(Context context, Integer POIID) throws IOException, TopoosException {
		AccessTokenOAuth accessTokenPregenerated = new AccessTokenOAuth();
		accessTokenPregenerated.Load_Token(context);
		return GetPOI(POIID, accessTokenPregenerated);
	}
}
