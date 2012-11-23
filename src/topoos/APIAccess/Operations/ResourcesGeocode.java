package topoos.APIAccess.Operations;
/**
 * Servicio de Geocodificación que permite obtener las coordenadas de una dirección normalizada especificada (Geocodificación regular) o la dirección normalizada a partir de las coordenadas (Geocodificación inversa).
 * @author MAJS
 *
 */
public class ResourcesGeocode  extends APIOperation{
	
	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Double	lat=null; // (opcional) latitud en grados decimales, obligatorio si se especifica lng.
	private Double	lng=null; // (opcional) longitud en grados decimales, obligatorio si se especifica lat.
	private String	Address=null; // (opcional) dirección normalizada de la cual se desea realizar la Geocodificación regular, obligatorio si no se especifica lat o lng.


	public ResourcesGeocode(String operationName, String method, String format,
			Integer version, String oauth_token, Double lat, Double lng) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.lat = lat;
		this.lng = lng;
	}
	
	public ResourcesGeocode(String operationName, String method, String format,
			Integer version, String oauth_token, String address) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		Address = address;
	}

	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && ((isValid(APIUtils.toStringDouble(lat))&&isValid(APIUtils.toStringDouble(lng)))||isValid(Address));
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			if(Address!=null){
				params = "/" + this.Version + "/resources/geocode."
						+ this.Format 
						+ "?oauth_token=" + this.oauth_token
						+ "&Address=" + this.Address
				;
			}else {
				params = "/" + this.Version + "/resources/geocode."
						+ this.Format 
						+ "?oauth_token=" + this.oauth_token
						+"&lat="+APIUtils.toStringDouble(lat)
						+"&lng="+APIUtils.toStringDouble(lng);
				;
			}

		}
		return params;
	}

}