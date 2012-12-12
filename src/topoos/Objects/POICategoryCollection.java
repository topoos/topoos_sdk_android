package topoos.Objects;

import java.util.ArrayList;
/**
 * Class that implements a collection of the categories of a poi
 * @author MAJS
 *
 */
public class POICategoryCollection {
	private ArrayList<POICategory> categories;

	/**
	 * @param categories
	 */
	public POICategoryCollection(ArrayList<POICategory> categories) {
		super();
		this.categories = categories;
	}

	/**
	 * get the category in an array list
	 * @return the categories
	 */
	public ArrayList<POICategory> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(ArrayList<POICategory> categories) {
		this.categories = categories;
	}
	
	
}
