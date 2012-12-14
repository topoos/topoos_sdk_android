package topoos.APIAccess.Results;

import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Exception.TopoosException;
import topoos.Objects.GeoData;
import topoos.Objects.Image;

public class ImageResult extends APICallResult {
	private Image image = null;

	/**
	 * 
	 */
	public ImageResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 */
	public ImageResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param result
	 * @param image
	 */
	public ImageResult(String error, String result, Image image) {
		super(error, result);
		this.image = image;
	}

	@Override
	public void setParameters() throws TopoosException {
		// TODO Auto-generated method stub
		try {
			JSONObject jObject = (JSONObject) new JSONTokener(this.Result)
					.nextValue();
			// Extracting content
			this.image = new Image(jObject.getString("id"),
					jObject.getString("client_id"),
					jObject.getString("user_id"),
					jObject.getString("filename"),
					jObject.getString("filename_unique"),
					jObject.getString("file_ext"), jObject.getString("uri"),
					APIUtils.toDateString(jObject.getString("register_date")),
					new GeoData(jObject.getJSONObject("geo_data").getInt("id"),
							jObject.getJSONObject("geo_data").getInt(
									"position_id"), jObject.getJSONObject(
									"geo_data").getInt("poi_id")));
		} catch (Exception e) {
			if (Constants.DEBUG) {
				e.printStackTrace();
			}
			throw new TopoosException(TopoosException.ERROR_PARSE);
		}
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

}
