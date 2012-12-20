package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;
// TODO: Auto-generated Javadoc

/**
 * The Class POIWarningCollectionResult.
 *
 * @see APICallResult
 * @author MAJS
 */
public class POIWarningCollectionResult extends APICallResult {

	/** The POI data warnings. */
	private ArrayList<POIDataWarning> POIDataWarnings = null;

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
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
				POI poi = new POI(jPOI.getInt("id"), APIUtils.getStringorNull(jPOI,"name"),
						APIUtils.getStringorNull(jPOI,"description"),
						jPOI.getDouble("latitude"),
						jPOI.getDouble("longitude"),
						jPOI.getDouble("elevation"),
						jPOI.getDouble("accuracy"),
						jPOI.getDouble("vaccuracy"), APIUtils.toDateString(jPOI
								.getString("registertime")), categories,
						APIUtils.getStringorNull(jPOI,"address"),
						APIUtils.getStringorNull(jPOI,"crossStreet"), APIUtils.getStringorNull(jPOI,"city"),
						APIUtils.getStringorNull(jPOI,"country"),
						APIUtils.getStringorNull(jPOI,"postalCode"), APIUtils.getStringorNull(jPOI,"phone"),
						APIUtils.getStringorNull(jPOI,"twitter"), APIUtils.toDateString(jPOI
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
											.getInt("Id"),APIUtils.getStringorNull(
									jPOIwarningCategories.getJSONObject(z)
											,"Description"),
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
										"elevation"), APIUtils.getStringorNull( jPOIwarning
												.optJSONObject("data"),"name"), APIUtils.getStringorNull( jPOIwarning
												.optJSONObject("data"),
												"address"), APIUtils.getStringorNull( jPOIwarning
														.optJSONObject("data"),
												"cross_street"), APIUtils.getStringorNull( jPOIwarning
														.optJSONObject("data"),"city"), APIUtils.getStringorNull( jPOIwarning
												.optJSONObject("data"),
												"country"), APIUtils.getStringorNull( jPOIwarning
														.optJSONObject("data"),
												"postal_code"), APIUtils.getStringorNull( jPOIwarning
														.optJSONObject("data"),
												"phone"), APIUtils.getStringorNull( jPOIwarning
														.optJSONObject("data"),
												"twitter"),APIUtils.getStringorNull( jPOIwarning
										.optJSONObject("data"),
												"description"), arrayCategories);
					}
					
					POIWarning poiwarning = new POIWarning(
							jPOIwarning.getInt("id"),
							jPOIwarning.getInt("poi_id"),
							APIUtils.getStringorNull(jPOIwarning,"type"),
							APIUtils.getStringorNull(jPOIwarning,"user_id"),
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
	 * Gets the pOI data warnings.
	 *
	 * @return the pOIDataWarnings
	 */
	public ArrayList<POIDataWarning> getPOIDataWarnings() {
		return POIDataWarnings;
	}

	/**
	 * Sets the pOI data warnings.
	 *
	 * @param pOIDataWarnings the pOIDataWarnings to set
	 */
	public void setPOIDataWarnings(ArrayList<POIDataWarning> pOIDataWarnings) {
		POIDataWarnings = pOIDataWarnings;
	}

	
}

