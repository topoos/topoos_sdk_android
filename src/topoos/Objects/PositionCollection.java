package topoos.Objects;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Class that implements a position collection.
 *
 * @author topoos
 */
public class PositionCollection implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The position collection. */
	ArrayList<Position> positionCollection=null;

	/**
	 * Instantiates a new position collection.
	 *
	 * @param positionCollection the position collection
	 */
	public PositionCollection(ArrayList<Position> positionCollection) {
		super();
		this.positionCollection = positionCollection;
	}

	/**
	 * get the position of the collection.
	 *
	 * @return the positionCollection
	 */
	public ArrayList<Position> getPositionCollection() {
		return positionCollection;
	}

	/**
	 * Sets the position collection.
	 *
	 * @param positionCollection the positionCollection to set
	 */
	public void setPositionCollection(ArrayList<Position> positionCollection) {
		this.positionCollection = positionCollection;
	}
	
	
	
}
