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
 * The Class POIWarningResult.
 *
 * @see APICallResult
 * @author MAJS
 */
public class POIWarningResult extends APICallResult {

	/** The poi warning. */
	POIWarning poiWarning = null;

	/**
	 * Instantiates a new pOI warning result.
	 */
	public POIWarningResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI warning result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public POIWarningResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI warning result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param poiWarning the poi warning
	 */
	public POIWarningResult(String error, String result, POIWarning poiWarning) {
		super(error, result);
		this.poiWarning = poiWarning;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		Integer id = null;
		Integer poi_id = null;
		String type = null;
		String user_id = null;
		Date timestamp = null;
		POIWarningData data = null;

		Integer id_warningdata = null;
		Double latitude = null;
		Double longitude = null;
		Double accuracy = null;
		Double vaccuracy = null;
		Double elevation = null;
		String name = null;
		String address = null;
		String cross_street = null;
		String city = null;
		String country = null;
		String postal_code = null;
		String phone = null;
		String twitter = null;
		String description = null;
		ArrayList<POICategory> categories = null;

		try {
			JSONObject jObject = (JSONObject) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			id = jObject.getInt("id");
			poi_id = jObject.getInt("poi_id");
			type = APIUtils.getStringorNull(jObject,"type");
			user_id = APIUtils.getStringorNull(jObject,"user_id");
			timestamp = APIUtils.toDateString(APIUtils.getStringorNull(jObject,"timestamp"));
			JSONObject jObjectData = jObject.optJSONObject("data");
			if (jObjectData != null) {
				id_warningdata = jObjectData.getInt("id");
				latitude = jObjectData.optDouble("latitude");
				longitude = jObjectData.optDouble("longitude");
				elevation = jObjectData.optDouble("elevation");
				name = jObjectData.optString("name");
				accuracy = jObjectData.optDouble("accuracy");
				vaccuracy = jObjectData.optDouble("vaccuracy");
				address = jObjectData.optString("address");
				cross_street = jObjectData.optString("cross_street");
				city = jObjectData.optString("city");
				country = jObjectData.optString("country");
				postal_code = jObjectData.optString("postal_code");
				phone = jObjectData.optString("phone");
				twitter = jObjectData.optString("twitter");
				description = jObjectData.optString("description");
				categories = new ArrayList<POICategory>();
				JSONArray jArray = jObjectData.optJSONArray("categories");
				if (jArray != null) {
					for (int i = 0; i < jArray.length(); i++) {
						JSONObject job = jArray.getJSONObject(i);
						categories.add(new POICategory(job.getInt("Id"), APIUtils.getStringorNull(job
								,"Description"), job
								.getBoolean("is_system_category")));
					}
				}
				data = new POIWarningData(id_warningdata, latitude, longitude,
						accuracy, vaccuracy, elevation, name, address,
						cross_street, city, country, postal_code, phone,
						twitter, description, categories);
			}
			this.poiWarning = new POIWarning(id, poi_id, type, user_id,
					timestamp, data);
		} catch (Exception e) {
			if (Constants.DEBUG) {
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * Gets the poi warning.
	 *
	 * @return the poiWarning
	 */
	public POIWarning getPoiWarning() {
		return poiWarning;
	}

	/**
	 * Sets the poi warning.
	 *
	 * @param poiWarning the poiWarning to set
	 */
	public void setPoiWarning(POIWarning poiWarning) {
		this.poiWarning = poiWarning;
	}

}
