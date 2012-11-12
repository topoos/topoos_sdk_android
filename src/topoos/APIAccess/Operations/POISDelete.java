package topoos.APIAccess.Operations;

public class POISDelete extends APIOperation{

	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private Integer poi=null; //(obligatorio) identificador del punto de interés que deseamos eliminar
	
	public POISDelete(String operationName, String method, String format,
			Integer version, String oauth_token, Integer poi) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.poi = poi;
	}

	
	@Override
	public boolean ValidateParams() {
		// TODO Auto-generated method stub
		boolean validate = super.ValidateParams();
		validate = validate && isValid(APIUtils.toStringInteger(poi));
		validate = validate && isValid(oauth_token);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/pois/delete." + this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "&poi="+APIUtils.toStringInteger(poi)
					;
		}
		return params;
	}
}