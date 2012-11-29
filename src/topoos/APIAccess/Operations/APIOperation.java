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
	 * @param operationName name of the operation
	 * @param method name of the method
	 * @param format format
	 * @param version version 
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
	 * get the operation name
	 * @return Operation name
	 */
	public String getOperationName() {
		return OperationName;
	}

	/**
	 * set the operation name
	 * @param operationName
	 *            set the operation name
	 */
	public void setOperationName(String operationName) {
		OperationName = operationName;
	}

	/**
	 * get the method
	 * @return Method
	 */
	public String getMethod() {
		return Method;
	}

	/**
	 * set the method
	 * @param method
	 *            set method
	 */
	public void setMethod(String method) {
		Method = method;
	}

	/**
	 * get the format
	 * @return Format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * set the format
	 * @param format
	 *            set the format
	 */
	public void setFormat(String format) {
		Format = format;
	}

	/**
	 * get the version
	 * @return Version
	 */
	public Integer getVersion() {
		return Version;
	}

	/**
	 * set the version
	 * @param version
	 *            set the version
	 */
	public void setVersion(Integer version) {
		Version = version;
	}

	/**
	 * check if the version is not null or not empty
	 * 
	 * @param param
	 * @return Boolean
	 */
	protected boolean isValid(String param) {
		return (param != null && !param.equals(""));
	}

	/**
	 * check if is valid or null the param
	 * 
	 * @param param
	 * @return Boolean
	 */
	protected boolean isValidorNull(String param) {
		return (param == null || !param.equals(""));
	}

	/**
	 * validate the params
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
	 * return the object´s parameters concatenate
	 * @return
	 *  string	
	 */
	public abstract String ConcatParams();

}
