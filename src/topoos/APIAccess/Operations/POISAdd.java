package topoos.APIAccess.Operations;

public class POISAdd extends APIOperation{

	private String	oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Double	lat=null; // (obligatorio) latitud de la nueva posición. Decimal.
	private Double	lng=null; // (obligatorio) longitud de la nueva posición. Decimal.
	private Double	accuracy=null; // (opcional) precisión de la posición (latitud, longitud). Decimal.
	private Double	vaccuracy=null; // (opcional) precisión de la elevación. Decimal.
	private Double	elevation=null; // (opcional) elevación respecto al nivel del mar. Decimal.
	private String	categories=null; // (obligatorio) identificadores de las categorías a las que pertenece este POI, separados por comas
	private String	name=null; // (obligatorio) nombre del punto de interés. Cadena de texto.  Máximo 255 caracteres.
	private String	desc=null; // (opcional) descripción del punto de interés. Cadena de texto.  Máximo 500 caracteres.
	private String	address=null; // (opcional) dirección del punto del interés. Cadena de texto.  Máximo 50 caracteres.
	private String	cross_street=null; // (opcional) calle transversal. Cadena de texto. Máximo 50 caracteres.
	private String	city=null; // (opcional) ciudad del punto de interés. Cadena de texto. Máximo 50 caracteres.
	private String	country=null; // (opcional) estado. Cadena de texto. Máximo 30 caracteres.
	private String	postal_code=null; // (opcional) código postal. Cadena de texto. Máximo 12 caracteres.
	private String	phone=null; // (opcional) teléfono de contacto. Cadena de texto. Máximo 20 caracteres.
	private String	twitter=null; // (opcional) identificador de usuario o hashtag de Twitter. Cadena de texto. Máximo 50 caracteres.


	public POISAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng,
			Double accuracy, Double vaccuracy, Double elevation,
			String categories, String name, String desc, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.categories = categories;
		this.name = name;
		this.desc = desc;
		this.address = address;
		this.cross_street = cross_street;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.phone = phone;
		this.twitter = twitter;
	}
	
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValidorNull(APIUtils.toStringDouble(accuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(vaccuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(elevation));
		validate = validate && isValidorNull(categories);
		validate = validate && isValidorNull(name);
		validate = validate && isValidorNull(desc);
		validate = validate && isValidorNull(address);
		validate = validate && isValidorNull(cross_street);
		validate = validate && isValidorNull(city);
		validate = validate && isValidorNull(country);
		validate = validate && isValidorNull(postal_code);
		validate = validate && isValidorNull(phone);
		validate = validate && isValidorNull(twitter);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/add." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&lat="+APIUtils.toStringDouble(lat)
					+ "&lng="+APIUtils.toStringDouble(lng)
					+(accuracy == null? "" : "&accuracy="+APIUtils.toStringDouble(accuracy))
					+(vaccuracy == null? "" : "&vaccuracy="+APIUtils.toStringDouble(vaccuracy))
					+(elevation == null? "" : "&elevation="+APIUtils.toStringDouble(elevation))
					+(categories == null? "" : "&categories="+APIUtils.toStringUrlEncoded(categories))
					+(name == null? "" : "&name="+APIUtils.toStringUrlEncoded(name))
					+(desc == null? "" : "&desc="+APIUtils.toStringUrlEncoded(desc))
					+(address == null? "" : "&address="+APIUtils.toStringUrlEncoded(address))
					+(cross_street == null? "" : "&cross_street="+APIUtils.toStringUrlEncoded(cross_street))
					+(city == null? "" : "&city="+APIUtils.toStringUrlEncoded(city))
					+(country == null? "" : "&country="+APIUtils.toStringUrlEncoded(country))
					+(postal_code == null? "" : "&postal_code="+APIUtils.toStringUrlEncoded(postal_code))
					+(phone == null? "" : "&phone="+APIUtils.toStringUrlEncoded(phone))
					+(twitter == null? "" : "&elevation="+APIUtils.toStringUrlEncoded(twitter))
					;
		}
		return params;
	}

}
