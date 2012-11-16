package topoos.APIAccess.Operations;

import java.util.Date;

public class ExportLayerTrack extends APIOperation{

	public static final String DATA_TRACK= "Track";
	public static final String TYPE_LAYER= "layer";
	
	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String	type=null; //  (obligatorio) este fragmento determina el tipo de recurso que se desea generar. Por ejemplo para generar un recurso de tipo capa KML, su valor es layer. Valores permitidos: layer.
	private String	data=null; //  (obligatorio) este fragmento especifica los datos que se almacenarán en el recurso exportado. Por ejemplo, es posible almacenar un Track. Valores permitidos: Track.

	//Parametros de TracksGet
	
	private String	export_format; // (obligatorio) este fragmento establece el formato de la respuesta de esta operación (no el formato del recurso). Valores disponibles: json.
	protected Integer  	track=null; // (obligatorio) identificador del Track solicitado
	protected Integer  	total=null; // (opcional) si se especifica un valor N, se obtendrán las últimas N posiciones del Track
	protected Date initdate=null;
	protected Date endate=null;
		//: (opcional) fechas en formato UTC que permiten filtrar posiciones registradas dentro del rango especificado, según el estándar ISO 8601. No se incluyen las posiciones registradas en la fecha indicada.


	/**
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param type
	 * @param data
	 * @param export_format
	 * @param track
	 * @param total
	 * @param initdate
	 * @param endate
	 */
	public ExportLayerTrack(String operationName, String method, String format,
			Integer version, String oauth_token, String type, String data,
			String export_format, Integer track, Integer total, Date initdate,
			Date endate) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.type = type;
		this.data = data;
		this.export_format = export_format;
		this.track = track;
		this.total = total;
		this.initdate = initdate;
		this.endate = endate;
	}
	
	
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(data);
		validate = validate && isValid(type);
		validate = validate && isValid(export_format);
		validate = validate && isValidorNull(APIUtils.toStringInteger(track));
		validate = validate && isValidorNull();
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
