package topoos.APIAccess.Operations;

public class POISUpdate extends APIOperation{

	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Integer poi=null; // (No puede ser null) identificador del POI que deseamos actualizar. Entero.
	private Double 	lat=null; // (No puede ser null) latitud de la nueva posición. Obligatorio si se especifica lng. Decimal.
	private Double 	lng=null; // (No puede ser null) longitud de la nueva posición. Obligatorio si se especifica lat. Decimal.
	private Double 	accuracy=null; // (opcional) precisión de la posición (latitud, longitud). Decimal.
	private Double 	vaccuracy=null; // (opcional) precisión de la elevación. Decimal.
	private Double 	elevation=null; // (opcional) elevación respecto al nivel del mar. Decimal.
	private String 	categories=null; // (No puede ser null) identificadores de las categorías a las que pertenece este POI, separados por comas

	public POISUpdate(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, Double lat,
			Double lng, Double accuracy, Double vaccuracy, Double elevation,
			String categories) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.lat = lat;
		this.lng = lng;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.elevation = elevation;
		this.categories = categories;
	}

	
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(categories);
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValid(APIUtils.toStringDouble(lat));
		validate = validate && isValid(APIUtils.toStringDouble(lng));
		validate = validate && isValidorNull(APIUtils.toStringDouble(accuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(vaccuracy));
		validate = validate && isValidorNull(APIUtils.toStringDouble(elevation));
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/update." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&poi="+APIUtils.toStringInteger(poi)
					+ "&lat="+APIUtils.toStringDouble(lat)
					+ "&lng="+APIUtils.toStringDouble(lng)
					+(accuracy == null? "" : "&accuracy="+APIUtils.toStringDouble(accuracy))
					+(vaccuracy == null? "" : "&vaccuracy="+APIUtils.toStringDouble(vaccuracy))
					+(elevation == null? "" :  "&elevation="+APIUtils.toStringDouble(elevation))
					;
		}
		return params;
	}
}
