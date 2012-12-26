package topoos.Objects;

import java.io.Serializable;
import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * Class that implement.
 *
 * @author topoos
 */
public class Acreditation implements Serializable{
	
	/**
	 * V0
	 */
	private static final long serialVersionUID = 1L;

	/** The Expirationtime. */
	private String Expirationtime = null;
	
	/** The client id. */
	private String clientId = null;
	
	/** The visibledevices. */
	private ArrayList<VisibleDevice> visibledevices = null;

	/**
	 * Instantiates a new acreditation.
	 *
	 * @param expirationtime the expirationtime
	 * @param clientId the client id
	 * @param visibledevices the visibledevices
	 */
	public Acreditation(String expirationtime, String clientId,
			ArrayList<VisibleDevice> visibledevices) {
		super();
		Expirationtime = expirationtime;
		this.clientId = clientId;
		this.visibledevices = visibledevices;
	}

	/**
	 * Gets the expirationtime.
	 *
	 * @return the expirationtime
	 */
	public String getExpirationtime() {
		return Expirationtime;
	}

	/**
	 * Sets the expirationtime.
	 *
	 * @param expirationtime the new expirationtime
	 */
	public void setExpirationtime(String expirationtime) {
		Expirationtime = expirationtime;
	}

	/**
	 * Gets the client id.
	 *
	 * @return the client id
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Sets the client id.
	 *
	 * @param clientId the new client id
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Gets the visibledevices.
	 *
	 * @return the visibledevices
	 */
	public ArrayList<VisibleDevice> getVisibledevices() {
		return visibledevices;
	}

	/**
	 * Sets the visibledevices.
	 *
	 * @param visibledevices the new visibledevices
	 */
	public void setVisibledevices(ArrayList<VisibleDevice> visibledevices) {
		this.visibledevices = visibledevices;
	}

}