package topoos.APIAccess.Operations;

/**
 * Get all CheckIns that have been realized in a POI
 * 
 * @see APIOperation
 * @author MAJS
 * 
 */
public class CheckinGet_where extends APIOperation {

	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	private Integer poi = null; // (obligatorio)identificador del POI

	public CheckinGet_where(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
	}

	@Override
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValid(oauth_token);
		return validate;
	}

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