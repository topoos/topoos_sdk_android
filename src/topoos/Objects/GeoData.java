package topoos.Objects;

public class GeoData {

	private Integer id = null;
	private Integer position_id = null;
	private Integer poi_id = null;
	/**
	 * @param id
	 * @param position_id
	 * @param poi_id
	 */
	public GeoData(Integer id, Integer position_id, Integer poi_id) {
		super();
		this.id = id;
		this.position_id = position_id;
		this.poi_id = poi_id;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the position_id
	 */
	public Integer getPosition_id() {
		return position_id;
	}
	/**
	 * @param position_id the position_id to set
	 */
	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}
	/**
	 * @return the poi_id
	 */
	public Integer getPoi_id() {
		return poi_id;
	}
	/**
	 * @param poi_id the poi_id to set
	 */
	public void setPoi_id(Integer poi_id) {
		this.poi_id = poi_id;
	}

	
	
}
