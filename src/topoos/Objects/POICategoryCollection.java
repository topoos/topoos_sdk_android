package topoos.Objects;

import java.io.Serializable;
import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a collection of the categories of a poi.
 *
 * @author topoos
 */
public class POICategoryCollection implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;
	
	/** The categories. */
	private ArrayList<POICategory> categories;

	/**
	 * Instantiates a new pOI category collection.
	 *
	 * @param categories the categories
	 */
	public POICategoryCollection(ArrayList<POICategory> categories) {
		super();
		this.categories = categories;
	}

	/**
	 * get the category in an array list.
	 *
	 * @return the categories
	 */
	public ArrayList<POICategory> getCategories() {
		return categories;
	}

	/**
	 * Sets the categories.
	 *
	 * @param categories the categories to set
	 */
	public void setCategories(ArrayList<POICategory> categories) {
		this.categories = categories;
	}
	
	
}
