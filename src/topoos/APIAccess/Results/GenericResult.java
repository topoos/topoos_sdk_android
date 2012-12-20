package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class GenericResult extends APICallResult {

	/** The code. */
	private Integer code=null;
	
	/** The description. */
	private String description=null;

	/**
	 * Instantiates a new generic result.
	 */
	public GenericResult() {
		super();
	}

	/**
	 * Instantiates a new generic result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public GenericResult(String error, String result) {
		super(error, result);
	}

	/**
	 * Instantiates a new generic result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param code the code
	 * @param description the description
	 */
	public GenericResult(String error, String result, Integer code,
			String description) {
		super(error, result);
		this.code = code;
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// Processing result
				try {
					JSONObject jObject = (JSONObject) new JSONTokener(this.Result)
							.nextValue();
					this.code=jObject.getInt("code");
					this.description=APIUtils.getStringorNull(jObject,"description");
				}catch (Exception e) {
					if (Constants.DEBUG){
						e.printStackTrace();
					}
					throw new TopoosException(TopoosException.ERROR_PARSE);
				}
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
