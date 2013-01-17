package topoos.APIAccess.Results;

import topoos.Exception.TopoosException;
// TODO: Auto-generated Javadoc

/**
 * The Class WebMapURIResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class TrackResourceExportedResult extends APICallResult{

	/** The trackresource. */
	String trackresource=null;
	
	
	
	/**
	 * Instantiates a track resource result.
	 */
	public TrackResourceExportedResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * Instantiates a track resource result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public TrackResourceExportedResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}



	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		this.trackresource=this.Result;
	}



	/**
	 * Gets the trackresource.
	 *
	 * @return the trackresource
	 */
	public String getTrackresource() {
		return trackresource;
	}



	/**
	 * Sets the webmapuri.
	 *
	 * @param trackresource the trackresource to set
	 */
	public void setTrackresource(String trackresource) {
		this.trackresource = trackresource;
	}

	
}
