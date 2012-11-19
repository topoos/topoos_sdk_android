package topoos.APIAccess.Operations;

public class ResourceWebmap extends APIOperation{

	public static final String TYPE_LAYER = "layer";
	
	private String	api_key=null; // (obligatorio) 
	private String  type=null; //(obligatorio) el nombre del parámetro type determina el tipo de recurso que se desea obtener. Por ejemplo para obtener un recurso previamente exportado de tipo capa KML, su valor es layer. Valores permitidos: layer.
	private String	id=null; // (obligatorio) el valor del parámetro type indica el identificador del recurso que se desea visualizar, este se obtuvo como respuesta de la operación de exportación de recurso.

	
	
	/**
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param api_key
	 * @param type
	 * @param id
	 */
	public ResourceWebmap(String operationName, String method, String format,
			Integer version, String api_key, String type, String id) {
		super(operationName, method, format, version);
		this.api_key = api_key;
		this.type = type;
		this.id = id;
	}

	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(api_key);
		validate = validate && isValid(type);
		validate = validate && isValid(id);
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/resources/webmap"
					+ "?api_key=" + api_key
					+ "&"+type+"=" + id
					;
		}
		return params;
	}

}
