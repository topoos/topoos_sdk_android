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
 * The Class POICollectionResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class POICollectionResult extends APICallResult {

	/** The poicollection. */
	private POICollection poicollection = null;

	/**
	 * Instantiates a new pOI collection result.
	 */
	public POICollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI collection result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public POICollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI collection result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param poicollection the poicollection
	 */
	public POICollectionResult(String error, String result,
			POICollection poicollection) {
		super(error, result);
		this.poicollection = poicollection;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
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
				name = APIUtils.getStringorNull(jObject,"name");
				description = APIUtils.getStringorNull(jObject,"description");
				latitude = jObject.getDouble("latitude");
				longitude = jObject.getDouble("longitude");
				elevation = jObject.getDouble("elevation");
				accuracy = jObject.getDouble("accuracy");
				vaccuracy = jObject.getDouble("vaccuracy");
				address = APIUtils.getStringorNull(jObject,"address");
				crossStreet = APIUtils.getStringorNull(jObject,"cross_street");
				city = APIUtils.getStringorNull(jObject,"city");
				country = APIUtils.getStringorNull(jObject,"country");
				registertime = APIUtils.toDateString(jObject
						.getString("registertime"));
				lastUpdate = APIUtils.toDateString(jObject
						.getString("last_update"));
				postalCode = APIUtils.getStringorNull(jObject,"postal_code");
				phone = APIUtils.getStringorNull(jObject,"phone");
				twitter = APIUtils.getStringorNull(jObject,"twitter");
				categories = new ArrayList<POICategory>();
				JSONArray jArrayCategories = jObject.getJSONArray("categories");
				for (int j = 0; j < jArrayCategories.length(); j++) {
					JSONObject job = jArrayCategories.getJSONObject(j);
					categories.add(new POICategory(job.getInt("Id"),APIUtils.getStringorNull(job,"Description"), job
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
	 * Gets the poicollection.
	 *
	 * @return the poicollection
	 */
	public POICollection getPoicollection() {
		return poicollection;
	}

	/**
	 * Sets the poicollection.
	 *
	 * @param poicollection the poicollection to set
	 */
	public void setPoicollection(POICollection poicollection) {
		this.poicollection = poicollection;
	}

}
