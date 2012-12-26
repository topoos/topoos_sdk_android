package topoos.Objects;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Class that implements a user id position.
 *
 * @author topoos
 */
public class UserIdPosition implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The userid. */
	private String userid = null;
	
	/** The position. */
	private UserPosition position = null;
	
	/**
	 * Instantiates a new user id position.
	 *
	 * @param userid the userid
	 * @param position the position
	 */
	public UserIdPosition(String userid, UserPosition position) {
		super();
		this.userid = userid;
		this.position = position;
	}
	
	/**
	 * get the user position.
	 *
	 * @return the position
	 */
	public UserPosition getPosition() {
		return position;
	}
	
	/**
	 * Sets the position.
	 *
	 * @param position the position to set
	 */
	public void setPosition(UserPosition position) {
		this.position = position;
	}
	
	/**
	 * get the user id.
	 *
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	
	/**
	 * Sets the userid.
	 *
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
