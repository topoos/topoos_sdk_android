package topoos.APIAccess.Operations;
/**
 * Crea un nuevo Track. Un Track representa una secuencia de posiciones registradas durante una sesión.
 * @author MAJS
 *
 */
public class TracksAdd extends APIOperation{

	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String device=null; // (opcional) dispositivo que crea el Track. Es un parámetro obligatorio cuando la aplicación puede utilizar los dispositivos físicos de un usuario, opción que por defecto está deshabilitada.
	private String name=null; // (opcional) descripción del Track, máx. 100 caracteres.

	public TracksAdd(String operationName, String method, String format,
			Integer version, String oauth_token, String device, String name) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.device = device;
		this.name = name;
	}

	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(name);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/tracks/add."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token
					+(name == null? "" : "&name="+APIUtils.toStringUrlEncoded(name))
					+(device == null? "" : "&device="+device)
					;

		}
		return params;
	}

}