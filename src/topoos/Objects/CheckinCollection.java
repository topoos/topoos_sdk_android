package topoos.Objects;

import java.util.ArrayList;
/**
 * Class that implements a checkingcollection where are saves all check ins
 * @author MAJS
 *
 */
public class CheckinCollection {

	ArrayList<Checkin> CheckIns=null;

	/**
	 * @param checkIns
	 */
	public CheckinCollection(ArrayList<Checkin> checkIns) {
		super();
		CheckIns = checkIns;
	}

	/**
	 * Get the check ins
	 * @return the checkIns
	 */
	public ArrayList<Checkin> getCheckIns() {
		return CheckIns;
	}

	/**
	 * @param checkIns the checkIns to set
	 */
	public void setCheckIns(ArrayList<Checkin> checkIns) {
		CheckIns = checkIns;
	}
	
	
}
