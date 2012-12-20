package topoos.Objects;

import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * The Class Track.
 *
 * @author MAJS
 */
public class Track {

	/** The id. */
	private Integer id=null;
	
	/** The name. */
	private String name=null;
	
	/** The device. */
	private Integer device=null;
	
	/** The positions. */
	private ArrayList<Position> positions=null;
	
	/**
	 * Instantiates a new track.
	 *
	 * @param id the id
	 * @param name the name
	 * @param device the device
	 * @param positions the positions
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
	 * get the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * get the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the device.
	 *
	 * @return the device
	 */
	public Integer getDevice() {
		return device;
	}
	
	/**
	 * Sets the device.
	 *
	 * @param device the device to set
	 */
	public void setDevice(Integer device) {
		this.device = device;
	}
	
	/**
	 * get the positions.
	 *
	 * @return the positions
	 */
	public ArrayList<Position> getPositions() {
		return positions;
	}
	
	/**
	 * Sets the positions.
	 *
	 * @param positions the positions to set
	 */
	public void setPositions(ArrayList<Position> positions) {
		this.positions = positions;
	}
	
	
}
