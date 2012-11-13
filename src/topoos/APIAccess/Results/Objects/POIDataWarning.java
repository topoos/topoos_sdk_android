package topoos.APIAccess.Results.Objects;

public class POIDataWarning {
	private POI poi=null;
	private POIDataWarning poiDataWarning=null;
	/**
	 * @param poi
	 * @param poiDataWarning
	 */
	public POIDataWarning(POI poi, POIDataWarning poiDataWarning) {
		super();
		this.poi = poi;
		this.poiDataWarning = poiDataWarning;
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
	 * @return the poiDataWarning
	 */
	public POIDataWarning getPoiDataWarning() {
		return poiDataWarning;
	}
	/**
	 * @param poiDataWarning the poiDataWarning to set
	 */
	public void setPoiDataWarning(POIDataWarning poiDataWarning) {
		this.poiDataWarning = poiDataWarning;
	}
	
	
}
