package topoos.APIAccess.Operations;

import java.util.Date;

/**
 * @see APIOperation
 * @author MAJS
 *
 */
public class PositionsAdd extends APIOperation{

	

	public static final int TRACK_END =	2; 
	public static final int POS =	3; 
	public static final int ALARM_INIT = 6;
	public static final int ALARM_END =	7; 
	public static final int GPS_OK = 8; 
	public static final int GPS_NO = 9; 
	
	private String oauth_token=null; // (obligatorio)access_token de Acceso a recursos
	private String	device=null; // (opcional) dispositivo que capturó la posición. Se trata de un parámetro obligatorio cuando la aplicación puede manejar los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.
	private Double	lat=null; // (obligatorio) latitud en grados decimales de la nueva posición
	private Double	lng=null; // (obligatorio) longitud en grados decimales de la nueva posición
	private Integer	accuracy=null; // (opcional) precisión de la posición (latitud, longitud)
	private Integer	vaccuracy=null; // (opcional) precisión de la elevación
	private Integer	elevation=null; // (opcional) elevación respecto al nivel del mar
	private Date	timestamp=null; // (opcional) hora local con offset de conversión UTC de captura de la posición, según el estándar ISO 8601.
	 //(AAAA-MM-DDThh:mm:sszzzzzz) en UTC
	 //ejemplo: 1997-07-16T10:30:15.342+03:00
	private Integer	velocity=null; // (opcional) velocidad de movimiento en el instante en que se capturó la posición, en metros por segundo
	private Integer	postype=null; //(opcional) tipo de posición a registrar
	private Integer	bearing=null; // (opcional) rumbo de movimiento (valor entre 0 y 360)
	private Integer	track=null; // (opcional) identificador del Track al que pertenece la posición (excepto cuando es TRACK_INIT)

	/**
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param device
	 * @param lat
	 * @param lng
	 * @param accuracy
	 * @param vaccuracy
	 * @param elevation
	 * @param timestamp
	 * @param velocity
	 * @param postype
	 * @param bearing
	 * @param track
	 */
	public PositionsAdd(String operationName, String method, String format,
			Integer version, String oauth_token, String device, Double lat,
			Double lng, Integer accuracy, Integer vaccuracy, Integer elevation,
			Date timestamp, Integer velocity, Integer postype, Integer bearing,
			Integer track) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.device = device;
		this.lat = lat;
		this.lng = lng;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.timestamp = timestamp;
		this.velocity = velocity;
		this.postype = postype;
		this.bearing = bearing;
		this.track = track;
	}

	@Override
	public boolean ValidateParams() {

		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(APIUtils.toStringInteger(accuracy));
		validate = validate && isValidorNull(APIUtils.toStringInteger(vaccuracy));
		validate = validate && isValidorNull(APIUtils.toStringInteger(elevation));
		validate = validate && isValidorNull(APIUtils.toStringDate(timestamp));
		validate = validate && isValidorNull(APIUtils.toStringInteger(velocity));
		validate = validate && isValidorNull(APIUtils.toStringInteger(postype));
		validate = validate && isValidorNull(APIUtils.toStringInteger(bearing));
		validate = validate && isValidorNull(APIUtils.toStringInteger(track));
		return validate;
	}

	@Override
	public String ConcatParams() {

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/positions/add." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&lat="+APIUtils.toStringDouble(lat)
					+ "&lng="+APIUtils.toStringDouble(lng)
					+(device == null? "" : "&device="+device)
					+(accuracy == null? "" : "&accuracy="+APIUtils.toStringInteger(accuracy))
					+(vaccuracy == null? "" : "&vaccuracy="+APIUtils.toStringInteger(vaccuracy))
					+(elevation == null? "" : "&elevation="+APIUtils.toStringInteger(elevation))
					+(timestamp == null? "" : "&timestamp="+APIUtils.toStringDate(timestamp))
					+(velocity == null? "" : "&velocity="+APIUtils.toStringInteger(velocity))
					+(postype == null? "" : "&postype="+APIUtils.toStringInteger(postype))
					+(bearing == null? "" : "&bearing="+APIUtils.toStringInteger(bearing))
					+(track == null? "" : "&track="+APIUtils.toStringInteger(track))
					;
		}
		return params;
	}
	

		
}
