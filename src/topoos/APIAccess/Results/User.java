package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class User extends APICallResult {

	private String Id = null;
	private String Name = null;
	private String Email = null;
	private Profile Profile = null;
	private ArrayList<Integer> Ugroup = null;
	private Acreditation Acreditation = null;

	public User() {
		super();
	}

	public User(String error, String result) {
		super(error, result);
	}

	public User(String error, String result, String id, String name,
			String email, topoos.APIAccess.Results.User.Profile profile,
			ArrayList<Integer> ugroup,
			topoos.APIAccess.Results.User.Acreditation acreditation) {
		super(error, result);
		Id = id;
		Name = name;
		Email = email;
		Profile = profile;
		Ugroup = ugroup;
		Acreditation = acreditation;
	}

	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		// Processing result
		try {
			JSONObject jObject = (JSONObject) new JSONTokener(this.Result)
					.nextValue();
			// Extracting content
			this.Id = jObject.getString("id");
			this.Name = jObject.getString("name");
			this.Profile = new Profile(APIUtils.toDateString(jObject
					.getJSONObject("profile").getString("birthday")), jObject
					.getJSONObject("profile").getString("gender"));
			JSONArray jarray = jObject.getJSONArray("ugroup");
			if (Ugroup == null)
				Ugroup = new ArrayList<Integer>();
			for (int i = 0; i < jarray.length(); i++) {
				this.Ugroup.add(jarray.getInt(i));
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
			this.Acreditation = new Acreditation(jObject.getJSONObject(
					"accreditation").getString("expirationtime"), jObject
					.getJSONObject("accreditation").getString("client_id"),
					arrayV);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return Profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		Profile = profile;
	}

	/**
	 * @return the ugroup
	 */
	public ArrayList<Integer> getUgroup() {
		return Ugroup;
	}

	/**
	 * @param ugroup the ugroup to set
	 */
	public void setUgroup(ArrayList<Integer> ugroup) {
		Ugroup = ugroup;
	}

	/**
	 * @return the acreditation
	 */
	public Acreditation getAcreditation() {
		return Acreditation;
	}

	/**
	 * @param acreditation the acreditation to set
	 */
	public void setAcreditation(Acreditation acreditation) {
		Acreditation = acreditation;
	}

	public class Acreditation {
		private String Expirationtime = null;
		private String clientId = null;
		private ArrayList<VisibleDevice> visibledevices = null;

		public Acreditation(String expirationtime, String clientId,
				ArrayList<VisibleDevice> visibledevices) {
			super();
			Expirationtime = expirationtime;
			this.clientId = clientId;
			this.visibledevices = visibledevices;
		}

		public String getExpirationtime() {
			return Expirationtime;
		}

		public void setExpirationtime(String expirationtime) {
			Expirationtime = expirationtime;
		}

		public String getClientId() {
			return clientId;
		}

		public void setClientId(String clientId) {
			this.clientId = clientId;
		}

		public ArrayList<VisibleDevice> getVisibledevices() {
			return visibledevices;
		}

		public void setVisibledevices(ArrayList<VisibleDevice> visibledevices) {
			this.visibledevices = visibledevices;
		}

	}

	public class VisibleDevice {

		private String Id = null;
		private String Name = null;
		private Integer Model = null;
		private Boolean isLogical = null;

		public VisibleDevice(String id, String name, Integer model,
				Boolean isLogical) {
			super();
			Id = id;
			Name = name;
			Model = model;
			this.isLogical = isLogical;
		}

		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public Integer getModel() {
			return Model;
		}

		public void setModel(Integer model) {
			Model = model;
		}

		public Boolean getIsLogical() {
			return isLogical;
		}

		public void setIsLogical(Boolean isLogical) {
			this.isLogical = isLogical;
		}
	}

	public class Profile {

		private Date Birthday = null;
		private String Gender = null;

		public Profile(Date birthday, String gender) {
			super();
			Birthday = birthday;
			Gender = gender;
		}

		public Date getBirthday() {
			return Birthday;
		}

		public void setBirthday(Date birthday) {
			Birthday = birthday;
		}

		public String getGender() {
			return Gender;
		}

		public void setGender(String gender) {
			Gender = gender;
		}
	}
}
