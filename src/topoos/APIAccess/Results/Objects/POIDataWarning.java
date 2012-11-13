package topoos.APIAccess.Results.Objects;

import java.util.ArrayList;

public class POIDataWarning {
	private POI poi=null;
	private ArrayList<POIWarning> poiWarnings=null;
	/**
	 * @param poi
	 * @param poiWarnings
	 */
	public POIDataWarning(POI poi, ArrayList<POIWarning> poiWarnings) {
		super();
		this.poi = poi;
		this.poiWarnings = poiWarnings;
	}
	/**
	 * @return the poi
	 */
	public POI getPoi() {
		return poi;
	}
	/**
	 * @param poi the poi to set
	 */
	public void setPoi(POI poi) {
		this.poi = poi;
	}
	/**
	 * @return the poiWarnings
	 */
	public ArrayList<POIWarning> getPoiWarnings() {
		return poiWarnings;
	}
	/**
	 * @param poiWarnings the poiWarnings to set
	 */
	public void setPoiWarnings(ArrayList<POIWarning> poiWarnings) {
		this.poiWarnings = poiWarnings;
	}

}
