package topoos.APIAccess.Operations;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class APIUtils {
	public static String toStringDate(Date date){
		String formatoFecha = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return date== null? null : URLEncoder.encode(sdf.format(date));
	}
	
	public static String toStringDouble(Double doub){
		return doub==null? null:URLEncoder.encode(Double.toString(doub).replace(',',
				'.'));
	}
	
	public static String toStringInteger(Integer inte){
		return inte==null? null:URLEncoder.encode(Integer.toString(inte));
	}
	
	public static String toStringUrlEncoded(String str){
		return str==null? null:URLEncoder.encode(str);
	}
	public static String toStringBoolean(Boolean bool){
		return bool==null? null:URLEncoder.encode(Boolean.toString(bool));
	}
}
