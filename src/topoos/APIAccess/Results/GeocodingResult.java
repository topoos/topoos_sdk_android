package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;
/**
 * @see APICallResult
 * @author topoos
 *
 */
public class GeocodingResult extends APICallResult{

	ArrayList<GeocodingData> geocoding=null;
	
	
	
	/**
	 * 
	 */
	public GeocodingResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param error
	 * @param result
	 */
	public GeocodingResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param error
	 * @param result
	 * @param geocoding
	 */
	public GeocodingResult(String error, String result,
			ArrayList<GeocodingData> geocoding) {
		super(error, result);
		this.geocoding = geocoding;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			this.geocoding=new ArrayList<GeocodingData>();
			for(int i=0;i<jArray.length();i++){
				JSONObject jObject=jArray.getJSONObject(i);
				JSONObject jObjectAddress=jObject.optJSONObject("address");
				JSONObject jObjectLocation=jObject.optJSONObject("location");
				JSONObject jObjectBounds=jObject.optJSONObject("bounds");
				JSONObject jObjectSouthwest=null;
				JSONObject jObjectNortheast=null;
				if(jObjectBounds!=null){
					jObjectSouthwest=jObjectBounds.optJSONObject("southwest");
					jObjectNortheast=jObjectBounds.optJSONObject("northeast");
				}
				if(jObjectAddress!=null||jObjectLocation!=null|| jObjectSouthwest!=null||jObjectNortheast!=null){
					this.geocoding.add(
							new GeocodingData(jObjectAddress!=null?new Address(
									APIUtils.getStringorNull(jObjectAddress,"address"),
									APIUtils.getStringorNull(jObjectAddress,"cross_street"),
									APIUtils.getStringorNull(jObjectAddress,"state"),
									APIUtils.getStringorNull(jObjectAddress,"administrative_area"),
									APIUtils.getStringorNull(jObjectAddress,"country"),
									APIUtils.getStringorNull(jObjectAddress,"postal_code")):null, jObjectLocation!=null?
							new Location(jObjectLocation.optDouble("latitude"),
									jObjectLocation.optDouble("longitude")):null, jObjectBounds==null? null:(
											jObjectNortheast!=null&&jObjectSouthwest!=null?new ViewportType(new Location(jObjectSouthwest.optDouble("latitude"),
									jObjectSouthwest.optDouble("longitude")),new Location(jObjectNortheast.optDouble("latitude"),
											jObjectNortheast.optDouble("longitude"))):null)));
				}
				
			}

		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}



	/**
	 * @return the geocoding
	 */
	public ArrayList<GeocodingData> getGeocoding() {
		return geocoding;
	}



	/**
	 * @param geocoding the geocoding to set
	 */
	public void setGeocoding(ArrayList<GeocodingData> geocoding) {
		this.geocoding = geocoding;
	}

	
	
	
}
