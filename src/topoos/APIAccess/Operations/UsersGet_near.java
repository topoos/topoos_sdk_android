package topoos.APIAccess.Operations;

public class UsersGet_near extends APIOperation {

	private String oauth_token=null;// (obligatorio) access_token a los recursos del usuario
	private Double lat=null;// (opcional) latitud del punto central de búsqueda. Es un parámetro obligatorio si no se especifica poi.
	private Double lng=null;// (opcional) longitud del punto central de búsqueda. Es un parámetro obligatorio si no se especifica poi.
	private Integer poi=null;// (opcional) identificador del punto de interés alrededor del cual se realiza la búsqueda. Es un parámetro obligatorio si no se especifican lat y lng.
	private Integer radius=null;// (obligatorio) radio de búsqueda en metros
	private Boolean active=null;// (opcional) true|false la búsqueda se realiza únicamente entre aquellos usuarios que tengan Track activos en este momento. Valores permitidos “true”. Por defecto “true”
	private Integer ugroup=null;// (opcional) identificador de grupo de usuario. Si se especifica, los resultados solo incluirán usuarios que pertenezcan a dicho grupo.
	private Integer Count=null;// (opcional) número de usuarios devueltos. Los devueltos siempre serán los más cercanos al punto. Valor por defecto 1.


	public UsersGet_near(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng,
			Integer radius, Boolean active, Integer ugroup, Integer count) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
		this.active = active;
		this.ugroup = ugroup;
		Count = count;
	}

	public UsersGet_near(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi, Integer radius,
			Boolean active, Integer ugroup, Integer count) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
		this.radius = radius;
		this.active = active;
		this.ugroup = ugroup;
		Count = count;
	}


	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && ((isValid(APIUtils.toStringDouble(lat)) && isValid(APIUtils.toStringDouble(lng)) )||(isValid(APIUtils.toStringInteger(poi))));
		validate = validate && isValid(oauth_token);
		validate = validate && (isValidorNull(APIUtils.toStringInteger(ugroup)));
		validate = validate && isValid(APIUtils.toStringInteger(radius));
		validate = validate && (isValidorNull(APIUtils.toStringBoolean(active)));
		validate = validate && (isValidorNull(APIUtils.toStringInteger(Count)));
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			if(poi==null){
				params = "/" + this.Version + "/users/get_near."
						+ this.Format + "?lat="+APIUtils.toStringDouble(lat)+"&lng="+ APIUtils.toStringDouble(this.lng)
						+(ugroup==null?"":"&ugroup=" + APIUtils.toStringInteger(this.ugroup))
						+"&radius=" + APIUtils.toStringInteger(this.radius)
						+(active == null? "" : "&active=" + APIUtils.toStringBoolean(this.active))
						+(Count == null? "" : "&Count=" + APIUtils.toStringInteger(this.Count))
						+"&oauth_token=" + this.oauth_token;
			}else{
				params = "/" + this.Version + "/users/get_near."
						+ this.Format + "?poi="+APIUtils.toStringInteger(this.poi)
						+(ugroup == null?"":"&ugroup=" + APIUtils.toStringInteger(this.ugroup))
						+"&radius=" + APIUtils.toStringInteger(this.radius)
						+(active == null? "" : "&active=" + APIUtils.toStringBoolean(this.active))
						+(Count == null? "" : "&Count=" + APIUtils.toStringInteger(this.Count))
						+"&oauth_token=" + this.oauth_token;
			}

		}
		return params;
	}


}
