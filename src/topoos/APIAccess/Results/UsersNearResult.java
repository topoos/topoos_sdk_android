package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONTokener;
import topoos.APIAccess.Results.Objects.*;

/**
 * 
 * @author MAJS
 * 
 */
public class UsersNearResult extends APICallResult {

	private UsersNear usersnear = null;

	@Override
	public void setParameters() {
		ArrayList<UserIdPosition> userPositions = null;
		// Processing result
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(Result).nextValue();
			userPositions = new ArrayList<UserIdPosition>();
			for (int i = 0; i < jArray.length(); i++) {
				String user_id = jArray.getJSONObject(i).getString("user_id");
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
			// TODO: handle exception
		}
	}

}
