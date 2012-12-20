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
 * The Class POICategoryCollectionResult.
 *
 * @see APICallResult
 * @author MAJS
 */
public class POICategoryCollectionResult extends APICallResult 
{
	
	/** The poi category collection. */
	private POICategoryCollection poiCategoryCollection = null;

	/**
	 * Instantiates a new pOI category collection result.
	 */
	public POICategoryCollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category collection result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public POICategoryCollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new pOI category collection result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param poiCategoryCollection the poi category collection
	 */
	public POICategoryCollectionResult(String error, String result,
			POICategoryCollection poiCategoryCollection) {
		super(error, result);
		this.poiCategoryCollection = poiCategoryCollection;
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
		POICategory poiCategory= null;
		JSONObject jObject=null;
		ArrayList<POICategory> arraylist=new ArrayList<POICategory>();
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(Result).nextValue();
			for(int i=0;i<jArray.length();i++){
				jObject = jArray.getJSONObject(i);
				// Extracting content
				id = jObject.getInt("Id");
				description = APIUtils.getStringorNull(jObject,"Description");
				isSystem = jObject.getBoolean("is_system_category");
				poiCategory=new POICategory(id,description,isSystem);
				arraylist.add(poiCategory);
			}
			this.poiCategoryCollection=new POICategoryCollection(arraylist);
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * Gets the poi category collection.
	 *
	 * @return the poiCategoryCollection
	 */
	public POICategoryCollection getPoiCategoryCollection() {
		return poiCategoryCollection;
	}

	/**
	 * Sets the poi category collection.
	 *
	 * @param poiCategoryCollection the poiCategoryCollection to set
	 */
	public void setPoiCategoryCollection(POICategoryCollection poiCategoryCollection) {
		this.poiCategoryCollection = poiCategoryCollection;
	}

}
