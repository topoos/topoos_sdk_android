package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * Class that implements the categories of the POIS.
 * 
 * @see APIOperation
 * @author MAJS
 * 
 */
public class POISCategories extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The include_system_categories. */
										private Boolean include_system_categories = null; // (opcional)

	// true =null; // (default) la respuesta incluye las categorías del sistema
	// predefinidas por el API
	// false =null; // la respuesta solo incluye las categorías del cliente

	/**
	 * Instantiates a new pOIS categories.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param include_system_categories the include_system_categories
	 */
	public POISCategories(String operationName, String method, String format,
			Integer version, String oauth_token,
			Boolean include_system_categories) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.include_system_categories = include_system_categories;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate
				&& isValidorNull(APIUtils
						.toStringBoolean(include_system_categories));
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
			params = "/"
					+ this.Version
					+ "/pois/categories."
					+ this.Format
					+ "?oauth_token="
					+ this.oauth_token
					+ (include_system_categories == null ? "&include_system_categories=true"
							: "&include_system_categories="
									+ APIUtils
											.toStringBoolean(include_system_categories));
		}
		return params;
	}
}