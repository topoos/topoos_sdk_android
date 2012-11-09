package topoos.APIAccess.Operations;

public class ResourceWebmap extends APIOperation{

	public static final String TYPE_LAYER = "layer";
	
	private String	api_key=null; // (obligatorio) 
	private String  type=null; //(obligatorio) el nombre del parámetro type determina el tipo de recurso que se desea obtener. Por ejemplo para obtener un recurso previamente exportado de tipo capa KML, su valor es layer. Valores permitidos: layer.
	private String	id=null; // (obligatorio) el valor del parámetro type indica el identificador del recurso que se desea visualizar, este se obtuvo como respuesta de la operación de exportación de recurso.

	
	
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
