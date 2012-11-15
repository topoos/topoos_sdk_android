package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.APIAccess.Results.Objects.*;

public class POIWarningResult extends APICallResult {

	POIWarning poiWarning = null;

	/**
	 * 
	 */
	public POIWarningResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public POIWarningResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param poiWarning
	 */
	public POIWarningResult(String error, String result, POIWarning poiWarning) {
		super(error, result);
		this.poiWarning = poiWarning;
	}

	@Override
	public void setParameters() {
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
			type = jObject.getString("type");
			user_id = jObject.getString("user_id");
			timestamp = APIUtils.toDateString(jObject.getString("timestamp"));
			JSONObject jObjectData = jObject.optJSONObject("data");
			if (jObjectData != null) {
				id_warningdata = jObjectData.getInt("id");
				latitude = jObjectData.getDouble("latitude");
				longitude = jObjectData.getDouble("longitude");
				elevation = jObjectData.getDouble("elevation");
				name = jObjectData.getString("name");
				accuracy = jObjectData.getDouble("accuracy");
				vaccuracy = jObjectData.getDouble("vaccuracy");
				address = jObjectData.getString("address");
				cross_street = jObjectData.getString("cross_street");
				city = jObjectData.getString("city");
				country = jObjectData.getString("country");
				postal_code = jObjectData.getString("postal_code");
				phone = jObjectData.getString("phone");
				twitter = jObjectData.getString("twitter");
				description = jObjectData.getString("description");
				categories = new ArrayList<POICategory>();
				JSONArray jArray = jObjectData.getJSONArray("categories");
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject job = jArray.getJSONObject(i);
					categories.add(new POICategory(job.getInt("Id"), job
							.getString("Description"), job
							.getBoolean("is_system_category")));
				}
				data = new POIWarningData(id_warningdata, latitude, longitude,
						accuracy, vaccuracy, elevation, name, address,
						cross_street, city, country, postal_code, phone,
						twitter, description, categories);
			}
			this.poiWarning = new POIWarning(id, poi_id, type, user_id,
					timestamp, data);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @return the poiWarning
	 */
	public POIWarning getPoiWarning() {
		return poiWarning;
	}

	/**
	 * @param poiWarning
	 *            the poiWarning to set
	 */
	public void setPoiWarning(POIWarning poiWarning) {
		this.poiWarning = poiWarning;
	}

}
