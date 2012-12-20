package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;
// TODO: Auto-generated Javadoc

/**
 * The Class POICategoryResult.
 *
 * @see APICallResult
 * @author MAJS
 */
public class POICategoryResult extends APICallResult {

	/** The poi category. */
	private POICategory poiCategory = null;

	/**
	 * Instantiates a new pOI category result.
	 */
	public POICategoryResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public POICategoryResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param poiCategory the poi category
	 */
	public POICategoryResult(String error, String result,
			POICategory poiCategory) {
		super(error, result);
		this.poiCategory = poiCategory;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
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
			
			description = APIUtils.getStringorNull(jObject,"Description");
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
	 * Gets the poi category.
	 *
	 * @return the poiCategory
	 */
	public POICategory getPoiCategory() {
		return poiCategory;
	}

	/**
	 * Sets the poi category.
	 *
	 * @param poiCategory the poiCategory to set
	 */
	public void setPoiCategory(POICategory poiCategory) {
		this.poiCategory = poiCategory;
	}

}