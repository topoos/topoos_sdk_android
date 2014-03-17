/**
 * Copyright 2014-present topoos
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package topoos.Objects;

import java.io.Serializable;
import java.util.ArrayList;

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