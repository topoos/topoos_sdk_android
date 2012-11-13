package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.APIAccess.Results.Objects.*;

public class TrackResult extends APICallResult{

	private Track track=null;

	/**
	 * @param error
	 * @param result
	 * @param track
	 */
	public TrackResult(String error, String result, Track track) {
		super(error, result);
		this.track = track;
	}
	
	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		Integer id=null;
		String name=null;
		Integer device=null;
		ArrayList<Position> positions=null;
		
		try {
			
			JSONObject jObject = (JSONObject) new JSONTokener(Result)
			.nextValue();
			
			
			
			
			
			

			// Extracting content
			id = jObject.getString("id");
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
	 * @return the track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * @param track the track to set
	 */
	public void setTrack(Track track) {
		this.track = track;
	}

}
