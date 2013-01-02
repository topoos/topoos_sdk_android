package topoos.APIAccess.Results;

import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.json.JSONException;
import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class APIUtils.
 */
class APIUtils {
	
	/**
	 * To date string.
	 *
	 * @param date the date
	 * @return the date
	 */
	@SuppressLint("SimpleDateFormat")
	public static Date toDateString(String date){
		String formatoFecha = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			return date== null? null : sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets the stringor null.
	 *
	 * @param jsonob the jsonob
	 * @param key the key
	 * @return the string or null
	 * @throws JSONException the jSON exception
	 */
	public static String getStringorNull(JSONObject jsonob, String key) throws JSONException{
		String value=null;
		if(!jsonob.isNull(key)){
			value=jsonob.getString(key);
		}
		return value;
	}
	
	/**
	 * Gets the Integer or null.
	 *
	 * @param jsonob the jsonob
	 * @param key the key
	 * @return the Integer or null
	 * @throws JSONException the jSON exception
	 */
	public static Integer getIntegerorNull(JSONObject jsonob, String key) throws JSONException{
		Integer value=null;
		if(!jsonob.isNull(key)){
			value=jsonob.getInt(key);
		}
		return value;
	}
	
	/**
	 * Gets the Double or null.
	 *
	 * @param jsonob the jsonob
	 * @param key the key
	 * @return the Double or null
	 * @throws JSONException the jSON exception
	 */
	public static Double getDoubleorNull(JSONObject jsonob, String key) throws JSONException{
		Double value=null;
		if(!jsonob.isNull(key)){
			value=jsonob.getDouble(key);
		}
		return value;
	}
	
	
	/**
	 * Gets the correct jSON.
	 *
	 * @param jsonob the jsonob
	 * @param key the key
	 * @return the stringor null
	 * @throws JSONException the jSON exception
	 */
	public static String getcorrectJSONstring(String json){
		return json==null||json.equals("")?null:json;
	}
	
	/**
	 * Gets the correct jSON Array.
	 *
	 * @param jsonob the jsonob
	 * @param key the key
	 * @return the stringor null
	 * @throws JSONException the jSON exception
	 */
	public static String getcorrectJSONARRAYstring(String json){
		return json==null||json.equals("")?null:json;
	}
	
}
