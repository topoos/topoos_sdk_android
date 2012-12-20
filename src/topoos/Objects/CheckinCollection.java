package topoos.Objects;

import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * Class that implements a checkingcollection where are saves all check ins.
 *
 * @author topoos
 */
public class CheckinCollection {

	/** The Check ins. */
	ArrayList<Checkin> CheckIns=null;

	/**
	 * Instantiates a new checkin collection.
	 *
	 * @param checkIns the check ins
	 */
	public CheckinCollection(ArrayList<Checkin> checkIns) {
		super();
		CheckIns = checkIns;
	}

	/**
	 * Get the check ins.
	 *
	 * @return the checkIns
	 */
	public ArrayList<Checkin> getCheckIns() {
		return CheckIns;
	}

	/**
	 * Sets the check ins.
	 *
	 * @param checkIns the checkIns to set
	 */
	public void setCheckIns(ArrayList<Checkin> checkIns) {
		CheckIns = checkIns;
	}
	
	
}
