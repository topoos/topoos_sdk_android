package topoos.Objects;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Class that implements a collection of POI.
 *
 * @author FBP
 */
public class POICollection {

	/** The poi list. */
	private ArrayList<POI> poiList = null;

	/**
	 * Instantiates a new pOI collection.
	 *
	 * @param poiList the poi list
	 */
	public POICollection(ArrayList<POI> poiList) {
		super();
		this.poiList = poiList;
	}

	/**
	 * get the poiList.
	 *
	 * @return the poiList
	 */
	public ArrayList<POI> getPoiList() {
		return poiList;
	}

	/**
	 * Sets the poi list.
	 *
	 * @param poiList the poiList to set
	 */
	public void setPoiList(ArrayList<POI> poiList) {
		this.poiList = poiList;
	}

}
