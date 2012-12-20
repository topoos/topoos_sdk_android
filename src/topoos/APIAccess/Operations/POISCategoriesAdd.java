package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * 
 * Create a new category of POI.
 * @see APIOperation
 * @author topoos
 * 
 */
public class POISCategoriesAdd extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The desc. */
										private String desc = null; // : (obligatorio) descripción de la categoría

	/**
	 * Instantiates a new pOIS categories add.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param desc the desc
	 */
	public POISCategoriesAdd(String operationName, String method,
			String format, Integer version, String oauth_token, String desc) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.desc = desc;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringUrlEncoded(desc));
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
			params = "/" + this.Version + "/pois/categories/add." + this.Format
					+ "?oauth_token=" + this.oauth_token + "&desc="
					+ APIUtils.toStringUrlEncoded(desc);
		}
		return params;
	}
}