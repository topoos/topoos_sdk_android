package topoos.APIAccess.Operations;

public class ExportLayerTrack extends APIOperation{

	public static final String DATA_TRACK= "Track";
	public static final String TYPE_LAYER= "layer";
	
	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String	TYPE=null; //  (obligatorio) este fragmento determina el tipo de recurso que se desea generar. Por ejemplo para generar un recurso de tipo capa KML, su valor es layer. Valores permitidos: layer.
	private String	DATA=null; //  (obligatorio) este fragmento especifica los datos que se almacenarán en el recurso exportado. Por ejemplo, es posible almacenar un Track. Valores permitidos: Track.
	private String	FORMAT2; // (obligatorio) este fragmento establece el formato de la respuesta de esta operación (no el formato del recurso). Valores disponibles: json.
//asdf
	public ExportLayerTrack(String operationName, String method, String format,
			Integer version, String oauth_token, String tYPE, String dATA,
			String fORMAT2) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		TYPE = tYPE;
		DATA = dATA;
		FORMAT2 = fORMAT2;
	}

	
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(DATA);
		validate = validate && isValid(TYPE);
		validate = validate && isValid(FORMAT2);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/export/"+ExportLayerTrack.TYPE_LAYER+"/"+ExportLayerTrack.DATA_TRACK+"."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&FORMAT=" + this.oauth_token
					;
		}
		return params;
	}


}
