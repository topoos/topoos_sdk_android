package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * Get all CheckIns that have been realized in a POI.
 *
 * @see APIOperation
 * @author MAJS
 */
public class CheckinGet_where extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The poi. */
										private Integer poi = null; // (obligatorio)identificador del POI

	/**
	 * Instantiates a new checkin get_where.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param poi the poi
	 */
	public CheckinGet_where(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(APIUtils.toStringInteger(poi));
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
			params = "/" + this.Version + "/checkin/get_where." + this.Format
					+ "?oauth_token=" + this.oauth_token + "&poi="
					+ APIUtils.toStringInteger(this.poi);

		}
		return params;
	}

}