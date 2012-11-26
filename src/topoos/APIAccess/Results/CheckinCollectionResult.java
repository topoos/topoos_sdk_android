package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

public class CheckinCollectionResult extends APICallResult {

	private CheckinCollection checkinCollection = null;

	/**
	 * 
	 */
	public CheckinCollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public CheckinCollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param checkinCollection
	 */
	public CheckinCollectionResult(String error, String result,
			CheckinCollection checkinCollection) {
		super(error, result);
		this.checkinCollection = checkinCollection;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(this.Result)
					.nextValue();
			ArrayList<Checkin> array = new ArrayList<Checkin>();
			// Extracting content
			for (int i = 0; i < jArray.length(); i++) {
				array.add(new Checkin(jArray.getJSONObject(i).getInt("id"),
						jArray.getJSONObject(i).getInt("device_id"), jArray
								.getJSONObject(i).getInt("poi_id"), APIUtils
								.toDateString(jArray.getJSONObject(i)
										.getString("register_time")), APIUtils
								.toDateString(jArray.getJSONObject(i)
										.getString("timestamp"))));
			}
			this.checkinCollection=new CheckinCollection(array);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * @return the checkinCollection
	 */
	public CheckinCollection getCheckinCollection() {
		return checkinCollection;
	}

	/**
	 * @param checkinCollection
	 *            the checkinCollection to set
	 */
	public void setCheckinCollection(CheckinCollection checkinCollection) {
		this.checkinCollection = checkinCollection;
	}

}
