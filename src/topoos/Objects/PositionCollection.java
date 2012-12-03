package topoos.Objects;

import java.util.ArrayList;

/**
 * Class that implements a position collection 
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
	 * get the position of the collection
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
