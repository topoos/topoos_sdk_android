package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.APIAccess.Results.Objects.*;

public class RuleResult extends APICallResult{

	private Rule rule =null;
	
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
	public void setParameters() {
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
			// TODO: handle exception
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
