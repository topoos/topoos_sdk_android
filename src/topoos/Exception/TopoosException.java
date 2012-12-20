package topoos.Exception;

// TODO: Auto-generated Javadoc
/**
 * The Class TopoosException.
 */
public class TopoosException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant NOT_VALID_PARAMS. */
	public static final String NOT_VALID_PARAMS= "Params not valid";
	
	/** The Constant NOT_VALID_TOKEN. */
	public static final String NOT_VALID_TOKEN= "Token not valid";
	
	/** The Constant ERROR400. */
	public static final String ERROR400="Bad request";
	
	/** The Constant ERROR405. */
	public static final String ERROR405="Not Allowed";
	
	/** The Constant ERROR_PARSE. */
	public static final String ERROR_PARSE="Parser Error";
	
	/**
	 * Instantiates a new topoos exception.
	 *
	 * @param msg the msg
	 */
	public TopoosException(String msg) {
		super(msg);
	}

}
