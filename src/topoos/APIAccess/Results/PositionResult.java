package topoos.APIAccess.Results;

import java.util.Date;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

public class PositionResult extends APICallResult {

	private Position position=null;
	
	/**
	 * 
	 */
	public PositionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public PositionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

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
	public void setParameters() throws TopoosException {
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
					"position_type").getString("id"), jObject.getJSONObject(
					"position_type").getString("description"));
			
			this.position= new Position( id,  device,
					 timestamp,  registerTime,  latitude,
					 longitude,  elevation,  positionType,
					 accuracy,  vaccuracy,  bearing,  velocity,
					 track_id);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
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