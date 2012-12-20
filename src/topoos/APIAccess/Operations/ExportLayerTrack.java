package topoos.APIAccess.Operations;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Make a track public that´s belong to an user and application.
 *
 * @see APIOperation
 * @author MAJS
 */
public class ExportLayerTrack extends APIOperation {

	/** The Constant DATA_TRACK. */
	public static final String DATA_TRACK = "Track";
	
	/** The Constant TYPE_LAYER. */
	public static final String TYPE_LAYER = "layer";
	
	/** The Constant EXPORT_FORMAT. */
	public static final String EXPORT_FORMAT = "kml";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The type. */
										private String type = null; // (obligatorio) este fragmento determina el
								// tipo de recurso que se desea generar. Por
								// ejemplo para generar un recurso de tipo capa
								// KML, su valor es layer. Valores permitidos:
								// layer.
	/** The data. */
								private String data = null; // (obligatorio) este fragmento especifica los
								// datos que se almacenarán en el recurso
								// exportado. Por ejemplo, es posible almacenar
								// un Track. Valores permitidos: Track.

	// Parametros de TracksGet

	/** The export_format. */
								private String export_format; // (obligatorio) este fragmento establece el
									// formato de la respuesta de esta operación
									// (no el formato del recurso). Valores
									// disponibles: json.
	/** The track. */
									protected Integer track = null; // (obligatorio) identificador del Track
									// solicitado
	/** The total. */
									protected Integer total = null; // (opcional) si se especifica un valor N,
									// se obtendrán las últimas N posiciones del
									// Track
	/** The initdate. */
									protected Date initdate = null;
	
	/** The enddate. */
	protected Date enddate = null;

	// : (opcional) fechas en formato UTC que permiten filtrar posiciones
	// registradas dentro del rango especificado, según el estándar ISO 8601. No
	// se incluyen las posiciones registradas en la fecha indicada.

	/**
	 * Instantiates a new export layer track.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param type the type
	 * @param data the data
	 * @param export_format the export_format
	 * @param track the track
	 * @param total the total
	 * @param initdate the initdate
	 * @param endate the endate
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
		this.enddate = endate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(data);
		validate = validate && isValid(type);
		validate = validate && isValid(export_format);
		validate = validate && isValid(APIUtils.toStringInteger(track));
		validate = validate && isValidorNull(APIUtils.toStringInteger(total));
		validate = validate && isValidorNull(APIUtils.toStringDate(initdate));
		validate = validate && isValidorNull(APIUtils.toStringDate(enddate));
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
					+ "/export/"
					+ ExportLayerTrack.TYPE_LAYER
					+ "/"
					+ ExportLayerTrack.DATA_TRACK
					+ "."
					+ this.Format
					+ "?oauth_token="
					+ this.oauth_token
					+ (track == null ? "" : "&track="
							+ APIUtils.toStringInteger(track))
					+ (export_format == null ? "" : "&format="
							+ APIUtils.toStringUrlEncoded(export_format))
					+ (total == null ? "" : "&total="
							+ APIUtils.toStringInteger(total))
					+ (initdate == null ? "" : "&initdate="
							+ APIUtils.toStringDate(initdate))
					+ (enddate == null ? "" : "&endate="
							+ APIUtils.toStringDate(enddate));
		}
		return params;
	}

}
