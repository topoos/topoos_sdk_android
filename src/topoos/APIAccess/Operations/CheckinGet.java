package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * Get information of a CheckIn by its id.
 *
 * @see APIOperation
 * @author topoos
 */
public class CheckinGet extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The checkin. */
										private Integer checkin = null; // (obligatorio) identificador del CheckIn
									// que se desea recuperar

	/**
									 * Instantiates a new checkin get.
									 *
									 * @param operationName the operation name
									 * @param method the method
									 * @param format the format
									 * @param version the version
									 * @param oauth_token the oauth_token
									 * @param checkin the checkin
									 */
									public CheckinGet(String operationName, String method, String format,
			Integer version, String oauth_token, Integer checkin) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.checkin = checkin;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(APIUtils.toStringInteger(checkin));
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
			params = "/" + this.Version + "/checkin/get." + this.Format
					+ "?oauth_token=" + this.oauth_token + "&checkin="
					+ APIUtils.toStringInteger(checkin);

		}
		return params;
	}

}