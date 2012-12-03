package topoos.Objects;

import java.util.ArrayList;
/**
 * 
 * @author MAJS
 *
 */
public class Track {

	private Integer id=null;
	private String name=null;
	private Integer device=null;
	private ArrayList<Position> positions=null;
	/**
	 * @param id
	 * @param name
	 * @param device
	 * @param positions
	 */
	public Track(Integer id, String name, Integer device,
			ArrayList<Position> positions) {
		super();
		this.id = id;
		this.name = name;
		this.device = device;
		this.positions = positions;
	}
	/**
	 * get the id
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
	 * get the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get the device
	 * @return the device
	 */
	public Integer getDevice() {
		return device;
	}
	/**
	 * @param device the device to set
	 */
	public void setDevice(Integer device) {
		this.device = device;
	}
	/**
	 * get the positions
	 * @return the positions
	 */
	public ArrayList<Position> getPositions() {
		return positions;
	}
	/**
	 * @param positions the positions to set
	 */
	public void setPositions(ArrayList<Position> positions) {
		this.positions = positions;
	}
	
	
}
