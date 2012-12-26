package topoos.Objects;

import java.io.Serializable;
import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a list of users that are near.
 *
 * @author topoos
 */
public class UsersNear  implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The userid positions. */
	private ArrayList<UserIdPosition> useridPositions=null;
	
	/**
	 * Instantiates a new users near.
	 *
	 * @param userPositions the user positions
	 */
	public UsersNear(
			ArrayList<UserIdPosition> userPositions) {
		this.useridPositions = userPositions;
	}

	/**
	 * get the user positions.
	 *
	 * @return the userPositions
	 */
	public ArrayList<UserIdPosition> getUserPositions() {
		return useridPositions;
	}

	/**
	 * Sets the user positions.
	 *
	 * @param userPositions the userPositions to set
	 */
	public void setUserPositions(ArrayList<UserIdPosition> userPositions) {
		this.useridPositions = userPositions;
	}



	
}

