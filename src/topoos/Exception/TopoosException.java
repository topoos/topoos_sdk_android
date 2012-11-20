package topoos.Exception;

public class TopoosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOT_VALID_PARAMS= "Params not valid";
	public static final String NOT_VALID_TOKEN= "Token not valid";
	
	public static final String ERROR400="bad request";
	
	public TopoosException(String msg) {
		super(msg);
	}

}
