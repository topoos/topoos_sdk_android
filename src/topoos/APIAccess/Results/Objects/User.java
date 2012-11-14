package topoos.APIAccess.Results.Objects;

import java.util.ArrayList;

public class User   {

	private String Id = null;
	private String Name = null;
	private String Email = null;
	private Profile Profile = null;
	private ArrayList<Integer> Ugroup = null;
	private Acreditation Acreditation = null;

	public User(String id, String name,
			String email, Profile profile,
			ArrayList<Integer> ugroup,
			Acreditation acreditation) {
		Id = id;
		Name = name;
		Email = email;
		Profile = profile;
		Ugroup = ugroup;
		Acreditation = acreditation;
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



	

}
