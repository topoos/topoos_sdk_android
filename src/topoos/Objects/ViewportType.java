package topoos.Objects;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a view of the type of port.
 *
 * @author MAJS
 */
public class ViewportType {
	
	/** The southwest. */
	Location southwest=null;
	
	/** The northeast. */
	Location northeast=null;
	
	/**
	 * Instantiates a new viewport type.
	 *
	 * @param southwest the southwest
	 * @param northeast the northeast
	 */
	public ViewportType(Location southwest, Location northeast) {
		super();
		this.southwest = southwest;
		this.northeast = northeast;
	}
	
	/**
	 * get the northeast.
	 *
	 * @return the northeast
	 */
	public Location getNortheast() {
		return northeast;
	}
	
	/**
	 * Sets the northeast.
	 *
	 * @param northeast the northeast to set
	 */
	public void setNortheast(Location northeast) {
		this.northeast = northeast;
	}
	
	/**
	 * get the southwest.
	 *
	 * @return the southwest
	 */
	public Location getSouthwest() {
		return southwest;
	}
	
	/**
	 * Sets the southwest.
	 *
	 * @param southwest the southwest to set
	 */
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	
	
	
}
