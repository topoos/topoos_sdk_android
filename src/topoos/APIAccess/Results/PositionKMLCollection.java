package topoos.APIAccess.Results;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import topoos.APIAccess.APICaller;

public class PositionKMLCollection extends APICallResult {

	String name = null;
	String description = null;
	ArrayList<PositionKML> Placemarks = null;

	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		if (this.Result != null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			try {
				db = dbf.newDocumentBuilder();
				Document doc = db.parse(this.Result);
				NodeList nodes = doc.getElementsByTagName("Document");
				for (int i = 0; i < nodes.getLength(); i++) {
					if (nodes.item(i).getNodeName().toLowerCase()
							.equals("name".toLowerCase())) {
						this.name = nodes.item(i).getNodeValue();
					} else if (nodes.item(i).getNodeName().toLowerCase()
							.equals("description".toLowerCase())) {
						this.description = nodes.item(i).getNodeValue();
					}
				}
				NodeList placemarks = doc.getElementsByTagName("Placemark");
				if (placemarks != null) {
					for (int p = 0; p < placemarks.getLength(); p++) {
						Node node = placemarks.item(p);
						NodeList childnodes = node.getChildNodes();
						String name= null;
						String description= null;
						Date timestamp = null;
						Point point= null;
						ExtendedData extendedData= null;
						for (int i = 0; i < childnodes.getLength(); i++) {
							if (childnodes.item(i).getNodeName().toLowerCase()
									.equals("TimeStamp".toLowerCase())) {
								timestamp = APIUtils
										.toDateString(childnodes.item(i)
												.getFirstChild().getNodeValue());
							} else if (childnodes.item(i).getNodeName()
									.toLowerCase().equals("name".toLowerCase())) {
								name = childnodes.item(i).getNodeValue();
							} else if (childnodes.item(i).getNodeName()
									.toLowerCase()
									.equals("description".toLowerCase())) {
								description = childnodes.item(i)
										.getNodeValue();
							} else if (childnodes.item(i).getNodeName()
									.toLowerCase()
									.equals("Point".toLowerCase())) {
								String value = childnodes.item(i)
										.getFirstChild().getNodeValue();
								String[] values = value.split(",");
								point = new Point(
										Double.valueOf(values[0]),
										Double.valueOf(values[1]), 4);
							} else if (childnodes.item(i).getNodeName()
									.toLowerCase()
									.equals("ExtendedData".toLowerCase())) {
								NodeList childnodes2 = childnodes.item(i)
										.getChildNodes();
								String id = null;
								String device = null;
								Date registerTime = null;
								Double accuracy = null;
								PositionType positionType = null;
								Double elevation = null;
								Double vaccuracy = null;
								Double bearing = null;
								Double velocity = null;
								for (int j = 0; j < childnodes2.getLength(); j++) {
									if (childnodes.item(j).getNodeName()
											.toLowerCase()
											.equals("id".toLowerCase())) {
										id = childnodes.item(j).getNodeValue();
									} else if (childnodes.item(j).getNodeName()
											.toLowerCase()
											.equals("device".toLowerCase())) {
										device = childnodes.item(j)
												.getNodeValue();
									} else if (childnodes
											.item(j)
											.getNodeName()
											.toLowerCase()
											.equals("RegisterTime"
													.toLowerCase())) {
										registerTime = APIUtils
												.toDateString(childnodes
														.item(j).getNodeValue());
									} else if (childnodes.item(j).getNodeName()
											.toLowerCase()
											.equals("Accuracy".toLowerCase())) {
										accuracy = Double.valueOf(childnodes
												.item(j).getNodeValue());
									} else if (childnodes
											.item(j)
											.getNodeName()
											.toLowerCase()
											.equals("PositionType"
													.toLowerCase())) {
										NodeList childnodes3 = childnodes.item(
												j).getChildNodes();
										String idtype = null;
										String destype = null;
										for (int k = 0; k < childnodes3
												.getLength(); k++) {
											if (childnodes.item(k)
													.getNodeName()
													.toLowerCase()
													.equals("id".toLowerCase())) {
												idtype = childnodes.item(k)
														.getNodeValue();
											} else if (childnodes
													.item(k)
													.getNodeName()
													.toLowerCase()
													.equals("description"
															.toLowerCase())) {
												destype = childnodes.item(k)
														.getNodeValue();
											}
										}
										positionType = new PositionType(idtype,
												destype);
									} else if (childnodes.item(j).getNodeName()
											.toLowerCase()
											.equals("elevation".toLowerCase())) {
										elevation = Double.valueOf(childnodes
												.item(j).getNodeValue());
									} else if (childnodes.item(j).getNodeName()
											.toLowerCase()
											.equals("Vaccuracy".toLowerCase())) {
										vaccuracy = Double.valueOf(childnodes
												.item(j).getNodeValue());
									} else if (childnodes.item(j).getNodeName()
											.toLowerCase()
											.equals("Bearing".toLowerCase())) {
										bearing = Double.valueOf(childnodes
												.item(j).getNodeValue());
									} else if (childnodes.item(j).getNodeName()
											.toLowerCase()
											.equals("Velocity".toLowerCase())) {
										velocity = Double.valueOf(childnodes
												.item(j).getNodeValue());
									}

									extendedData = new ExtendedData(id,
											device, registerTime, accuracy,
											positionType, elevation, vaccuracy,
											bearing, velocity);
								}
							}
						}
						PositionKML position=new PositionKML(timestamp,
								name, description, point,
								extendedData);
						
						
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
	
	public class PositionKML {

		Date timestamp = null;
		String name = null;
		String description = null;
		Point point = null;
		ExtendedData extendedData = null;

		/**
		 * @param error
		 * @param result
		 * @param timestamp
		 * @param name
		 * @param description
		 * @param point
		 * @param extendedData
		 */
		public PositionKML(Date timestamp,
				String name, String description, Point point,
				ExtendedData extendedData) {
			this.timestamp = timestamp;
			this.name = name;
			this.description = description;
			this.point = point;
			this.extendedData = extendedData;
		}


		/**
		 * @return the timestamp
		 */
		public Date getTimestamp() {
			return timestamp;
		}

		/**
		 * @param timestamp
		 *            the timestamp to set
		 */
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the point
		 */
		public Point getPoint() {
			return point;
		}

		/**
		 * @param point
		 *            the point to set
		 */
		public void setPoint(Point point) {
			this.point = point;
		}

		/**
		 * @return the extendedData
		 */
		public ExtendedData getExtendedData() {
			return extendedData;
		}

		/**
		 * @param extendedData
		 *            the extendedData to set
		 */
		public void setExtendedData(ExtendedData extendedData) {
			this.extendedData = extendedData;
		}



	}
	public class Point {
		Double latitude = null;
		Double longitude = null;
		Integer value = 4;

		/**
		 * @param latitude
		 * @param longitude
		 * @param value
		 */
		public Point(Double latitude, Double longitude, Integer value) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
			this.value = value;
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
		 * @return the value
		 */
		public Integer getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(Integer value) {
			this.value = value;
		}

	}

	public class PositionType {
		String id = null;
		String description = null;

		/**
		 * @param id
		 * @param description
		 */
		public PositionType(String id, String description) {
			super();
			this.id = id;
			this.description = description;
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

	}
	
	public class ExtendedData {
		String id = null;
		String device = null;
		Date registerTime = null;
		Double accuracy = null;
		PositionType positionType = null;
		Double elevation = null;
		Double vaccuracy = null;
		Double bearing = null;
		Double velocity = null;

		/**
		 * @param id
		 * @param device
		 * @param registerTime
		 * @param accuracy
		 * @param positionType
		 * @param elevation
		 * @param vaccuracy
		 * @param bearing
		 * @param velocity
		 */
		public ExtendedData(String id, String device, Date registerTime,
				Double accuracy, PositionType positionType, Double elevation,
				Double vaccuracy, Double bearing, Double velocity) {
			super();
			this.id = id;
			this.device = device;
			this.registerTime = registerTime;
			this.accuracy = accuracy;
			this.positionType = positionType;
			this.elevation = elevation;
			this.vaccuracy = vaccuracy;
			this.bearing = bearing;
			this.velocity = velocity;
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the device
		 */
		public String getDevice() {
			return device;
		}

		/**
		 * @param device
		 *            the device to set
		 */
		public void setDevice(String device) {
			this.device = device;
		}

		/**
		 * @return the registerTime
		 */
		public Date getRegisterTime() {
			return registerTime;
		}

		/**
		 * @param registerTime
		 *            the registerTime to set
		 */
		public void setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
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

		/**
		 * @return the positionType
		 */
		public PositionType getPositionType() {
			return positionType;
		}

		/**
		 * @param positionType
		 *            the positionType to set
		 */
		public void setPositionType(PositionType positionType) {
			this.positionType = positionType;
		}

		/**
		 * @return the elevation
		 */
		public Double getElevation() {
			return elevation;
		}

		/**
		 * @param elevation
		 *            the elevation to set
		 */
		public void setElevation(Double elevation) {
			this.elevation = elevation;
		}

		/**
		 * @return the vaccuracy
		 */
		public Double getVaccuracy() {
			return vaccuracy;
		}

		/**
		 * @param vaccuracy
		 *            the vaccuracy to set
		 */
		public void setVaccuracy(Double vaccuracy) {
			this.vaccuracy = vaccuracy;
		}

		/**
		 * @return the bearing
		 */
		public Double getBearing() {
			return bearing;
		}

		/**
		 * @param bearing
		 *            the bearing to set
		 */
		public void setBearing(Double bearing) {
			this.bearing = bearing;
		}

		/**
		 * @return the velocity
		 */
		public Double getVelocity() {
			return velocity;
		}

		/**
		 * @param velocity
		 *            the velocity to set
		 */
		public void setVelocity(Double velocity) {
			this.velocity = velocity;
		}

	}


}
