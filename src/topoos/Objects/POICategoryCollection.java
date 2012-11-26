package topoos.Objects;

import java.util.ArrayList;

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
