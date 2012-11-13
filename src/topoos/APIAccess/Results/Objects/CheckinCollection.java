package topoos.APIAccess.Results.Objects;

import java.util.ArrayList;

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
