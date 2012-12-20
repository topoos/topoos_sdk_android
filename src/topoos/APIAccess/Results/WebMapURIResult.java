package topoos.APIAccess.Results;

import topoos.Exception.TopoosException;
// TODO: Auto-generated Javadoc

/**
 * The Class WebMapURIResult.
 *
 * @see APICallResult
 * @author topoos
 */
public class WebMapURIResult extends APICallResult{

	/** The webmapuri. */
	String webmapuri=null;
	
	
	
	/**
	 * Instantiates a new web map uri result.
	 */
	public WebMapURIResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * Instantiates a new web map uri result.
	 *
	 * @param error the error
	 * @param result the result
	 */
	public WebMapURIResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}



	/* (non-Javadoc)
	 * @see topoos.APIAccess.Results.APICallResult#setParameters()
	 */
	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		this.webmapuri=this.Result;
	}



	/**
	 * Gets the webmapuri.
	 *
	 * @return the webmapuri
	 */
	public String getWebmapuri() {
		return webmapuri;
	}



	/**
	 * Sets the webmapuri.
	 *
	 * @param webmapuri the webmapuri to set
	 */
	public void setWebmapuri(String webmapuri) {
		this.webmapuri = webmapuri;
	}

	
}
