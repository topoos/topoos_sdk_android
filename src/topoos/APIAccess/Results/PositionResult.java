package topoos.APIAccess.Results;

import java.util.Date;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;
// TODO: Auto-generated Javadoc

/**
 * The Class PositionResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class PositionResult extends APICallResult {

	/** The position. */
	private Position position=null;
	
	/**
	 * Instantiates a new position result.
	 */
	public PositionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new position result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public PositionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new position result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param position the position
	 */
	public PositionResult(String error, String result, Position position) {
		super(error, result);
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
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
			device = APIUtils.getStringorNull(jObject,"device");
			latitude = jObject.getDouble("latitude");
			longitude = jObject.getDouble("longitude");
			elevation = jObject.getDouble("elevation");
			accuracy = jObject.getDouble("accuracy");
			vaccuracy = jObject.getDouble("vaccuracy");
			bearing = jObject.getDouble("bearing");
			velocity = jObject.getDouble("velocity");
			track_id = APIUtils.getStringorNull(jObject,"track_id");
			timestamp = APIUtils.toDateString(jObject
					.getString("timestamp"));
			registerTime = APIUtils.toDateString(jObject
					.getString("registerTime"));
			positionType = new PositionType(APIUtils.getStringorNull(jObject.getJSONObject(
					"position_type"),"id"), APIUtils.getStringorNull(jObject.getJSONObject(
					"position_type"),"description"));
			
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
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

}