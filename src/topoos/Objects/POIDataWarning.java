package topoos.Objects;

import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a poi data warning.
 *
 * @author topoos
 */
public class POIDataWarning {
	
	/** The poi. */
	private POI poi=null;
	
	/** The poi warnings. */
	private ArrayList<POIWarning> poiWarnings=null;
	
	/**
	 * Instantiates a new pOI data warning.
	 *
	 * @param poi the poi
	 * @param poiWarnings the poi warnings
	 */
	public POIDataWarning(POI poi, ArrayList<POIWarning> poiWarnings) {
		super();
		this.poi = poi;
		this.poiWarnings = poiWarnings;
	}
	
	/**
	 * get the poi.
	 *
	 * @return the poi
	 */
	public POI getPoi() {
		return poi;
	}
	
	/**
	 * Sets the poi.
	 *
	 * @param poi the poi to set
	 */
	public void setPoi(POI poi) {
		this.poi = poi;
	}
	
	/**
	 * get the poi warnings.
	 *
	 * @return the poiWarnings
	 */
	public ArrayList<POIWarning> getPoiWarnings() {
		return poiWarnings;
	}
	
	/**
	 * Sets the poi warnings.
	 *
	 * @param poiWarnings the poiWarnings to set
	 */
	public void setPoiWarnings(ArrayList<POIWarning> poiWarnings) {
		this.poiWarnings = poiWarnings;
	}

}
