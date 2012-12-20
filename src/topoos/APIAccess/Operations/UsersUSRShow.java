package topoos.APIAccess.Operations;

/**
 * Get the information of a user. You can check the oauth_token.
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class UsersUSRShow extends APIOperation {

	private String OAuthToken = null;
	private String USR = null;

	public UsersUSRShow(String operationName, String method, String format,
			Integer version, String oAuth_token, String uSR) {
		super(operationName, method, format, version);
		USR = uSR;
		OAuthToken = oAuth_token;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(USR);
		validate = validate && isValid(OAuthToken);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/users/" + this.USR + "/show."
					+ this.Format + "?oauth_token=" + this.OAuthToken;

		}
		return params;
	}

}
