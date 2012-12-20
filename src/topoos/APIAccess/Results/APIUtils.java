package topoos.APIAccess.Results;

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
	 * @return the stringor null
	 * @throws JSONException the jSON exception
	 */
	public static String getStringorNull(JSONObject jsonob, String key) throws JSONException{
		String value=null;
		if(!jsonob.isNull(key)){
			value=jsonob.getString(key);
		}
		return value;
	}
	
}
