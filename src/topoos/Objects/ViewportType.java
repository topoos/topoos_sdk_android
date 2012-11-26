package topoos.Objects;
/**
 * 
 * @author MAJS
 *
 */
public class ViewportType {
	
	Location southwest=null;
	Location northeast=null;
	/**
	 * @param southwest
	 * @param northeast
	 */
	public ViewportType(Location southwest, Location northeast) {
		super();
		this.southwest = southwest;
		this.northeast = northeast;
	}
	/**
	 * @return the northeast
	 */
	public Location getNortheast() {
		return northeast;
	}
	/**
	 * @param northeast the northeast to set
	 */
	public void setNortheast(Location northeast) {
		this.northeast = northeast;
	}
	/**
	 * @return the southwest
	 */
	public Location getSouthwest() {
		return southwest;
	}
	/**
	 * @param southwest the southwest to set
	 */
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	
	
	
}
