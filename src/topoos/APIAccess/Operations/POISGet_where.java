package topoos.APIAccess.Operations;
/**
 * @see APIOperation
 * @author MAJS
 *
 */
public class POISGet_where extends APIOperation{

	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String  pois=null; // (opcional) lista de identificadores de POI que deseamos recuperar, separados por comas
	private String  categories=null; // (obligatorio) identificadores de las categorías de filtrado, los POI obtenidos pertenecerán a todas las especificadas, separadas por comas
	private String  city=null; // (opcional) obtiene los POI en la ciudad especificada
	private String  country=null; // (opcional) obtiene los POI en la provincia especificada
	private String  postal_code=null; //(opcional) obtiene los POI cuyo código postal coincida con el especificado
	private String  q=null; // (opcional) obtiene los POI cuyo nombre o descripción coincida con el patrón

	public POISGet_where(String operationName, String method, String format,
			Integer version, String oauth_token, String pois,
			String categories, String city, String country, String postal_code,
			String q) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.pois = pois;
		this.categories = categories;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.q = q;
	}

	
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(categories);
		validate = validate && isValidorNull(pois);
		validate = validate && isValidorNull(city);
		validate = validate && isValidorNull(country);
		validate = validate && isValidorNull(postal_code);
		validate = validate && isValidorNull(q);
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/get_where." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&categories="+APIUtils.toStringUrlEncoded(categories)
					+(pois == null? "" : "&pois="+APIUtils.toStringUrlEncoded(pois))
					+(city == null? "" : "&city="+APIUtils.toStringUrlEncoded(city))
					+(country == null? "" : "&country="+APIUtils.toStringUrlEncoded(country))
					+(postal_code == null? "" : "&postal_code="+APIUtils.toStringUrlEncoded(postal_code))
					+(q == null? "" : "&q="+APIUtils.toStringUrlEncoded(q))
					;
		}
		return params;
	}
}
