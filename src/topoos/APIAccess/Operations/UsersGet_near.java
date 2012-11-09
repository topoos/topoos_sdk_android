package topoos.APIAccess.Operations;

public class UsersGet_near extends APIOperation {

	private String oauth_token=null;// (obligatorio) access_token a los recursos del usuario
	private String lat=null;// (opcional) latitud del punto central de búsqueda. Es un parámetro obligatorio si no se especifica poi.
	private String lng=null;// (opcional) longitud del punto central de búsqueda. Es un parámetro obligatorio si no se especifica poi.
	private String poi=null;// (opcional) identificador del punto de interés alrededor del cual se realiza la búsqueda. Es un parámetro obligatorio si no se especifican lat y lng.
	private String radius=null;// (obligatorio) radio de búsqueda en metros
	private String active=null;// (opcional) true|false la búsqueda se realiza únicamente entre aquellos usuarios que tengan Track activos en este momento. Valores permitidos “true”. Por defecto “true”
	private String ugroup=null;// (opcional) identificador de grupo de usuario. Si se especifica, los resultados solo incluirán usuarios que pertenezcan a dicho grupo.
	private String Count=null;// (opcional) número de usuarios devueltos. Los devueltos siempre serán los más cercanos al punto. Valor por defecto 1.


	public UsersGet_near(String operationName, String method, String format,
			Integer version, String oauth_token, String lat, String lng,
			String radius, String active, String ugroup, String count) {
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
			Integer version, String oauth_token, String poi, String radius,
			String active, String ugroup, String count) {
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
		validate = validate && ((isValid(lat) && isValid(lng) )||(isValid(poi)));
		validate = validate && isValid(oauth_token);
		validate = validate && (isValid(ugroup)||ugroup==null);
		validate = validate && isValid(radius);
		validate = validate && (isValid(active)||active==null);
		validate = validate && (isValid(Count)||Count==null);
		return validate;
	}

	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub
		String params = null;
		if (this.ValidateParams()) {
			if(poi==null){
				params = "/" + this.Version + "/users/get_near."
						+ this.Format + "?lat="+lat+"&lng="+ this.lng
						+(ugroup==null?"":"&ugroup=" + this.ugroup)
						+"&radius=" + this.radius
						+(active == null? "" : "&active=" + this.active)
						+(Count == null? "" : "&Count=" + this.Count)
						+"&oauth_token=" + this.oauth_token;
			}else{
				params = "/" + this.Version + "/users/get_near."
						+ this.Format + "?poi="+poi
						+(ugroup == null?"":"&ugroup=" + this.ugroup)
						+"&radius=" + this.radius
						+(active == null? "" : "&active=" + this.active)
						+(Count == null? "" : "&Count=" + this.Count)
						+"&oauth_token=" + this.oauth_token;
			}

		}
		return params;
	}


}
