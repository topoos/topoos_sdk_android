package topoos.APIAccess.Results;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import topoos.APIAccess.Results.Objects.*;
/**
 * 
 * @author MAJS
 *
 */
public class UserResult extends APICallResult {


	private User user=null;


	/**
	 * 
	 */
	public UserResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public UserResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param user
	 */
	public UserResult(String error, String result, User user) {
		super(error, result);
		this.user = user;
	}

	@Override
	public void setParameters() {
		 String Id = null;
		 String Name = null;
		 String Email = null;
		 Profile Profile = null;
		 ArrayList<Integer> Ugroup = null;
		 Acreditation Acreditation = null;
		// Processing result
		try {
			JSONObject jObject = (JSONObject) new JSONTokener(Result)
					.nextValue();
			// Extracting content
			Id = jObject.getString("id");
			Name = jObject.getString("name");
			Profile = new Profile(APIUtils.toDateString(jObject
					.getJSONObject("profile").getString("birthday")), jObject
					.getJSONObject("profile").getString("gender"));
			Email= jObject.getString("email");
			JSONArray jarray = jObject.getJSONArray("ugroup");
			if (Ugroup == null)
				Ugroup = new ArrayList<Integer>();
			for (int i = 0; i < jarray.length(); i++) {
				Ugroup.add(jarray.getInt(i));
			}
			ArrayList<VisibleDevice> arrayV = new ArrayList<VisibleDevice>();
			JSONArray jarray2 = jObject.getJSONObject("accreditation")
					.getJSONArray("visibledevices");
			for (int i = 0; i < jarray2.length(); i++) {
				arrayV.add(new VisibleDevice(jarray2.getJSONObject(i)
						.getString("id"), jarray2.getJSONObject(i).getString(
						"name"), jarray2.getJSONObject(i).getInt("model"),
						jarray2.getJSONObject(i).getBoolean("islogical")));
			}
			Acreditation = new Acreditation(jObject.getJSONObject(
					"accreditation").getString("expirationtime"), jObject
					.getJSONObject("accreditation").getString("client_id"),
					arrayV);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.user=new User(Id, Name,
				Email, Profile,
				Ugroup,
				Acreditation);
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
