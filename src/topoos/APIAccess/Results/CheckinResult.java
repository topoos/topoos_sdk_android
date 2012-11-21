package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.APIAccess.Results.Objects.*;
import topoos.Exception.TopoosException;

public class CheckinResult extends APICallResult {

	private Checkin checkin = null;

	/**
	 * 
	 */
	public CheckinResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public CheckinResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param checkin
	 */
	public CheckinResult(String error, String result, Checkin checkin) {
		super(error, result);
		this.checkin = checkin;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		try {
			JSONObject jObject = (JSONObject) new JSONTokener(this.Result)
					.nextValue();
			// Extracting content
			this.checkin = new Checkin(jObject.getInt("id"),
					jObject.getInt("device_id"), jObject.getInt("poi_id"),
					APIUtils.toDateString(jObject.getString("register_time")),
					APIUtils.toDateString(jObject.getString("timestamp")));
		}catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * @return the checkin
	 */
	public Checkin getCheckin() {
		return checkin;
	}

	/**
	 * @param checkin
	 *            the checkin to set
	 */
	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

}
