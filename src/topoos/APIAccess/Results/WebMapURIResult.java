package topoos.APIAccess.Results;

import topoos.Exception.TopoosException;
/**
 * @see APICallResult
 * @author MAJS
 *
 */
public class WebMapURIResult extends APICallResult{

	String webmapuri=null;
	
	
	
	/**
	 * 
	 */
	public WebMapURIResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param error
	 * @param result
	 */
	public WebMapURIResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		this.webmapuri=this.Result;
	}



	/**
	 * @return the webmapuri
	 */
	public String getWebmapuri() {
		return webmapuri;
	}



	/**
	 * @param webmapuri the webmapuri to set
	 */
	public void setWebmapuri(String webmapuri) {
		this.webmapuri = webmapuri;
	}

	
}
