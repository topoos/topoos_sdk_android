package topoos.Objects;

import java.util.ArrayList;

/**
 * Class that implements a collection of warning of the pois
 * @author FBP
 *
 */
public class POIWarningCollection {

	
	private ArrayList<POIDataWarning> POIWarnings=null;

	/**
	 * @param pOIWarnings
	 */
	public POIWarningCollection(ArrayList<POIDataWarning> pOIWarnings) {
		super();
		POIWarnings = pOIWarnings;
	}

	/**
	 * get the poi warnings
	 * @return the pOIWarnings
	 */
	public ArrayList<POIDataWarning> getPOIWarnings() {
		return POIWarnings;
	}

	/**
	 * @param pOIWarnings the pOIWarnings to set
	 */
	public void setPOIWarnings(ArrayList<POIDataWarning> pOIWarnings) {
		POIWarnings = pOIWarnings;
	}


	
	
	

}
