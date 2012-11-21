package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.APIAccess.Results.Objects.*;
import topoos.Exception.TopoosException;

public class POICategoryCollectionResult extends APICallResult 
{
	private POICategoryCollection poiCategoryCollection = null;

	/**
	 * 
	 */
	public POICategoryCollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public POICategoryCollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param poiCategoryCollection
	 */
	public POICategoryCollectionResult(String error, String result,
			POICategoryCollection poiCategoryCollection) {
		super(error, result);
		this.poiCategoryCollection = poiCategoryCollection;
	}

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
				description = jObject.getString("Description");
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
	 * @return the poiCategoryCollection
	 */
	public POICategoryCollection getPoiCategoryCollection() {
		return poiCategoryCollection;
	}

	/**
	 * @param poiCategoryCollection the poiCategoryCollection to set
	 */
	public void setPoiCategoryCollection(POICategoryCollection poiCategoryCollection) {
		this.poiCategoryCollection = poiCategoryCollection;
	}

}
