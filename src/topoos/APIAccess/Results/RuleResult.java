package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.APIAccess.Results.Objects.*;
import topoos.Exception.TopoosException;

public class RuleResult extends APICallResult{

	private Rule rule =null;
	
	/**
	 * 
	 */
	public RuleResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public RuleResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param rule
	 */
	public RuleResult(String error, String result, Rule rule) {
		super(error, result);
		this.rule = rule;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		Integer id=null;
		String type=null;
		
		try {
			JSONObject jObject = (JSONObject) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			id = jObject.getInt("id");
			type = jObject.getString("type");
			this.rule=new Rule(id,type);
			
		} catch (Exception e) {
			if (Constants.DEBUG){
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * @return the rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * @param rule the rule to set
	 */
	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
