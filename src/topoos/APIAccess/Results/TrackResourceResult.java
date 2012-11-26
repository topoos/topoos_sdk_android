package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

public class TrackResourceResult extends APICallResult {

	private TrackResource trackResource = null;

	/**
	 * 
	 */
	public TrackResourceResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public TrackResourceResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param trackResource
	 */
	public TrackResourceResult(String error, String result,
			TrackResource trackResource) {
		super(error, result);
		this.trackResource = trackResource;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		try {
			JSONObject jObject = (JSONObject) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			Integer id = null;
			String type = null;
			String format = null;
			id = jObject.getInt("id");
			type = jObject.getString("type");
			format = jObject.getString("format");
			this.trackResource=new TrackResource(id,type,format);

		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * @return the trackResource
	 */
	public TrackResource getTrackResource() {
		return trackResource;
	}

	/**
	 * @param trackResource
	 *            the trackResource to set
	 */
	public void setTrackResource(TrackResource trackResource) {
		this.trackResource = trackResource;
	}

}
