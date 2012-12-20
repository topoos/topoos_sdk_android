package topoos.APIAccess.Operations;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * The Class CheckinAdd.
 *
 * @see APIOperation
 * @author topoos
 */
public class CheckinAdd extends APIOperation{

	/** The oauth_token. */
	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	
	/** The poi. */
	private Integer	poi=null; // (obligatorio) identificador del POI sobre el que se hace CheckIn
	
	/** The device. */
	private String	device=null; // (opcional) identificador del dispositivo con el que se hace CheckIn. Se trata de un parámetro obligatorio si la aplicación puede manejar los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.
	
	/** The timestamp. */
	private Date	timestamp=null; // (opcional) fecha de captura del CheckIn, hora local con offset de conversión UTC de captura de la posición.

	/**
	 * Instantiates a new checkin add.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param poi the poi
	 * @param device the device
	 * @param timestamp the timestamp
	 */
	public CheckinAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String device,
			Date timestamp) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.device = device;
		this.timestamp = timestamp;
	}
	
	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = true;
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(APIUtils.toStringDate(timestamp));
		validate = validate && isValid(oauth_token);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/checkin/add."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token
					+"&poi="+APIUtils.toStringInteger(poi)
					+(device == null? "" : "&device="+device)
					+(timestamp == null? "" : "&timestamp="+APIUtils.toStringDate(timestamp))
					;

		}
		return params;
	}

}