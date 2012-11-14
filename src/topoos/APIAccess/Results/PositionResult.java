package topoos.APIAccess.Results;

import java.util.Date;

import org.json.JSONObject;
import org.json.JSONTokener;
import topoos.APIAccess.Results.Objects.*;

public class PositionResult extends APICallResult {

	private Position position=null;
	
	/**
	 * @param error
	 * @param result
	 * @param position
	 */
	public PositionResult(String error, String result, Position position) {
		super(error, result);
		this.position = position;
	}

	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		Integer id = null;
		String device = null;
		Date timestamp = null;
		Date registerTime = null;
		Double latitude = null;
		Double longitude = null;
		Double elevation = null;
		PositionType positionType = null;
		Double accuracy = null;
		Double vaccuracy = null;
		Double bearing = null;
		Double velocity = null;
		String track_id = null;
		try {
			JSONObject jObject = (JSONObject) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			id = jObject.getInt("id");
			device = jObject.getString("device");
			latitude = jObject.getDouble("latitude");
			longitude = jObject.getDouble("longitude");
			elevation = jObject.getDouble("elevation");
			accuracy = jObject.getDouble("accuracy");
			vaccuracy = jObject.getDouble("vaccuracy");
			bearing = jObject.getDouble("bearing");
			velocity = jObject.getDouble("velocity");
			track_id = jObject.getString("track_id");
			timestamp = APIUtils.toDateString(jObject
					.getString("timestamp"));
			registerTime = APIUtils.toDateString(jObject
					.getString("registerTime"));
			positionType = new PositionType(jObject.getJSONObject(
					"positiotype").getString("id"), jObject.getJSONObject(
					"positiotype").getString("description"));
			
			this.position= new Position( id,  device,
					 timestamp,  registerTime,  latitude,
					 longitude,  elevation,  positionType,
					 accuracy,  vaccuracy,  bearing,  velocity,
					 track_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

}