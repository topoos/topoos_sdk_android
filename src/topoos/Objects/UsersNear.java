package topoos.Objects;

import java.util.ArrayList;
/**
 * Class that implements a list of users that are near
 * @author MAJS
 *
 */
public class UsersNear  {

	private ArrayList<UserIdPosition> useridPositions=null;
	
	/**
	 * @param userPositions
	 */
	public UsersNear(
			ArrayList<UserIdPosition> userPositions) {
		this.useridPositions = userPositions;
	}

	/**
	 * get the user positions
	 * @return the userPositions
	 */
	public ArrayList<UserIdPosition> getUserPositions() {
		return useridPositions;
	}

	/**
	 * @param userPositions the userPositions to set
	 */
	public void setUserPositions(ArrayList<UserIdPosition> userPositions) {
		this.useridPositions = userPositions;
	}



	
}

