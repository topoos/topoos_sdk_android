package topoos.APIAccess.Operations;

/**
 * Get the information from last CheckIn that have been registered by a user
 * with a visible device.
 * 
 * @see APIOperation
 * @author MAJS
 * 
 */
public class CheckinGet_last extends APIOperation {

	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	private String usr = null; // (obligatorio) identificador del usuario

	public CheckinGet_last(String operationName, String method, String format,
			Integer version, String oauth_token, String usr) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.usr = usr;
	}

	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(usr);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/checkin/get_last." + this.Format
					+ "?oauth_token=" + this.oauth_token + "&usr=" + this.usr;

		}
		return params;
	}

}