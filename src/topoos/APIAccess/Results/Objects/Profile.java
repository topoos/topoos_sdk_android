package topoos.APIAccess.Results.Objects;

import java.util.Date;

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