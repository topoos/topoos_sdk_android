package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.APIAccess.Results.POI.POIWarningCount;

public class POIWarningCollection extends APICallResult{

	
	private ArrayList<POIDataWarning> POIDataWarnings=null;
	


	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(this.Result)
					.nextValue();
			// Extracting content
			for(int i=0;i<jArray.length();i++){
				JSONObject jPOI=jArray.getJSONObject(i).getJSONObject("current");
				POI poi=new POI();
				JSONArray jArray2=jArray.getJSONObject(i).getJSONArray("warnings");
				for(int j=0;j<jArray2.length();i++){
					JSONObject jPOIwarning=
					POIWarning poiwarning=new POIWarning();
				}
			}
			this.id = jObject.getString("id");
			this.name = jObject.getString("name");
			this.description = jObject.getString("description");
			this.latitude = jObject.getDouble("latitude");
			this.longitude = jObject.getDouble("longitude");
			this.elevation = jObject.getDouble("elevation");
			this.accuracy = jObject.getDouble("accuracy");
			this.vaccuracy = jObject.getDouble("vaccuracy");
			this.address = jObject.getString("address");
			this.crossStreet = jObject.getString("cross_street");
			this.city = jObject.getString("city");
			this.country = jObject.getString("country");
			this.registertime = APIUtils.toDateString(jObject
					.getString("registertime"));
			this.lastUpdate = APIUtils.toDateString(jObject
					.getString("last_update"));
			this.postalCode = jObject.getString("postal_code");
			this.phone = jObject.getString("phone");
			this.twitter = jObject.getString("twitter");
			this.categories=new ArrayList<POICategory>();
			JSONArray jArray=jObject.getJSONArray("categories");
			for(int i=0;i<jArray.length();i++){
				JSONObject job=jArray.getJSONObject(i);
				categories.add(new POICategory(job.getString("Id"),job.getString("Description"),job.getBoolean("is_system_category")));
			}
			JSONObject jObj=jObject.getJSONObject("warnings");
			this.warningcount=new POIWarningCount(jObj.getInt("closed"), jObj.getInt("duplicated"),
					jObj.getInt("wrong_indicator"), jObj.getInt("wrong_info"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



	public class POIDataWarning{
		POI poi=null;
		ArrayList<POIWarning> POIWarnings=null;
		/**
		 * @param poi
		 * @param pOIWarnings
		 */
		public POIDataWarning(POI poi, ArrayList<POIWarning> pOIWarnings) {
			super();
			this.poi = poi;
			POIWarnings = pOIWarnings;
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
		/**
		 * @return the pOIWarnings
		 */
		public ArrayList<POIWarning> getPOIWarnings() {
			return POIWarnings;
		}
		/**
		 * @param pOIWarnings the pOIWarnings to set
		 */
		public void setPOIWarnings(ArrayList<POIWarning> pOIWarnings) {
			POIWarnings = pOIWarnings;
		}
		
		
	}
	
	

}
