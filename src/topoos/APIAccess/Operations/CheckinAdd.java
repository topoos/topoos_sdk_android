package topoos.APIAccess.Operations;

import java.util.Date;
/**
 * @see APIOperation
 * @author MAJS
 *
 */
public class CheckinAdd extends APIOperation{

	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Integer	poi=null; // (obligatorio) identificador del POI sobre el que se hace CheckIn
	private String	device=null; // (opcional) identificador del dispositivo con el que se hace CheckIn. Se trata de un parámetro obligatorio si la aplicación puede manejar los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.
	private Date	timestamp=null; // (opcional) fecha de captura del CheckIn, hora local con offset de conversión UTC de captura de la posición.

	public CheckinAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String device,
			Date timestamp) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.device = device;
		this.timestamp = timestamp;
	}
	
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