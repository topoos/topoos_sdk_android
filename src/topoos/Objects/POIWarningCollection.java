package topoos.Objects;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Class that implements a collection of warning of the pois.
 *
 * @author FBP
 */
public class POIWarningCollection {

	
	/** The POI warnings. */
	private ArrayList<POIDataWarning> POIWarnings=null;

	/**
	 * Instantiates a new pOI warning collection.
	 *
	 * @param pOIWarnings the oI warnings
	 */
	public POIWarningCollection(ArrayList<POIDataWarning> pOIWarnings) {
		super();
		POIWarnings = pOIWarnings;
	}

	/**
	 * get the poi warnings.
	 *
	 * @return the pOIWarnings
	 */
	public ArrayList<POIDataWarning> getPOIWarnings() {
		return POIWarnings;
	}

	/**
	 * Sets the pOI warnings.
	 *
	 * @param pOIWarnings the pOIWarnings to set
	 */
	public void setPOIWarnings(ArrayList<POIDataWarning> pOIWarnings) {
		POIWarnings = pOIWarnings;
	}


	
	
	

}
