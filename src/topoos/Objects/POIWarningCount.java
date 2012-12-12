package topoos.Objects;

public class POIWarningCount{
	Integer closed=null;
	Integer duplicated=null;
	Integer wrongIndicator=null;
	Integer wrongInfo=null;
	/**
	 * @param closed
	 * @param duplicated
	 * @param wrongIndicator
	 * @param wrongInfo
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
	 * get the closed
	 * @return the closed
	 */
	public Integer getClosed() {
		return closed;
	}
	/**
	 * @param closed the closed to set
	 */
	public void setClosed(Integer closed) {
		this.closed = closed;
	}
	/**
	 * get the duplicated
	 * @return the duplicated
	 */
	public Integer getDuplicated() {
		return duplicated;
	}
	/**
	 * @param duplicated the duplicated to set
	 */
	public void setDuplicated(Integer duplicated) {
		this.duplicated = duplicated;
	}
	/**
	 * get the wrong indicator
	 * @return the wrongIndicator
	 */
	public Integer getWrongIndicator() {
		return wrongIndicator;
	}
	/**
	 * @param wrongIndicator the wrongIndicator to set
	 */
	public void setWrongIndicator(Integer wrongIndicator) {
		this.wrongIndicator = wrongIndicator;
	}
	/**
	 * get the wrong info
	 * @return the wrongInfo
	 */
	public Integer getWrongInfo() {
		return wrongInfo;
	}
	/**
	 * @param wrongInfo the wrongInfo to set
	 */
	public void setWrongInfo(Integer wrongInfo) {
		this.wrongInfo = wrongInfo;
	}
	
	
}