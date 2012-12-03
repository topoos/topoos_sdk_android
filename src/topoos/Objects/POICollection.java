package topoos.Objects;

import java.util.ArrayList;

/**
 * Class that implements a collection of POI
 * 
 * @author FBP
 * 
 */
public class POICollection {

	private ArrayList<POI> poiList = null;

	/**
	 * @param poiList
	 */
	public POICollection(ArrayList<POI> poiList) {
		super();
		this.poiList = poiList;
	}

	/**
	 * get the poiList
	 * 
	 * @return the poiList
	 */
	public ArrayList<POI> getPoiList() {
		return poiList;
	}

	/**
	 * @param poiList
	 *            the poiList to set
	 */
	public void setPoiList(ArrayList<POI> poiList) {
		this.poiList = poiList;
	}

}
