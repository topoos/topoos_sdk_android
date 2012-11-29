package topoos.APIAccess.Operations;

/**
 * 
 * Create a new category of POI.
 * @see APIOperation
 * @author MAJS
 * 
 */
public class POISCategoriesAdd extends APIOperation {

	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	private String desc = null; // : (obligatorio) descripción de la categoría

	public POISCategoriesAdd(String operationName, String method,
			String format, Integer version, String oauth_token, String desc) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.desc = desc;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringUrlEncoded(desc));
		validate = validate && isValid(oauth_token);
		return validate;
	}

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