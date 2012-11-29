package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;
/**
 * @see APICallResult
 * @author MAJS
 *
 */
public class PositionCollectionResult extends APICallResult {

	List<Position> positions = null;

	
	/**
	 * 
	 */
	public PositionCollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	/**
	 * @param error
	 * @param result
	 */
	public PositionCollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param error
	 * @param result
	 * @param positions
	 */
	public PositionCollectionResult(String error, String result,
			List<Position> positions) {
		super(error, result);
		this.positions = positions;
	}


	private Position parsePosition(JSONObject job) throws TopoosException{
		Position position=null;
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
			JSONObject jObject = job;
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
			
			position= new Position( id,  device,
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
		return position;
	}



	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		ArrayList<Position> array=null;
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(this.Result)
					.nextValue();
			array = new ArrayList<Position>();
			// Extracting content
			for (int i = 0; i < jArray.length(); i++) {
				array.add(parsePosition(jArray.getJSONObject(i)));
			}
			//this.checkinCollection=new CheckinCollection(array);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
		this.positions=array;
	}



	/**
	 * @return the positions
	 */
	public List<Position> getPositions() {
		return positions;
	}



	/**
	 * @param positions the positions to set
	 */
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	
	
}
