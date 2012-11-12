package topoos.APIAccess.Results;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONTokener;


public class UsersNear extends APICallResult {

	private ArrayList<UserPosition> userPositions=null;
	/**
	 * 
	 */
	public UsersNear() {
		super();
	}
	
	/**
	 * 
	 * @param error
	 * @param result
	 */
	public UsersNear(String error, String result) {
		super(error, result);
	}

	/**
	 * @param error
	 * @param result
	 * @param userPositions
	 */
	public UsersNear(String error, String result,
			ArrayList<UserPosition> userPositions) {
		super(error, result);
		this.userPositions = userPositions;
	}

	@Override
	public void setParameters() {
		// Processing result
				try {
					JSONArray jArray = (JSONArray) new JSONTokener(this.Result)
							.nextValue();
					this.userPositions=new ArrayList<UserPosition>();
					for (int i=0;i<jArray.length();i++){
						String user_id=jArray.getJSONObject(i).getString("user_id");
						Double latitude=jArray.getJSONObject(i).getJSONObject("position").getDouble("latitude");
						Double logitude=jArray.getJSONObject(i).getJSONObject("position").getDouble("longitude");
						Double accuracy=jArray.getJSONObject(i).getJSONObject("position").getDouble("accuracy");
						Position position=new Position(latitude,logitude,accuracy);
						this.userPositions.add(new UserPosition(user_id,position));
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
	}

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
		 * @param userid the userid to set
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
		 * @param position the position to set
		 */
		public void setPosition(Position position) {
			this.position = position;
		}
		
		
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
		 * @param latitude the latitude to set
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
		 * @param longitude the longitude to set
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
		 * @param accuracy the accuracy to set
		 */
		public void setAccuracy(Double accuracy) {
			this.accuracy = accuracy;
		}
		
		
	}
	
}

