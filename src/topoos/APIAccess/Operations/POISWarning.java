package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * The Class POISWarning.
 *
 * @see APIOperation
 * @author MAJS
 */
public class POISWarning extends APIOperation {

	/** The Constant TYPE_CLOSED. */
	public static final String TYPE_CLOSED = "CLOSED";
	
	/** The Constant TYPE_DUPLICATED. */
	public static final String TYPE_DUPLICATED = "DUPLICATED";
	
	/** The Constant TYPE_WRONG_INDICATOR. */
	public static final String TYPE_WRONG_INDICATOR = "WRONG_INDICATOR";
	
	/** The Constant TYPE_WRONG_INFO. */
	public static final String TYPE_WRONG_INFO = "WRONG_INFO";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The poi. */
										private String poi = null; // (opcional) lista de identificadores de POI
								// cuyos warnings deseamos recuperar, separados
								// por comas
	/** The type. */
								private String type = null; // (opcional) lista de tipos de warning que
								// deseamos recuperar, los valores pueden ser:

	// CLOSED: Marcados como cerrado o inexistente
	// DUPLICATED: Marcados como duplicado
	// WRONG_INDICATOR: La marca de posición es incorrecta o inexacta
	// WRONG_INFO: La información del punto de interés es incorrecta o
	// incompleta

	/**
								 * Instantiates a new pOIS warning.
								 *
								 * @param operationName the operation name
								 * @param method the method
								 * @param format the format
								 * @param version the version
								 * @param oauth_token the oauth_token
								 * @param poi the poi
								 * @param type the type
								 */
								public POISWarning(String operationName, String method, String format,
			Integer version, String oauth_token, String poi, String type) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = true;
		validate = validate && isValidorNull(poi);
		validate = validate && isValidorNull(type);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/warnings." + this.Format
					+ "?oauth_token=" + this.oauth_token
					+ (poi == null ? "" : "&poi=" + poi)
					+ (type == null ? "" : "&type=" + type);

		}
		return params;
	}

}