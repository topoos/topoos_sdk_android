package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;

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
public class POICollectionResult extends APICallResult {

	private POICollection poicollection = null;

	/**
	 * 
	 */
	public POICollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public POICollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param poicollection
	 */
	public POICollectionResult(String error, String result,
			POICollection poicollection) {
		super(error, result);
		this.poicollection = poicollection;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
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
			
			JSONArray jArray = (JSONArray) new JSONTokener(Result).nextValue();
			ArrayList<POI> poicollec=new ArrayList<POI>();
			for (int i = 0; i < jArray.length(); i++) {
				// Extracting content
				JSONObject jObject = jArray.getJSONObject(i);
				POI poi = null;
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
				lastUpdate = APIUtils.toDateString(jObject
						.getString("last_update"));
				postalCode = jObject.getString("postal_code");
				phone = jObject.getString("phone");
				twitter = jObject.getString("twitter");
				categories = new ArrayList<POICategory>();
				JSONArray jArrayCategories = jObject.getJSONArray("categories");
				for (int j = 0; j < jArrayCategories.length(); j++) {
					JSONObject job = jArrayCategories.getJSONObject(j);
					categories.add(new POICategory(job.getInt("Id"), job
							.getString("Description"), job
							.getBoolean("is_system_category")));
				}
				JSONObject jObj = jObject.getJSONObject("warnings");
				warningcount = new POIWarningCount(jObj.getInt("closed"),
						jObj.getInt("duplicated"),
						jObj.getInt("wrong_indicator"),
						jObj.getInt("wrong_info"));
				poi = new POI(id, name, description, latitude, longitude,
						elevation, accuracy, vaccuracy, registertime,
						categories, address, crossStreet, city, country,
						postalCode, phone, twitter, lastUpdate, warningcount);
				poicollec.add(poi);
			}
			this.poicollection=new POICollection(poicollec);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * @return the poicollection
	 */
	public POICollection getPoicollection() {
		return poicollection;
	}

	/**
	 * @param poicollection
	 *            the poicollection to set
	 */
	public void setPoicollection(POICollection poicollection) {
		this.poicollection = poicollection;
	}

}
