package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import topoos.APIAccess.Results.Objects.*;

public class POIResult extends APICallResult {

	private POI poi = null;

	/**
	 * @param error
	 * @param result
	 * @param poi
	 */
	public POIResult(String error, String result, POI poi) {
		super(error, result);
		this.poi = poi;
	}

	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		Integer id = null;
		String name = null;
		String description = null;
		Double latitude = null;
		Double longitude = null;
		Double elevation = null;
		Double accuracy = null;
		Double vaccuracy = null;
		Date registertime = null;
		ArrayList<POICategory> categories = null;
		String address = null;
		String crossStreet = null;
		String city = null;
		String country = null;
		String postalCode = null;
		String phone = null;
		String twitter = null;
		Date lastUpdate = null;
		POIWarningCount warningcount = null;

		try {
			JSONObject jObject = (JSONObject) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			id = jObject.getInt("id");
			name = jObject.getString("name");
			description = jObject.getString("description");
			latitude = jObject.getDouble("latitude");
			longitude = jObject.getDouble("longitude");
			elevation = jObject.getDouble("elevation");
			accuracy = jObject.getDouble("accuracy");
			vaccuracy = jObject.getDouble("vaccuracy");
			address = jObject.getString("address");
			crossStreet = jObject.getString("cross_street");
			city = jObject.getString("city");
			country = jObject.getString("country");
			registertime = APIUtils.toDateString(jObject
					.getString("registertime"));
			lastUpdate = APIUtils
					.toDateString(jObject.getString("last_update"));
			postalCode = jObject.getString("postal_code");
			phone = jObject.getString("phone");
			twitter = jObject.getString("twitter");
			categories = new ArrayList<POICategory>();
			JSONArray jArray = jObject.getJSONArray("categories");
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject job = jArray.getJSONObject(i);
				categories.add(new POICategory(job.getInt("Id"), job
						.getString("Description"), job
						.getBoolean("is_system_category")));
			}
			JSONObject jObj = jObject.getJSONObject("warnings");
			warningcount = new POIWarningCount(jObj.getInt("closed"),
					jObj.getInt("duplicated"), jObj.getInt("wrong_indicator"),
					jObj.getInt("wrong_info"));
			this.poi=new POI(id, name,
					description, latitude, longitude,
					elevation, accuracy, vaccuracy,
					registertime, categories,
					address, crossStreet, city, country,
					postalCode, phone, twitter, lastUpdate,
					warningcount);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @return the poi
	 */
	public POI getPoi() {
		return poi;
	}

	/**
	 * @param poi the poi to set
	 */
	public void setPoi(POI poi) {
		this.poi = poi;
	}

}