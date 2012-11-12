package topoos.APIAccess.Operations;


/**
 * Obtiene información de un CheckIn a partir de su Identificador
 * @author MAJS
 *
 */
public class CheckinGet extends APIOperation{

	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String	checkin=null; // (obligatorio) identificador del CheckIn que se desea recuperar

	public CheckinGet(String operationName, String method, String format,
			Integer version, String oauth_token, String checkin) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.checkin = checkin;
	}
	
	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(checkin);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/checkin/get."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token
					+"&poi="+ this.checkin
					;

		}
		return params;
	}

}