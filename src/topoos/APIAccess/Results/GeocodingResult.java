package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.APIAccess.Results.Objects.*;
/**
 * 
 * @author MAJS
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
	public void setParameters() {
		// TODO Auto-generated method stub
		try {
			JSONArray jArray = (JSONArray) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			this.geocoding=new ArrayList<GeocodingData>();
			for(int i=0;i<jArray.length();i++){
				JSONObject jObject=jArray.getJSONObject(i);
				JSONObject jObjectAddress=jObject.getJSONObject("address");
				JSONObject jObjectLocation=jObject.getJSONObject("location");
				JSONObject jObjectBounds=jObject.getJSONObject("bounds");
				JSONObject jObjectSouthwest=jObjectBounds.getJSONObject("southwest");
				JSONObject jObjectNortheast=jObjectBounds.getJSONObject("northeast");
				this.geocoding.add(
						new GeocodingData(new Address(
								jObjectAddress.getString("address"),
								jObjectAddress.getString("cross_street"),
								jObjectAddress.getString("state"),
								jObjectAddress.getString("administrative_area"),
								jObjectAddress.getString("country"),
								jObjectAddress.getString("postal_code")),
						new Location(jObjectLocation.getDouble("latitude"),
								jObjectLocation.getDouble("longitude")),
						new ViewportType(new Location(jObjectSouthwest.getDouble("latitude"),
								jObjectSouthwest.getDouble("longitude")),new Location(jObjectNortheast.getDouble("latitude"),
										jObjectNortheast.getDouble("longitude")))));
				
			}

		} catch (Exception e) {

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
