package topoos.APIAccess.Results;

public class APICallResult {

	protected String Format = null;
	protected String Error = null;
	protected String Result = null;

	public APICallResult(String error, String result) {
		this.Error = error;
		this.Result = result;
	}

	public APICallResult() {

	}

	public void setParameters() {
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		Format = format;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return Error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		Error = error;
	}

	/**
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
