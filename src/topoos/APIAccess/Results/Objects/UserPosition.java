package topoos.APIAccess.Results.Objects;


public class UserPosition {

	private String userid = null;
	private Position position = null;

	/**
	 * @param userid
	 * @param position
	 */
	public UserPosition(String userid, Position position) {
		super();
		this.userid = userid;
		this.position = position;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	public class Position {
		private Double latitude = null;
		private Double longitude = null;
		private Double accuracy = null;

		/**
		 * @param latitude
		 * @param longitude
		 * @param accuracy
		 */
		public Position(Double latitude, Double longitude, Double accuracy) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
			this.accuracy = accuracy;
		}

		/**
		 * @return the latitude
		 */
		public Double getLatitude() {
			return latitude;
		}

		/**
		 * @param latitude
		 *            the latitude to set
		 */
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		/**
		 * @return the longitude
		 */
		public Double getLongitude() {
			return longitude;
		}

		/**
		 * @param longitude
		 *            the longitude to set
		 */
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		/**
		 * @return the accuracy
		 */
		public Double getAccuracy() {
			return accuracy;
		}

		/**
		 * @param accuracy
		 *            the accuracy to set
		 */
		public void setAccuracy(Double accuracy) {
			this.accuracy = accuracy;
		}

	}
}