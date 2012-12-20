package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * 
 * Delete a category of POI. The category will not appear as a result of a
 * request, but the pois are still associated to the deleted category if they
 * were associated previously. The category has to belong to the application
 * 
 * @see APIOperation
 * @author topoos
 * 
 */
public class POISCategoriesDelete extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The category. */
	private Integer category = null; // (obligatorio) identificador de la

	// categoría a modificar

	/**
	 * Instantiates a new pOIS categories delete.
	 * 
	 * @param operationName
	 *            the operation name
	 * @param method
	 *            the method
	 * @param format
	 *            the format
	 * @param version
	 *            the version
	 * @param oauth_token
	 *            the oauth_token
	 * @param category
	 *            the category
	 */
	public POISCategoriesDelete(String operationName, String method,
			String format, Integer version, String oauth_token, Integer category) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringInteger(category));
		validate = validate && isValid(oauth_token);

		return validate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/categories/delete."
					+ this.Format + "?oauth_token=" + this.oauth_token
					+ "&category=" + APIUtils.toStringInteger(category);
		}
		return params;
	}
}