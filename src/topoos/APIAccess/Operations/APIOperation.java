package topoos.APIAccess.Operations;

public abstract class APIOperation {


	String OperationName;
	Integer Version;
	String Method;
	String Format;
	
	public APIOperation(String operationName, String method, String format, Integer version) {
		super();
		OperationName = operationName;
		Method = method;
		Format = format;
		Version = version;
	}
	public APIOperation(){
		super();
		Version=-1;
	};
	
	public String getOperationName() {
		return OperationName;
	}

	public void setOperationName(String operationName) {
		OperationName = operationName;
	}

	public String getMethod() {
		return Method;
	}

	public void setMethod(String method) {
		Method = method;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
	
	public Integer getVersion() {
		return Version;
	}
	
	public void setVersion(Integer version) {
		Version = version;
	}
	
	protected boolean isValid(String param){
		return (param!=null && !param.equals(""));
	}
	protected boolean isValidorNull(String param){
		return (param == null || !param.equals(""));
	}
	public boolean ValidateParams(){
		boolean validate = true;
		validate = validate && isValid(OperationName);
		validate = validate && isValid(Method);
		validate = validate && isValid(Format);
		validate = validate && (Version>0);
		return validate;
	};
	
	public abstract String ConcatParams();
	
}
