package topoos.APIAccess.Operations;
/**
 * Permite establecer el grupo al que pertenece el usuario.
 * @author MAJS
 *
 */
public class UsersUSRAdd_group extends APIOperation {


	private String USR;
	private String oauth_token;
	private String ugroup;

	public UsersUSRAdd_group(String operationName, String method,
			String format, Integer version, String uSR, String oauth_token,
			String ugroup) {
		super(operationName, method, format, version);
		USR = uSR;
		this.oauth_token = oauth_token;
		this.ugroup = ugroup;
	}


	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(USR);
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(ugroup);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/users/" + this.USR + "/add_group."
					+ this.Format + "?ugroup="+ugroup+"&oauth_token=" + this.oauth_token;

		}
		return params;
	}

}
