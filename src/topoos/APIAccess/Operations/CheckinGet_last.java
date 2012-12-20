package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * Get the information from last CheckIn that have been registered by a user
 * with a visible device.
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class CheckinGet_last extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The usr. */
										private String usr = null; // (obligatorio) identificador del usuario

	/**
	 * Instantiates a new checkin get_last.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param usr the usr
	 */
	public CheckinGet_last(String operationName, String method, String format,
			Integer version, String oauth_token, String usr) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.usr = usr;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(usr);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
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