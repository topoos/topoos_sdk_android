package topoos.APIAccess.Operations;
/**
 * 
 * @see APIOperation
 * @author MAJS
 *
 */
public class POISGet_near extends APIOperation{

	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Double  lat=null; // (obligatorio) latitud del punto central de búsqueda
	private Double  lng=null; // (obligatorio) longitud del punto central de búsqueda
	private Integer  radius=null; // (obligatorio) radio de búsqueda en metros
	private String  categories=null; // (obligatorio) identificadores de las categorías de filtrado, los POI obtenidos pertenecerán a todas las especificadas, separadas por comas

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