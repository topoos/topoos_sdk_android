package topoos.APIAccess.Operations;

//TODO: Auto-generated Javadoc
/**
* 
* Get resource previously exported.
* 
* @see APIOperation
* @author topoos
* 
*/
public class Resource extends APIOperation {

	/** The type of resource (layer). */
	private String type = null; 
	/** The api_key . */
	private String api_key = null; 
	/** The id of resource. */
	private Integer id =null;





	/**
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param type
	 * @param api_key
	 * @param id
	 */
	public Resource(String operationName, String method, String format,
			Integer version, String type, String api_key, Integer id) {
		super(operationName, method, format, version);
		this.type = type;
		this.api_key = api_key;
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate
				&& ((isValid(APIUtils.toStringInteger(id)) && isValid(APIUtils
						.toStringUrlEncoded(api_key))));
		validate = isValid(type);
		return validate;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/resource/"+id+"."
						+ this.Format+"?api_key"+api_key;
		}
		return params;
	}

}