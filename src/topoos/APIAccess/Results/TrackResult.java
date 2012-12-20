package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;
// TODO: Auto-generated Javadoc

/**
 * The Class TrackResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class TrackResult extends APICallResult {

	/** The track. */
	private Track track = null;

	/**
	 * Instantiates a new track result.
	 */
	public TrackResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new track result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public TrackResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new track result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param track the track
	 */
	public TrackResult(String error, String result, Track track) {
		super(error, result);
		this.track = track;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		Integer id = null;
		String name = null;
		Integer device = null;
		ArrayList<Position> positions = null;

		try {

			JSONObject jObject = (JSONObject) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			id = jObject.getInt("id");
			device = jObject.getInt("device");
			name = APIUtils.getStringorNull(jObject,"name");

			positions = new ArrayList<Position>();
			if (jObject.optJSONArray("positions") != null) {
				JSONArray jArrayPositions = jObject.getJSONArray("positions");
				for (int i = 0; i < jArrayPositions.length(); i++) {
					Integer id_pos = null;
					String device_pos = null;
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
					JSONObject jObjectPosition = (JSONObject) new JSONTokener(
							Result).nextValue();
					// Extracting content
					id_pos = jObjectPosition.getInt("id");
					device_pos = APIUtils.getStringorNull(jObjectPosition,"device");
					latitude = jObjectPosition.getDouble("latitude");
					longitude = jObjectPosition.getDouble("longitude");
					elevation = jObjectPosition.getDouble("elevation");
					accuracy = jObjectPosition.getDouble("accuracy");
					vaccuracy = jObjectPosition.getDouble("vaccuracy");
					bearing = jObjectPosition.getDouble("bearing");
					velocity = jObjectPosition.getDouble("velocity");
					track_id = APIUtils.getStringorNull(jObjectPosition,"track_id");
					timestamp = APIUtils.toDateString(jObjectPosition
							.getString("timestamp"));
					registerTime = APIUtils.toDateString(jObjectPosition
							.getString("registerTime"));
					positionType = new PositionType(APIUtils.getStringorNull(jObjectPosition
							.getJSONObject("positiotype"),"id"),
							APIUtils.getStringorNull(jObjectPosition.getJSONObject("positiotype")
									,"description"));

					positions.add(new Position(id_pos, device_pos, timestamp,
							registerTime, latitude, longitude, elevation,
							positionType, accuracy, vaccuracy, bearing,
							velocity, track_id));
				}
			}
			this.track = new Track(id, name, device, positions);

		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}

	}

	/**
	 * Gets the track.
	 *
	 * @return the track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * Sets the track.
	 *
	 * @param track the track to set
	 */
	public void setTrack(Track track) {
		this.track = track;
	}

}
