package topoos.APIAccess.Operations;

/**
 * @see APIOperation
 * @author MAJS
 * 
 */
public class PositionsGet extends APIOperation {

	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	private Integer posid = null; // (obligatorio) identificador de una posición
									// concreta.
	private String usr = null; // (opcional) identificador del usuario, si no se
								// indica se obtendrá la última posición del
								// usuario actual
	private String device = null; // (obligatorio) identificador del dispositivo
									// del cual vamos a obtener la última
									// posición.

	public PositionsGet(String operationName, String method, String format,
			Integer version, String oauth_token, Integer posid, String usr,
			String device) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.posid = posid;
		this.usr = usr;
		this.device = device;
	}

	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = true;
		validate = validate
				&& (isValid(APIUtils.toStringInteger(posid)) || isValid(usr) || isValid(device));
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			if (isValid(APIUtils.toStringInteger(posid))) {
				params = "/" + this.Version + "/positions/get." + this.Format
						+ "?oauth_token=" + this.oauth_token + "&posid="
						+ APIUtils.toStringInteger(posid);
			} else if (isValid(usr)) {
				params = "/" + this.Version + "/positions/get." + this.Format
						+ "?oauth_token=" + this.oauth_token + "&usr=" + usr;
			} else if (isValid(device)) {
				params = "/" + this.Version + "/positions/get." + this.Format
						+ "?oauth_token=" + this.oauth_token + "&device="
						+ device;
			}
		}
		return params;
	}

}
