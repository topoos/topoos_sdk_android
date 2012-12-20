package topoos.APIAccess.Results;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UserResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class UserResult extends APICallResult {

	/** The user. */
	private User user = null;

	/**
	 * Instantiates a new user result.
	 */
	public UserResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new user result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public UserResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new user result.
	 *
	 * @param error the error
	 * @param result the result
	 * @param user the user
	 */
	public UserResult(String error, String result, User user) {
		super(error, result);
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
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
			Id = APIUtils.getStringorNull(jObject,"id");
			Name = APIUtils.getStringorNull(jObject,"name");
			if (jObject.optJSONObject("profile") != null) {
				Profile = new Profile(APIUtils.toDateString(jObject
						.getJSONObject("profile").getString("birthday")),
						APIUtils.getStringorNull(jObject.getJSONObject("profile"),"gender"));
			} else
				Profile = null;
			Email = APIUtils.getStringorNull(jObject,"email");
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
						.getString("id"), APIUtils.getStringorNull(jarray2.getJSONObject(i),
						"name"), jarray2.getJSONObject(i).getInt("model"),
						jarray2.getJSONObject(i).getBoolean("islogical")));
			}
			Acreditation = new Acreditation(APIUtils.getStringorNull(jObject.getJSONObject(
					"accreditation"),"expirationtime"), jObject
					.getJSONObject("accreditation").getString("client_id"),
					arrayV);
			this.user = new User(Id, Name, Email, Profile, Ugroup, Acreditation);
		} catch (Exception e) {
			if (Constants.DEBUG) {
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}

	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
