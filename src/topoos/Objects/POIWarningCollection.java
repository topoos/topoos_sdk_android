package topoos.Objects;

import java.util.ArrayList;


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
