package topoos.APIAccess.Results.Objects;

import java.util.ArrayList;

public class Acreditation {
	private String Expirationtime = null;
	private String clientId = null;
	private ArrayList<VisibleDevice> visibledevices = null;

	public Acreditation(String expirationtime, String clientId,
			ArrayList<VisibleDevice> visibledevices) {
		super();
		Expirationtime = expirationtime;
		this.clientId = clientId;
		this.visibledevices = visibledevices;
	}

	public String getExpirationtime() {
		return Expirationtime;
	}

	public void setExpirationtime(String expirationtime) {
		Expirationtime = expirationtime;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public ArrayList<VisibleDevice> getVisibledevices() {
		return visibledevices;
	}

	public void setVisibledevices(ArrayList<VisibleDevice> visibledevices) {
		this.visibledevices = visibledevices;
	}

}