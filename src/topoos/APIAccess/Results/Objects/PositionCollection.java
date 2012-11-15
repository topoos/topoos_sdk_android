package topoos.APIAccess.Results.Objects;

import java.util.ArrayList;

/**
 * 
 * @author MAJS
 *
 */
public class PositionCollection {

	ArrayList<Position> positionCollection=null;

	/**
	 * @param positionCollection
	 */
	public PositionCollection(ArrayList<Position> positionCollection) {
		super();
		this.positionCollection = positionCollection;
	}

	/**
	 * @return the positionCollection
	 */
	public ArrayList<Position> getPositionCollection() {
		return positionCollection;
	}

	/**
	 * @param positionCollection the positionCollection to set
	 */
	public void setPositionCollection(ArrayList<Position> positionCollection) {
		this.positionCollection = positionCollection;
	}
	
	
	
}
