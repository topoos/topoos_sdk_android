package topoos.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class POIWarningCount.
 */
public class POIWarningCount{
	
	/** The closed. */
	Integer closed=null;
	
	/** The duplicated. */
	Integer duplicated=null;
	
	/** The wrong indicator. */
	Integer wrongIndicator=null;
	
	/** The wrong info. */
	Integer wrongInfo=null;
	
	/**
	 * Instantiates a new pOI warning count.
	 *
	 * @param closed the closed
	 * @param duplicated the duplicated
	 * @param wrongIndicator the wrong indicator
	 * @param wrongInfo the wrong info
	 */
	public POIWarningCount(Integer closed, Integer duplicated,
			Integer wrongIndicator, Integer wrongInfo) {
		super();
		this.closed = closed;
		this.duplicated = duplicated;
		this.wrongIndicator = wrongIndicator;
		this.wrongInfo = wrongInfo;
	}
	
	/**
	 * get the closed.
	 *
	 * @return the closed
	 */
	public Integer getClosed() {
		return closed;
	}
	
	/**
	 * Sets the closed.
	 *
	 * @param closed the closed to set
	 */
	public void setClosed(Integer closed) {
		this.closed = closed;
	}
	
	/**
	 * get the duplicated.
	 *
	 * @return the duplicated
	 */
	public Integer getDuplicated() {
		return duplicated;
	}
	
	/**
	 * Sets the duplicated.
	 *
	 * @param duplicated the duplicated to set
	 */
	public void setDuplicated(Integer duplicated) {
		this.duplicated = duplicated;
	}
	
	/**
	 * get the wrong indicator.
	 *
	 * @return the wrongIndicator
	 */
	public Integer getWrongIndicator() {
		return wrongIndicator;
	}
	
	/**
	 * Sets the wrong indicator.
	 *
	 * @param wrongIndicator the wrongIndicator to set
	 */
	public void setWrongIndicator(Integer wrongIndicator) {
		this.wrongIndicator = wrongIndicator;
	}
	
	/**
	 * get the wrong info.
	 *
	 * @return the wrongInfo
	 */
	public Integer getWrongInfo() {
		return wrongInfo;
	}
	
	/**
	 * Sets the wrong info.
	 *
	 * @param wrongInfo the wrongInfo to set
	 */
	public void setWrongInfo(Integer wrongInfo) {
		this.wrongInfo = wrongInfo;
	}
	
	
}