package topoos.APIAccess.Operations;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class PositionsGet_between.
 *
 * @see APIOperation
 * @author topoos
 */
public class PositionsGet_between extends APIOperation{

	/** The oauth_token. */
	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	
	/** The initdate. */
	private Date	initdate=null; // (obligatorio) fecha de inicio, según el estándar ISO 8601
	
	/** The enddate. */
	private Date	enddate=null; // (obligatorio) fecha de fin, según el estándar ISO 8601
	
	/** The device. */
	private String	device=null; // (opcional) obtiene solo las posiciones del dispositivo indicado. Si no se especifica, se obtienen las posiciones del dispositivo por defecto. Es un parámetro obligatorio cuando la aplicación puede acceder a los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.

	/**
	 * Instantiates a new positions get_between.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param initdate the initdate
	 * @param enddate the enddate
	 * @param device the device
	 */
	public PositionsGet_between(String operationName, String method,
			String format, Integer version, String oauth_token,
			Date initdate, Date enddate, String device) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.initdate = initdate;
		this.enddate = enddate;
		this.device = device;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
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

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/positions/get_between." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+"&initdate="+APIUtils.toStringDate(initdate)
					+"&enddate="+APIUtils.toStringDate(enddate)
					+(device == null? "" : "&device="+device);
		}
		return params;
	}
	

}
