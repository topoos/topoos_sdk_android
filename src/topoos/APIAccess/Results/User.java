package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;

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
			this.Profile= new Profile(jObject.get, gender)
			pos = new Position(id, track_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		private String Model = null;
		private Boolean isLogical = null;

		public VisibleDevice(String id, String name, String model,
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

		public String getModel() {
			return Model;
		}

		public void setModel(String model) {
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
