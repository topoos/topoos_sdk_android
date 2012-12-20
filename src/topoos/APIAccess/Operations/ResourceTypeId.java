package topoos.APIAccess.Operations;
// TODO: Auto-generated Javadoc

/**
 * The Class ResourceTypeId.
 *
 * @see APIOperation
 * @author MAJS
 */
public class ResourceTypeId extends APIOperation{

	/** The Constant DATA_TRACK. */
	public static final String DATA_TRACK= "Track";
	
	/** The Constant TYPE_LAYER. */
	public static final String TYPE_LAYER= "layer";
	
	/** The oauth_token. */
	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	
	/** The type. */
	private String	TYPE=null; //  (obligatorio) este fragmento determina el tipo de recurso que se desea generar. Por ejemplo para generar un recurso de tipo capa KML, su valor es layer. Valores permitidos: layer.
	
	/** The data. */
	private String	DATA=null; //  (obligatorio) este fragmento especifica los datos que se almacenarán en el recurso exportado. Por ejemplo, es posible almacenar un Track. Valores permitidos: Track.

	/**
	 * Instantiates a new resource type id.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param tYPE the t ype
	 * @param dATA the d ata
	 */
	public ResourceTypeId(String operationName, String method, String format,
			Integer version, String oauth_token, String tYPE, String dATA) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		TYPE = tYPE;
		DATA = dATA;
	}
//	asdfaasdf
	/* (non-Javadoc)
 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
 */
@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(DATA);
		validate = validate && isValid(TYPE);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/export/get_polygon."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token

					;
		}
		return params;
	}


}
