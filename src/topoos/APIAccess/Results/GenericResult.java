package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;


public class GenericResult extends APICallResult {

	private Integer code=null;
	private String description=null;

	public GenericResult() {
		super();
	}

	public GenericResult(String error, String result) {
		super(error, result);
	}

	public GenericResult(String error, String result, Integer code,
			String description) {
		super(error, result);
		this.code = code;
		this.description = description;
	}

	@Override
	public void setParameters() throws TopoosException {
		// Processing result
				try {
					JSONObject jObject = (JSONObject) new JSONTokener(this.Result)
							.nextValue();
					this.code=jObject.getInt("code");
					this.description=jObject.getString("description");
				}catch (Exception e) {
					if (Constants.DEBUG){
						e.printStackTrace();
					}
					throw new TopoosException(TopoosException.ERROR_PARSE);
				}
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
