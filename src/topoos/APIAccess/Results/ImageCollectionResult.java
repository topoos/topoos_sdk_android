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
package topoos.APIAccess.Results;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import topoos.Constants;
import topoos.Messages;
import topoos.Exception.TopoosException;
import topoos.Objects.GeoData;
import topoos.Objects.Image;
import topoos.Objects.ImageCollection;
import android.util.Log;

public class ImageCollectionResult  extends APICallResult  {
	
	/**The ImageCollection*/
	private ImageCollection imageCollection = null;
	

	/**
	 * Instantiates a new Image collection result.
	 */
	public ImageCollectionResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new Image collection result.
	 * 
	 * @param error the error
	 * @param result the result
	 */
	public ImageCollectionResult(String error, String result) {
		super(error, result);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new Image collection result.
	 * 
	 * @param error the error
	 * @param result the result
	 * @param imageCollection the poicollection
	 */
	public ImageCollectionResult(String error, String result,
			ImageCollection imageCollection) {
		super(error, result);
		this.imageCollection = imageCollection;
	}

	@Override
	public void setParameters() throws TopoosException {
		String id;
		String client_id;
		String user_id;
		String filename;
		String filename_unique;
		String file_ext;
		String uri;
		Date register_date;
		//Geodata BEGIN
		Integer idGeoData;
		Integer position_idGeoData;
		Integer poi_idGeoData;
		GeoData geo_data = null;
		//GeoData END
		if (APIUtils.getcorrectJSONARRAYstring(Result) != null) {
			try {
				JSONArray jArray = (JSONArray) new JSONTokener(
						APIUtils.getcorrectJSONARRAYstring(Result)).nextValue();
				List<Image> imcollec = new ArrayList<Image>();
				for (int i = 0; i < jArray.length(); i++) {
					// Extracting content
					JSONObject jObject = jArray.getJSONObject(i);
					Image image;
					id = APIUtils.getStringorNull(jObject, "id");
					client_id = APIUtils.getStringorNull (jObject, "client_id");
					user_id = APIUtils.getStringorNull (jObject, "user_id");
					filename = APIUtils.getStringorNull (jObject, "filename");
					filename_unique = APIUtils.getStringorNull (jObject, "filename_unique");
					file_ext = APIUtils.getStringorNull (jObject, "file_ext"); 
					uri = APIUtils.getStringorNull (jObject, "uri");  
					register_date = APIUtils.toDateString(jObject
							.getString("register_date"));
					JSONObject jGeoData = jObject.getJSONObject("geo_data");
					if (jGeoData != null)
					{
						idGeoData = APIUtils.getIntegerorNull(jGeoData, "id");
						position_idGeoData = APIUtils.getIntegerorNull(jGeoData, "position_id");
						poi_idGeoData = APIUtils.getIntegerorNull(jGeoData, "poi_id");
						geo_data = new GeoData (idGeoData,poi_idGeoData,poi_idGeoData );
					}
					image = new Image (id, client_id, user_id, filename, filename_unique, file_ext, uri, register_date, geo_data);
					
					imcollec.add(image);
				}
				this.imageCollection = new ImageCollection(imcollec);
			} catch (Exception e) {
				if (Constants.DEBUG) {
					e.printStackTrace();
				}
				throw new TopoosException(TopoosException.ERROR_PARSE);
			}
		} else {
			if (Constants.DEBUG) {
				Log.i(Constants.TAG, Messages.TOPOOS_NORESULT);
			}
		}
		
	}
	
	/**
	 * Gets the imageCollection.
	 * 
	 * @return the imageCollection
	 */
	public ImageCollection getImageCollection() {
		return imageCollection;
	}

	/**
	 * Sets the ImageCollection.
	 * 
	 * @param imageCollection */
	public void setImageCollection(ImageCollection imageCollection) {
		this.imageCollection = imageCollection;
	}

}
