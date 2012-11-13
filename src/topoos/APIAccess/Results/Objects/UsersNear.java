package topoos.APIAccess.Results.Objects;

import java.util.ArrayList;


public class UsersNear  {

	private ArrayList<UserPosition> userPositions=null;
	/**
	 * 
	 */
	public UsersNear() {
		super();
	}
	
	/**
	 * @param userPositions
	 */
	public UsersNear(
			ArrayList<UserPosition> userPositions) {
		this.userPositions = userPositions;
	}

	/**
	 * @return the userPositions
	 */
	public ArrayList<UserPosition> getUserPositions() {
		return userPositions;
	}

	/**
	 * @param userPositions the userPositions to set
	 */
	public void setUserPositions(ArrayList<UserPosition> userPositions) {
		this.userPositions = userPositions;
	}



	
}

