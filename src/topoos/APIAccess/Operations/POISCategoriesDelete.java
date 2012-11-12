package topoos.APIAccess.Operations;

/**
 * Elimina una categoría de puntos de interés. La categoría ya no aparecerá como
 * resultado de las consultas, pero los puntos de interés seguirán estando
 * asociados a la categoría eliminada si ya lo estaban anteriormente. La
 * categoría debe pertenecer a la aplicación.
 * 
 * @author MAJS
 * 
 */
public class POISCategoriesDelete extends APIOperation {

	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	private String category = null; // (obligatorio) identificador de la
									// categoría a modificar

	public POISCategoriesDelete(String operationName, String method,
			String format, Integer version, String oauth_token, 
			String category) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.category = category;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringUrlEncoded(category));
		validate = validate && isValid(oauth_token);

		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/categories/delete."
					+ this.Format + "?oauth_token=" + this.oauth_token
					+ "&category=" + APIUtils.toStringUrlEncoded(category);
		}
		return params;
	}
}