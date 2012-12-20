package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * 
 * Create a new Track. A Track represent a sequence of registered positions.
 * during a session
 * 
 * @see APIOperation
 * @author MAJS
 * 
 */
public class TracksAdd extends APIOperation {

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The device. */
										private String device = null; // (opcional) dispositivo que crea el Track.
									// Es un parámetro obligatorio cuando la
									// aplicación puede utilizar los
									// dispositivos físicos de un usuario,
									// opción que por defecto está
									// deshabilitada.
	/** The name. */
									private String name = null; // (opcional) descripción del Track, máx. 100
								// caracteres.

	/**
								 * Instantiates a new tracks add.
								 *
								 * @param operationName the operation name
								 * @param method the method
								 * @param format the format
								 * @param version the version
								 * @param oauth_token the oauth_token
								 * @param device the device
								 * @param name the name
								 */
								public TracksAdd(String operationName, String method, String format,
			Integer version, String oauth_token, String device, String name) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.device = device;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(name);
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
					+ "/tracks/add."
					+ this.Format
					+ "?oauth_token="
					+ this.oauth_token
					+ (name == null ? "" : "&name="
							+ APIUtils.toStringUrlEncoded(name))
					+ (device == null ? "" : "&device=" + device);

		}
		return params;
	}

}