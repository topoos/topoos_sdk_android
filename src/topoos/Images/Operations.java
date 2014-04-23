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

package topoos.Images;

import java.io.IOException;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.Image;
import android.content.Context;

/**
 * 
 * @author topoos
 * 
 *         Operations related to pic image services.
 * 
 */
public class Operations {

	public static final int SIZE_XXXSMALL = Translator.SIZE_XXXSMALL;
	public static final int SIZE_XXSMALL = Translator.SIZE_XXSMALL;
	public static final int SIZE_XSMALL = Translator.SIZE_XSMALL;
	public static final int SIZE_SMALL = Translator.SIZE_SMALL;
	public static final int SIZE_LARGE = Translator.SIZE_LARGE;
	public static final int SIZE_XLARGE = Translator.SIZE_XLARGE;
	public static final int SIZE_XXLARGE = Translator.SIZE_XXLARGE;
	public static final int SIZE_XXXLARGE = Translator.SIZE_XXXLARGE;

	public static final int PRIVACY_PUBLIC = Translator.PRIVACY_PUBLIC;
	public static final int PRIVACY_CLIENT = Translator.PRIVACY_CLIENT;
	public static final int PRIVACY_USER = Translator.PRIVACY_USER;

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUpload(AccessTokenOAuth accessTokenPregenerated,
			byte[] file, String filename) throws IOException, TopoosException {
		return Translator.ImageUpload(file, filename, accessTokenPregenerated);

	}

	/**
	 * CVR Uploading an image to topoos pic services with privacy services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param String
	 *            (required) privacy
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUpload(AccessTokenOAuth accessTokenPregenerated,
			byte[] file, String filename, int privacy) throws IOException,
			TopoosException {
		return Translator.ImageUpload(file, filename, accessTokenPregenerated,
				privacy);

	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param pos_id
	 *            (required) position identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPosition(
			AccessTokenOAuth accessTokenPregenerated, byte[] file,
			String filename, Integer pos_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPosition(file, filename, pos_id,
				accessTokenPregenerated);
	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param poi_id
	 *            (required) point of interest identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPOI(
			AccessTokenOAuth accessTokenPregenerated, byte[] file,
			String filename, Integer poi_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPOI(file, filename, poi_id,
				accessTokenPregenerated);
	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param name
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param description
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadNewPOI(
			AccessTokenOAuth accessTokenPregenerated, byte[] file,
			String filename, Integer pos_id, Double lat, Double lng,
			String name, String description, Integer elevation,
			Integer accuracy, Integer vaccuracy, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			Integer[] categories) throws IOException, TopoosException {
		return Translator.ImageUploadNewPOI(file, filename, lat, lng, name,
				description, elevation, accuracy, vaccuracy, address,
				cross_street, city, country, postal_code, phone, twitter,
				categories, accessTokenPregenerated);
	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUpload(Context context, byte[] file,
			String filename) throws IOException, TopoosException {
		return Translator.ImageUpload(context, file, filename);

	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param pos_id
	 *            (required) position identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPosition(Context context, byte[] file,
			String filename, Integer pos_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPosition(context, file, filename, pos_id);
	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param poi_id
	 *            (required) point of interest identifier
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadPOI(Context context, byte[] file,
			String filename, Integer poi_id) throws IOException,
			TopoosException {
		return Translator.ImageUploadPOI(context, file, filename, poi_id);
	}

	/**
	 * Uploading an image to topoos pic services
	 * 
	 * @param context
	 *            (required) Interface to global information about an
	 *            application environment
	 * @param file
	 *            (required) image
	 * @param filename
	 *            (required) image name
	 * @param name
	 *            (required) access_token to user resources
	 * @param lat
	 *            (required) latitude of the new position
	 * @param lng
	 *            (required) longitude of the new position.
	 * @param categories
	 *            (required) identifiers for the categories to which the POI
	 *            belongs
	 * @param accuracy
	 *            (optional) accuracy of the position (latitude, longitude)
	 * @param vaccuracy
	 *            (optional) elevation accuracy
	 * @param elevation
	 *            (optional) elevation relative to sea level
	 * @param description
	 *            (optional) description of the landmark
	 * @param address
	 *            (optional) direction of the point of interest
	 * @param cross_street
	 *            (optional) cross street
	 * @param city
	 *            (optional) city landmark
	 * @param country
	 *            (optional) country
	 * @param postal_code
	 *            (optional) postal code
	 * @param phone
	 *            (optional) Contact phone
	 * @param twitter
	 *            (optional) user ID or hashtag of Twitter
	 * @return Image
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Image ImageUploadNewPOI(Context context, byte[] file,
			String filename, Double lat, Double lng, String name,
			String description, Integer elevation, Integer accuracy,
			Integer vaccuracy, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter, Integer[] categories) throws IOException,
			TopoosException {
		return Translator.ImageUploadNewPOI(context, file, filename, lat, lng,
				name, description, elevation, accuracy, vaccuracy, address,
				cross_street, city, country, postal_code, phone, twitter,
				categories);
	}

	/**
	 * Get uri of image
	 * 
	 * @param filename_unique
	 *            Unique image ID
	 * @return String
	 */
	public static String GetImageURI(String filename_unique) {
		return Translator.GetImageURI(filename_unique);
	}

	/**
	 * Get uri of image with a specific size
	 * 
	 * @param filename_unique
	 *            Unique image ID
	 * @param size
	 *            Image size
	 * @return String
	 */
	public static String GetImageURIThumb(String filename_unique, int size) {
		return Translator.GetImageURIThumb(filename_unique, size);
	}
	
	

	/**
	 * Get uri of image with privacy param
	 * 
	 * @param filename_unique
	 *            Unique image ID
	 * @param privacy
	 *            the privacy
	 * @return String
	 */
	public static String GetImageURI(String filename_unique,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.GetImageURI(filename_unique, accessTokenPregenerated);
	}

	/**
	 * Get uri of image with a specific size
	 * 
	 * @param filename_unique
	 *            Unique image ID
	 * @param size
	 *            Image size
	 * @param privacy
	 *            the privacy
	 * @return String
	 */
	public static String GetImageURIThumb(String filename_unique, int size,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		return Translator.GetImageURIThumb(filename_unique, size,
				accessTokenPregenerated);
	}

	/**
	 * Delete image from PIC service permanently.
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param filename_unique Unique image ID
	 * @return Boolean    
	 * @throws TopoosException 
	 * @throws IOException 
	 *  */
	public static Boolean Delete (AccessTokenOAuth accessTokenPregenerated, String fileName) throws IOException, TopoosException{
		return Translator.Delete (accessTokenPregenerated, fileName);
		
	}
}
