package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

// TODO: Auto-generated Javadoc

/**
 * The Class CheckinResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class CheckinResult extends APICallResult {

	/** The checkin. */
	private Checkin checkin = null;

	/**
	 * Instantiates a new checkin result.
	 */
	public CheckinResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new checkin result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public CheckinResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new checkin result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param checkin
	 *            the checkin
	 */
	public CheckinResult(String error, String result, Checkin checkin) {
		super(error, result);
		this.checkin = checkin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				this.checkin = new Checkin(APIUtils.getIntegerorNull(jObject,
						"id"), APIUtils.getIntegerorNull(jObject, "device_id"),
						APIUtils.getIntegerorNull(jObject, "poi_id"),
						APIUtils.toDateString(jObject
								.getString("register_time")),
						APIUtils.toDateString(jObject.getString("timestamp")));
			} catch (Exception e) {
				if (Constants.DEBUG) {
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		} else {
			if (Constants.DEBUG) {
				Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
			}
		}
	}

	/**
	 * Gets the checkin.
	 * 
	 * @return the checkin
	 */
	public Checkin getCheckin() {
		return checkin;
	}

	/**
	 * Sets the checkin.
	 * 
	 * @param checkin
	 *            the checkin to set
	 */
	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

}
