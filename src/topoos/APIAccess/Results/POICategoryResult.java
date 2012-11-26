package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

public class POICategoryResult extends APICallResult {

	private POICategory poiCategory = null;

	/**
	 * 
	 */
	public POICategoryResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public POICategoryResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param poiCategory
	 */
	public POICategoryResult(String error, String result,
			POICategory poiCategory) {
		super(error, result);
		this.poiCategory = poiCategory;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		Integer id = null;
		String description = null;
		Boolean isSystem = null;

		try {
			JSONObject jObject = (JSONObject) new JSONTokener(Result).nextValue();
			// Extracting content
			id = jObject.getInt("Id");
			
			description = jObject.getString("Description");
			isSystem = jObject.getBoolean("is_system_category");
			this.poiCategory=new POICategory(id,description,isSystem);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
		
		
	}

	/**
	 * @return the poiCategory
	 */
	public POICategory getPoiCategory() {
		return poiCategory;
	}

	/**
	 * @param poiCategory
	 *            the poiCategory to set
	 */
	public void setPoiCategory(POICategory poiCategory) {
		this.poiCategory = poiCategory;
	}

}