package topoos.APIAccess.Operations;

/**
 * Set the group to which the user belongs.
 * 
 * @see APIOperation
 * @author MAJS
 * 
 */
public class UsersUSRAdd_group extends APIOperation {

	private String oauth_token;
	private String USR;
	private Integer ugroup;

	/**
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param uSR
	 * @param ugroup
	 */
	public UsersUSRAdd_group(String operationName, String method,
			String format, Integer version, String oauth_token, String uSR,
			Integer ugroup) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		USR = uSR;
		this.ugroup = ugroup;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(USR);
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(String.valueOf(ugroup));
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/users/" + this.USR + "/add_group."
					+ this.Format + "?ugroup=" + ugroup + "&oauth_token="
					+ this.oauth_token;

		}
		return params;
	}

}
