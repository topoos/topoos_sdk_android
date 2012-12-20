package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersNearResult.
 *
 * @see APICallResult
 * @author MAJS
 */
public class UsersNearResult extends APICallResult {

	/** The usersnear. */
	private UsersNear usersnear = null;

	
	/**
	 * Instantiates a new users near result.
	 */
	public UsersNearResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new users near result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public UsersNearResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new users near result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param usersnear the usersnear
	 */
	public UsersNearResult(String error, String result, UsersNear usersnear) {
		super(error, result);
		this.usersnear = usersnear;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		ArrayList<UserIdPosition> userPositions = null;
		// Processing result
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(Result).nextValue();
			userPositions = new ArrayList<UserIdPosition>();
			for (int i = 0; i < jArray.length(); i++) {
				String user_id = APIUtils.getStringorNull(jArray.getJSONObject(i),"user_id");
				Double latitude = jArray.getJSONObject(i)
						.getJSONObject("position").getDouble("latitude");
				Double logitude = jArray.getJSONObject(i)
						.getJSONObject("position").getDouble("longitude");
				Double accuracy = jArray.getJSONObject(i)
						.getJSONObject("position").getDouble("accuracy");

				UserPosition position = new UserPosition(latitude, logitude,
						accuracy);
				userPositions.add(new UserIdPosition(user_id, position));
			}
			this.usersnear= new UsersNear(userPositions);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * Gets the usersnear.
	 *
	 * @return the usersnear
	 */
	public UsersNear getUsersnear() {
		return usersnear;
	}

	/**
	 * Sets the usersnear.
	 *
	 * @param usersnear the usersnear to set
	 */
	public void setUsersnear(UsersNear usersnear) {
		this.usersnear = usersnear;
	}

}
