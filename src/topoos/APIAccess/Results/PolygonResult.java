package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import topoos.Constants;
import topoos.APIAccess.Results.Objects.Location;
import topoos.Exception.TopoosException;


public class PolygonResult extends APICallResult{
	List<Location> polygon=null;
	
	/**
	 * 
	 */
	public PolygonResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public PolygonResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param polygon
	 */
	public PolygonResult(String error, String result, List<Location> polygon) {
		super(error, result);
		this.polygon = polygon;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		/* Get a SAXParser from the SAXPArserFactory. */
		if (this.Result != null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			try {
				polygon= new ArrayList<Location>();
				db = dbf.newDocumentBuilder();
				Document doc = db.parse(this.Result);
				NodeList nodelist = doc.getElementsByTagName("coordinates");
				if (nodelist != null) {
					Node node = nodelist.item(0);
					String coordinates=node.getNodeValue();
					String[] coordinatesList=coordinates.split("\n");
					for (String pos:coordinatesList){
						Double lat=Double.valueOf(pos.split(",")[0]);
						Double lng=Double.valueOf(pos.split(",")[1]);
						polygon.add(new Location(lat,lng));
					}
				}
			} catch (Exception e) {
				if (Constants.DEBUG){
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		}

	}

	/**
	 * @return the polygon
	 */
	public List<Location> getPolygon() {
		return polygon;
	}

	/**
	 * @param polygon the polygon to set
	 */
	public void setPolygon(List<Location> polygon) {
		this.polygon = polygon;
	}
	
	
	
}
