package topoos.APIAccess.Operations;

public class POISWarningAdd extends APIOperation{

	public static final String	TYPE_CLOSED="CLOSED";
	public static final String	TYPE_DUPLICATED="DUPLICATED";
	public static final String	TYPE_WRONG_INDICATOR="WRONG_INDICATOR";
	public static final String	TYPE_WRONG_INFO="WRONG_INFO";
	
	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Integer	poi=null; // (opcional) lista de identificadores de POI cuyos warnings deseamos recuperar, separados por comas
	private String type=null; // (opcional) lista de tipos de warning que deseamos recuperar, los valores pueden ser:
	//	CLOSED: Marcados como cerrado o inexistente
	//	DUPLICATED: Marcados como duplicado
	//	WRONG_INDICATOR: La marca de posición es incorrecta o inexacta
	//	WRONG_INFO: La información del punto de interés es incorrecta o incompleta
	private Double	lat=null; // (obligatorio) latitud de la nueva posición
	private Double	lng=null; // (obligatorio) longitud de la nueva posición
	private Double	accuracy=null; // (opcional) precisión de la posición (latitud, longitud)
	private Double	vaccuracy=null; // (opcional) precisión de la elevación
	private Double	elevation=null; // (opcional) elevación respecto al nivel del mar

	private String	categories=null; // (obligatorio) identificadores de las categorías a las que pertenece este POI, separados por comas
	private String	name=null; // (obligatorio) nombre del punto de interés
	private String	desc=null; // (opcional) descripción del punto de interés
	private String	address=null; // (opcional) dirección del punto del interés
	private String	cross_street=null; // (opcional) calle transversal
	private String	city=null; // (opcional) ciudad del punto de interés
	private String	country=null; // (opcional) estado
	private String	postal_code=null; // (opcional) código postal
	private String	phone=null; // (opcional) teléfono de contacto
	private String	twitter=null; // (opcional) identificador de usuario o hashtag de twitter

	public POISWarningAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String type) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.type = type;
	}
	
	public POISWarningAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String type,
			Double lat, Double lng, Double accuracy, Double vaccuracy,
			Double elevation) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.type = type;
		this.lat = lat;
		this.lng = lng;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
	}
	
	public POISWarningAdd(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, String type,
			String categories, String name, String desc,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.type = type;
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
		// TODO Auto-generated method stub
		boolean validate =  super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValid(type);
		validate = validate && isValid(oauth_token);
		if(type.equals(POISWarningAdd.TYPE_WRONG_INDICATOR)){
			validate = validate && isValid(APIUtils.toStringDouble(lat));
			validate = validate && isValid(APIUtils.toStringDouble(lng));
			validate = validate && isValidorNull(APIUtils.toStringDouble(accuracy));
			validate = validate && isValidorNull(APIUtils.toStringDouble(vaccuracy));
			validate = validate && isValidorNull(APIUtils.toStringDouble(elevation));
		}else if(type.equals(POISWarningAdd.TYPE_WRONG_INFO)){
			validate = validate && isValid(categories);
			validate = validate && isValid(name);
			validate = validate && isValidorNull(desc);
			validate = validate && isValidorNull(address);
			validate = validate && isValidorNull(cross_street);
			validate = validate && isValidorNull(city);
			validate = validate && isValidorNull(country);
			validate = validate && isValidorNull(postal_code);
			validate = validate && isValidorNull(phone);
			validate = validate && isValidorNull(twitter);
		}
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/warnings/add."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token
					+"&poi="+poi
					+"&type="+type
					;
			if(type.equals(POISWarningAdd.TYPE_WRONG_INDICATOR)){
				params = params
						+"&lat="+APIUtils.toStringDouble(lat)
						+"&lng="+APIUtils.toStringDouble(lng)
						+(accuracy == null? "" : "&accuracy="+APIUtils.toStringDouble(accuracy))
						+(vaccuracy == null? "" : "&vaccuracy="+APIUtils.toStringDouble(vaccuracy))
						+(elevation == null? "" : "&elevation="+APIUtils.toStringDouble(elevation));
			}else if(type.equals(POISWarningAdd.TYPE_WRONG_INFO)){
				params = params
						+"&categories="+APIUtils.toStringUrlEncoded(categories)
						+"&name="+APIUtils.toStringUrlEncoded(name)
						+(desc == null? "" : "&desc="+APIUtils.toStringUrlEncoded(desc))
						+(address == null? "" : "&address="+APIUtils.toStringUrlEncoded(address))
						+(cross_street == null? "" : "&cross_street="+APIUtils.toStringUrlEncoded(cross_street))
						+(city == null? "" : "&city="+APIUtils.toStringUrlEncoded(city))
						
						+(country == null? "" : "&country="+APIUtils.toStringUrlEncoded(country))
						+(postal_code == null? "" : "&postal_code="+APIUtils.toStringUrlEncoded(postal_code))
						+(phone == null? "" : "&phone="+APIUtils.toStringUrlEncoded(phone))
						+(twitter == null? "" : "&twitter="+APIUtils.toStringUrlEncoded(twitter))
						;
			}
		}
		return params;
	}

}