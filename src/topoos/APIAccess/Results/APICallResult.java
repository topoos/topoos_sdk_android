package topoos.APIAccess.Results;

public abstract class APICallResult {

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	String Error;
	String Result;
	
	public APICallResult(String error,String result){
		this.Error=error;
		this.Result=result;
	}
	
	public APICallResult(){
		
	}
	
	public abstract void setParameters();
	
}
