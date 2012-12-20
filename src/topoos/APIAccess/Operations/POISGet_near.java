package topoos.APIAccess.Operations;
// TODO: Auto-generated Javadoc

/**
 * The Class POISGet_near.
 *
 * @see APIOperation
 * @author topoos
 */
public class POISGet_near extends APIOperation{

	/** The oauth_token. */
	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	
	/** The lat. */
	private Double  lat=null; // (obligatorio) latitud del punto central de búsqueda
	
	/** The lng. */
	private Double  lng=null; // (obligatorio) longitud del punto central de búsqueda
	
	/** The radius. */
	private Integer  radius=null; // (obligatorio) radio de búsqueda en metros
	
	/** The categories. */
	private String  categories=null; // (obligatorio) identificadores de las categorías de filtrado, los POI obtenidos pertenecerán a todas las especificadas, separadas por comas

	/**
	 * Instantiates a new pOIS get_near.
	 *
	 * @param operationName the operation name
	 * @param method the method
	 * @param format the format
	 * @param version the version
	 * @param oauth_token the oauth_token
	 * @param lat the lat
	 * @param lng the lng
	 * @param radius the radius
	 * @param categories the categories
	 */
	public POISGet_near(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng,
			Integer radius, String categories) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
		this.categories = categories;
	}

	
	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValid(APIUtils.toStringInteger(radius));
		validate = validate && isValid(categories);
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
			params = "/" + this.Version + "/pois/get_near." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&lat="+APIUtils.toStringDouble(lat)
					+ "&lng="+APIUtils.toStringDouble(lng)
					+ "&radius="+APIUtils.toStringInteger(radius)
					+ "&categories="+APIUtils.toStringUrlEncoded(categories)
					;
		}
		return params;
	}


}