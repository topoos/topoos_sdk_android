package topoos.APIAccess.Results;

import topoos.Exception.TopoosException;
/**
 * Class that implements the api caller result
 * @see APICallResult
 * @author MAJS
 *
 */
public abstract class APICallResult {

	protected String Format = null;
	protected String Error = null;
	protected String Result = null;

	public APICallResult(String error, String result) {
		this.Error = error;
		this.Result = result;
	}

	public APICallResult() {

	}

	public abstract void setParameters() throws TopoosException;

	/**
	 * set the parameter
	 * @return the format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * set the format that received as a parameter  
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		Format = format;
	}

	/**
	 * get the error
	 * @return the error
	 */
	public String getError() {
		return Error;
	}

	/**
	 * 
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		Error = error;
	}

	/**
	 * get the result
	 * @return the result
	 */
	public String getResult() {
		return Result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		Result = result;
	}

}
