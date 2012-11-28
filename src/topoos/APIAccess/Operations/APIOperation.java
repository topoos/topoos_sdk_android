package topoos.APIAccess.Operations;

/**
 * Class that implements the api operations
 * 
 * @author MAJS
 * 
 */
public abstract class APIOperation {

	String OperationName;
	Integer Version;
	String Method;
	String Format;

	/**
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 */
	public APIOperation(String operationName, String method, String format,
			Integer version) {
		super();
		OperationName = operationName;
		Method = method;
		Format = format;
		Version = version;
	}

	public APIOperation() {
		super();
		Version = -1;
	};

	/**
	 * 
	 * @return Operation name
	 */
	public String getOperationName() {
		return OperationName;
	}

	/**
	 * 
	 * @param operationName
	 *            set the operation name
	 */
	public void setOperationName(String operationName) {
		OperationName = operationName;
	}

	/**
	 * 
	 * @return Method
	 */
	public String getMethod() {
		return Method;
	}

	/**
	 * 
	 * @param method
	 *            set method
	 */
	public void setMethod(String method) {
		Method = method;
	}

	/**
	 * 
	 * @return Format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * 
	 * @param format
	 *            set the format
	 */
	public void setFormat(String format) {
		Format = format;
	}

	/**
	 * 
	 * @return Version
	 */
	public Integer getVersion() {
		return Version;
	}

	/**
	 * 
	 * @param version
	 *            set the version
	 */
	public void setVersion(Integer version) {
		Version = version;
	}

	/**
	 * Check if the version is not null or not empty
	 * 
	 * @param param
	 * @return Boolean
	 */
	protected boolean isValid(String param) {
		return (param != null && !param.equals(""));
	}

	/**
	 * Check if is valid or null the param
	 * 
	 * @param param
	 * @return Boolean
	 */
	protected boolean isValidorNull(String param) {
		return (param == null || !param.equals(""));
	}

	/**
	 * Validate the params
	 * 
	 * @return Boolean
	 */
	public boolean ValidateParams() {
		boolean validate = true;
		validate = validate && isValid(OperationName);
		validate = validate && isValid(Method);
		validate = validate && isValid(Format);
		validate = validate && (Version > 0);
		return validate;
	};
	/**
	 * Return the object´s parameters concatenate
	 * @return
	 *  string	
	 */
	public abstract String ConcatParams();

}
