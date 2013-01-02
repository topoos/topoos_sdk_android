package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

// TODO: Auto-generated Javadoc

/**
 * The Class TrackResourceResult.
 * 
 * @see APICallResult
 * @author topoos
 */
public class TrackResourceResult extends APICallResult {

	/** The track resource. */
	private TrackResource trackResource = null;

	/**
	 * Instantiates a new track resource result.
	 */
	public TrackResourceResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new track resource result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 */
	public TrackResourceResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new track resource result.
	 * 
	 * @param error
	 *            the error
	 * @param result
	 *            the result
	 * @param trackResource
	 *            the track resource
	 */
	public TrackResourceResult(String error, String result,
			TrackResource trackResource) {
		super(error, result);
		this.trackResource = trackResource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		if (APIUtils.getcorrectJSONstring(Result) != null) {
			try {
				JSONObject jObject = (JSONObject) new JSONTokener(
						APIUtils.getcorrectJSONstring(Result)).nextValue();
				// Extracting content
				Integer id = null;
				String type = null;
				String format = null;
				id = jObject.getInt("id");
				type = APIUtils.getStringorNull(jObject, "type");
				format = APIUtils.getStringorNull(jObject, "format");
				this.trackResource = new TrackResource(id, type, format);

			} catch (Exception e) {
				if (Constants.DEBUG) {
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		} else {
			if (Constants.DEBUG) {
				Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
			}
		}
	}

	/**
	 * Gets the track resource.
	 * 
	 * @return the trackResource
	 */
	public TrackResource getTrackResource() {
		return trackResource;
	}

	/**
	 * Sets the track resource.
	 * 
	 * @param trackResource
	 *            the trackResource to set
	 */
	public void setTrackResource(TrackResource trackResource) {
		this.trackResource = trackResource;
	}

}
