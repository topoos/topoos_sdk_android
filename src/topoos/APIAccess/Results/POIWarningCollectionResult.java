package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.APIAccess.Results.Objects.*;
import topoos.Exception.TopoosException;

public class POIWarningCollectionResult extends APICallResult {

	private ArrayList<POIDataWarning> POIDataWarnings = null;

	@Override
	public void setParameters() throws TopoosException {
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(this.Result)
					.nextValue();
			// Extracting content
			this.POIDataWarnings=new ArrayList<POIDataWarning>();
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject jPOI = jArray.getJSONObject(i).getJSONObject(
						"current");
				ArrayList<POICategory> categories = new ArrayList<POICategory>();
				JSONArray jArrayCategories = jPOI.getJSONArray("categories");
				for (int j = 0; j < jArrayCategories.length(); j++) {
					categories.add(new POICategory(jArrayCategories
							.getJSONObject(j).getInt("Id"), jArrayCategories
							.getJSONObject(j).getString("Description"),
							jArrayCategories.getJSONObject(j).getBoolean(
									"is_system_category")));
				}
				POIWarningCount warningcount = new POIWarningCount(jPOI
						.getJSONObject("warnings").getInt("closed"), jPOI
						.getJSONObject("warnings").getInt("duplicated"), jPOI
						.getJSONObject("warnings").getInt("wrongIndicator"),
						jPOI.getJSONObject("warnings").getInt("wrongInfo"));
				//POI
				POI poi = new POI(jPOI.getInt("id"), jPOI.getString("name"),
						jPOI.getString("description"),
						jPOI.getDouble("latitude"),
						jPOI.getDouble("longitude"),
						jPOI.getDouble("elevation"),
						jPOI.getDouble("accuracy"),
						jPOI.getDouble("vaccuracy"), APIUtils.toDateString(jPOI
								.getString("registertime")), categories,
						jPOI.getString("address"),
						jPOI.getString("crossStreet"), jPOI.getString("city"),
						jPOI.getString("country"),
						jPOI.getString("postalCode"), jPOI.getString("phone"),
						jPOI.getString("twitter"), APIUtils.toDateString(jPOI
								.getString("lastUpdate")), warningcount);
				JSONArray jArrayWarnings = jArray.getJSONObject(i)
						.getJSONArray("warnings");
				//ArrayList<POIWarning>
				ArrayList<POIWarning> arrayPOIWarnings=new ArrayList<POIWarning>();
				for (int j = 0; j < jArrayWarnings.length(); j++) {
					JSONObject jPOIwarning = jArrayWarnings.getJSONObject(j);
					POIWarningData poiWarningData = null;
					if (jPOIwarning.optJSONObject("data") != null) {
						JSONArray jPOIwarningCategories = jPOIwarning
								.getJSONObject("data").getJSONArray(
										"categories");
						ArrayList<POICategory> arrayCategories = new ArrayList<POICategory>();
						for (int z = 0; z < jPOIwarningCategories.length(); z++) {
							arrayCategories.add(new POICategory(
									jPOIwarningCategories.getJSONObject(z)
											.getInt("Id"),
									jPOIwarningCategories.getJSONObject(z)
											.getString("Description"),
									jPOIwarningCategories.getJSONObject(z)
											.getBoolean("is_system_category")));
						}
						poiWarningData = new POIWarningData(jPOIwarning
								.optJSONObject("data").getInt("id"),
								jPOIwarning.optJSONObject("data").getDouble(
										"latitude"), jPOIwarning.optJSONObject(
										"data").getDouble("longitude"),
								jPOIwarning.optJSONObject("data").getDouble(
										"accuracy"), jPOIwarning.optJSONObject(
										"data").getDouble("vaccuracy"),
								jPOIwarning.optJSONObject("data").getDouble(
										"elevation"), jPOIwarning
										.optJSONObject("data")
										.getString("name"), jPOIwarning
										.optJSONObject("data").getString(
												"address"), jPOIwarning
										.optJSONObject("data").getString(
												"cross_street"), jPOIwarning
										.optJSONObject("data")
										.getString("city"), jPOIwarning
										.optJSONObject("data").getString(
												"country"), jPOIwarning
										.optJSONObject("data").getString(
												"postal_code"), jPOIwarning
										.optJSONObject("data").getString(
												"phone"), jPOIwarning
										.optJSONObject("data").getString(
												"twitter"), jPOIwarning
										.optJSONObject("data").getString(
												"description"), arrayCategories);
					}
					
					POIWarning poiwarning = new POIWarning(
							jPOIwarning.getInt("id"),
							jPOIwarning.getInt("poi_id"),
							jPOIwarning.getString("type"),
							jPOIwarning.getString("user_id"),
							APIUtils.toDateString(jPOIwarning
									.getString("timestamp")), poiWarningData);
					arrayPOIWarnings.add(poiwarning);
				}
				POIDataWarnings.add(new POIDataWarning(poi,arrayPOIWarnings));
			}

		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * @return the pOIDataWarnings
	 */
	public ArrayList<POIDataWarning> getPOIDataWarnings() {
		return POIDataWarnings;
	}

	/**
	 * @param pOIDataWarnings the pOIDataWarnings to set
	 */
	public void setPOIDataWarnings(ArrayList<POIDataWarning> pOIDataWarnings) {
		POIDataWarnings = pOIDataWarnings;
	}

	
}

