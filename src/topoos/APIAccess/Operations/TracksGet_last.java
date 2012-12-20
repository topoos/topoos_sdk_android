package topoos.APIAccess.Operations;

// TODO: Auto-generated Javadoc
/**
 * 
 * Get a document that represents the last registered Track by a device.
 * 
 * @author topoos
 * 
 */
public class TracksGet_last extends APIOperation {

	/** The Constant LAYER_DEFAULT. */
	public static final String LAYER_DEFAULT = "default";
	
	/** The Constant LAYER_BEARING. */
	public static final String LAYER_BEARING = "bearing";
	
	/** The Constant LAYER_TRACKLINE. */
	public static final String LAYER_TRACKLINE = "trackline";

	/** The oauth_token. */
	private String oauth_token = null; // (obligatorio) access_token a los
										// recursos del usuario
	/** The device. */
										private String device = null; // (opcional) dispositivo del que vamos a
									// recuperar el último Track, es obligatorio
									// si la aplicación puede utilizar los
									// dispositivos físicos de un usuario,
									// opción que por defecto está
									// deshabilitada.
	/** The total. */
									private Integer total = null; // (opcional) si se especifica un valor N, se
									// obtendrán las últimas N posiciones del
									// Track
	/** The layer. */
									private String[] layer = null; // (opcional) capas KML solicitadas,
									// separadas por comas.

	// default (valor por defecto) marcadores de posición
	// bearing flechas de rumbo
	// trackline línea de trayectoria

	/**
									 * Instantiates a new tracks get_last.
									 *
									 * @param operationName the operation name
									 * @param method the method
									 * @param format the format
									 * @param version the version
									 * @param oauth_token the oauth_token
									 * @param device the device
									 * @param total the total
									 * @param layer the layer
									 */
									public TracksGet_last(String operationName, String method, String format,
			Integer version, String oauth_token, String device, Integer total,
			String[] layer) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.device = device;
		this.total = total;
		this.layer = layer;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValidorNull(device);
		validate = validate && isValidorNull(APIUtils.toStringInteger(total));
		validate = validate && isValid(oauth_token);
		for (int i = 0; i < layer.length; i++) {
			validate = validate && isValidorNull(layer[i]);
		}
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
					+ "/tracks/get_last."
					+ this.Format
					+ "?oauth_token="
					+ this.oauth_token
					+ (total == null ? "" : "&total="
							+ APIUtils.toStringInteger(total))
					+ (device == null ? "" : "&device=" + device);
			if (layer != null)
				params = params + "&layer=";
			for (int i = 0; i < layer.length; i++) {
				if (i == 0) {
					params = params + layer[i];
				} else {
					params = params + "," + layer[i];
				}
			}
			;

		}
		return params;
	}

}