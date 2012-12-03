package topoos.Objects;

/**
 * Class that implements a user id position
 * @author MAJS
 *
 */
public class UserIdPosition {

	private String userid = null;
	private UserPosition position = null;
	/**
	 * @param userid
	 * @param position
	 */
	public UserIdPosition(String userid, UserPosition position) {
		super();
		this.userid = userid;
		this.position = position;
	}
	/**get the user position
	 * @return the position
	 */
	public UserPosition getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(UserPosition position) {
		this.position = position;
	}
	/**
	 * get the user id
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
