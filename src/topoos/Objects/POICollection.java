package topoos.Objects;

import java.util.ArrayList;

public class POICollection {

	private ArrayList<POI> poiList=null;

	/**
	 * @param poiList
	 */
	public POICollection(ArrayList<POI> poiList) {
		super();
		this.poiList = poiList;
	}

	/**
	 * @return the poiList
	 */
	public ArrayList<POI> getPoiList() {
		return poiList;
	}

	/**
	 * @param poiList the poiList to set
	 */
	public void setPoiList(ArrayList<POI> poiList) {
		this.poiList = poiList;
	}
	
	
	
}
