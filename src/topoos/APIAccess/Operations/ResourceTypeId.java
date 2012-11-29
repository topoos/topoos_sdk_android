package topoos.APIAccess.Operations;
/**
 * @see APIOperation
 * @author MAJS
 *
 */
public class ResourceTypeId extends APIOperation{

	public static final String DATA_TRACK= "Track";
	public static final String TYPE_LAYER= "layer";
	
	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String	TYPE=null; //  (obligatorio) este fragmento determina el tipo de recurso que se desea generar. Por ejemplo para generar un recurso de tipo capa KML, su valor es layer. Valores permitidos: layer.
	private String	DATA=null; //  (obligatorio) este fragmento especifica los datos que se almacenarán en el recurso exportado. Por ejemplo, es posible almacenar un Track. Valores permitidos: Track.

	public ResourceTypeId(String operationName, String method, String format,
			Integer version, String oauth_token, String tYPE, String dATA) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		TYPE = tYPE;
		DATA = dATA;
	}
//	asdfaasdf
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(DATA);
		validate = validate && isValid(TYPE);
		return validate;
	}

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
