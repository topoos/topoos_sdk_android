package topoos.APIAccess.Operations;

import java.util.Date;


public class PositionsGet_between extends APIOperation{

	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Date	initdate=null; // (obligatorio) fecha de inicio, según el estándar ISO 8601
	private Date	enddate=null; // (obligatorio) fecha de fin, según el estándar ISO 8601
	private String	device=null; // (opcional) obtiene solo las posiciones del dispositivo indicado. Si no se especifica, se obtienen las posiciones del dispositivo por defecto. Es un parámetro obligatorio cuando la aplicación puede acceder a los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.

	public PositionsGet_between(String operationName, String method,
			String format, Integer version, String oauth_token,
			Date initdate, Date enddate, String device) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.initdate = initdate;
		this.enddate = enddate;
		this.device = device;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = true;
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(APIUtils.toStringDate(initdate));
		validate = validate && isValid(APIUtils.toStringDate(enddate));
		validate = validate && isValidorNull(device);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/positions/get_bettween." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+"&initdate="+APIUtils.toStringDate(initdate)
					+"&enddate="+APIUtils.toStringDate(enddate)
					+(device == null? "" : "&device="+device);
		}
		return params;
	}
	

}
