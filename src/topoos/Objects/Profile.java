package topoos.Objects;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a profile.
 *
 * @author MAJS
 */
public class Profile {

	/** The Birthday. */
	private Date Birthday = null;
	
	/** The Gender. */
	private String Gender = null;

	/**
	 * Instantiates a new profile.
	 *
	 * @param birthday the birthday
	 * @param gender the gender
	 */
	public Profile(Date birthday, String gender) {
		super();
		Birthday = birthday;
		Gender = gender;
	}

	/**
	 * get the birthday.
	 *
	 * @return Date of birthday
	 */
	public Date getBirthday() {
		return Birthday;
	}

	/**
	 * Set the birthday date.
	 *
	 * @param birthday date of birthday to set
	 */
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	/**
	 * get the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}
}