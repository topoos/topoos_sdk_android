package topoos.APIAccess.Operations;
/**
 * Obtiene un documento KML que permite representar un polígono en un mapa que acepte capas KML.
 * @author MAJS
 *
 */
public class ResourcesGet_polygon extends APIOperation{

	public static final String SHAPE_CIRCLE="circle";
	
	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String	shape=null; // (obligatorio) forma del polígono (valor admitido "circle")
	private Integer	resolution=null; // (obligatorio) vértices para un círculo
	private Double	lat=null; //(obligatorio) latitud del centro del circulo
	private Double	lng=null; //(obligatorio)longitud del centro del círculo
	private Double	radius=null; //(obligatorio)radio en metros

	public ResourcesGet_polygon(String operationName, String method,
			String format, Integer version, String oauth_token, String shape,
			Integer resolution, Double lat, Double lng, Double radius) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.shape = shape;
		this.resolution = resolution;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
	}
	

	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(APIUtils.toStringDouble(radius));
		validate = validate && isValid(APIUtils.toStringInteger(resolution));
		validate = validate && isValid(shape);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/resources/get_polygon."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&lat=" + APIUtils.toStringDouble(lat)
					+ "&lng=" + APIUtils.toStringDouble(lng)
					+ "&radius=" + APIUtils.toStringDouble(radius)
					+ "&resolution=" + APIUtils.toStringInteger(resolution)
					+ "&shape=" + shape
					;
		}
		return params;
	}

}
