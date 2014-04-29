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
import java.net.URLEncoder;
import java.util.List;

import android.content.Context;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.ImageDelete;
import topoos.APIAccess.Operations.ImageSearch;
import topoos.APIAccess.Operations.ImageUpload;
import topoos.APIAccess.Operations.ImageUpdate;
import topoos.APIAccess.Results.GenericResult;
import topoos.APIAccess.Results.ImageCollectionResult;
import topoos.APIAccess.Results.ImageResult;
import topoos.APIAccess.Results.ImageURIThumb;
import topoos.Exception.TopoosException;
import topoos.Objects.Image;

/**
 * The Class Translator.
 */
class Translator {

	/** The Constant SIZE_XXXSMALL. */
	public static final int SIZE_XXXSMALL = 0;

	/** The Constant SIZE_XXSMALL. */
	public static final int SIZE_XXSMALL = 1;

	/** The Constant SIZE_XSMALL. */
	public static final int SIZE_XSMALL = 2;

	/** The Constant SIZE_SMALL. */
	public static final int SIZE_SMALL = 3;

	/** The Constant SIZE_LARGE. */
	public static final int SIZE_LARGE = 4;

	/** The Constant SIZE_XLARGE. */
	public static final int SIZE_XLARGE = 5;

	/** The Constant SIZE_XXLARGE. */
	public static final int SIZE_XXLARGE = 6;

	/** The Constant SIZE_XXXLARGE. */
	public static final int SIZE_XXXLARGE = 7;
	
	/** The Constant MODE_MAINTAIN*/
	public static final int MODE_MAINTAIN =0;
	
	/** The Constant MODE_FIT*/
	public static final int MODE_FIT =1;

	/** The Constant PRIVACY_PUBLIC. */
	public static final int PRIVACY_PUBLIC = 0;
	/** The Constant PRIVACY_CLIENT. */
	public static final int PRIVACY_CLIENT = 1;
	/** The Constant PRIVACY_USER. */
	public static final int PRIVACY_USER = 2;

	/** The method_post. */
	private static String method_post = "POST";
	
	/** The method_get. */
	private static String method_get = "GET";
	
	/** The format. */
	private static String format = "json";

	/** The version. */
	private static Integer version = topoos.Constants.APIVERSION;

	/**
	 * Image upload.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(byte[] file, String filename,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			ImageUpload imageUpload = new ImageUpload("ImageUpload",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * CVR Image upload.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param String
	 *            (required) privacy
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(byte[] file, String filename,
			AccessTokenOAuth accessTokenPregenerated, int privacy)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {

			String privacystr = "public";
			switch (privacy) {

			case PRIVACY_PUBLIC:
				privacystr = "public";
				break;
			case PRIVACY_CLIENT:
				privacystr = "client";
				break;
			case PRIVACY_USER:
				privacystr = "user";
				break;
			default:
				break;
			}

			ImageUpload imageUpload = new ImageUpload("ImageUpload",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					privacystr);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload position.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param pos_id
	 *            the pos_id
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPosition(byte[] file, String filename,
			Integer pos_id, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			ImageUpload imageUpload = new ImageUpload("ImageUploadPosition",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					pos_id, ImageUpload.TYPE_POS);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload poi.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param poi_id
	 *            the poi_id
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPOI(byte[] file, String filename,
			Integer poi_id, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			ImageUpload imageUpload = new ImageUpload("ImageUploadPOI",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					poi_id, ImageUpload.TYPE_POI);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload new poi.
	 * 
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param elevation
	 *            the elevation
	 * @param accuracy
	 *            the accuracy
	 * @param vaccuracy
	 *            the vaccuracy
	 * @param address
	 *            the address
	 * @param cross_street
	 *            the cross_street
	 * @param city
	 *            the city
	 * @param country
	 *            the country
	 * @param postal_code
	 *            the postal_code
	 * @param phone
	 *            the phone
	 * @param twitter
	 *            the twitter
	 * @param categories
	 *            the categories
	 * @param accessTokenPregenerated
	 *            the access token pregenerated
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadNewPOI(byte[] file, String filename,
			Double lat, Double lng, String name, String description,
			Integer elevation, Integer accuracy, Integer vaccuracy,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			Integer[] categories, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		Image image = null;
		if (accessTokenPregenerated.isValid()) {
			String strcategories = "";
			if (categories != null) {
				for (int i = 0; i < categories.length; i++) {
					if (i < categories.length - 1) {
						strcategories = strcategories + categories[i] + ",";
					} else {
						strcategories = strcategories + categories[i];
					}
				}
			}
			ImageUpload imageUpload = new ImageUpload("ImageUploadNewPOI",
					method_post, format, version,
					accessTokenPregenerated.getAccessToken(), file, filename,
					lat, lng, name, description, elevation, accuracy,
					vaccuracy, address, cross_street, city, country,
					postal_code, phone, twitter, strcategories);
			ImageResult imageResult = new ImageResult();
			APICaller.ExecuteOperation(imageUpload, imageResult,
					APICaller.SERVICE_PIC);
			image = imageResult.getImage();
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return image;
	}

	/**
	 * Image upload.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUpload(Context context, byte[] file,
			String filename) throws IOException, TopoosException {
		return ImageUpload(file, filename,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Image upload position.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param pos_id
	 *            the pos_id
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPosition(Context context, byte[] file,
			String filename, Integer pos_id) throws IOException,
			TopoosException {
		return ImageUploadPosition(file, filename, pos_id,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Image upload poi.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param poi_id
	 *            the poi_id
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadPOI(Context context, byte[] file,
			String filename, Integer poi_id) throws IOException,
			TopoosException {
		return ImageUploadPOI(context, file, filename, poi_id);
	}

	/**
	 * Image upload new poi.
	 * 
	 * @param context
	 *            the context
	 * @param file
	 *            the file
	 * @param filename
	 *            the filename
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param elevation
	 *            the elevation
	 * @param accuracy
	 *            the accuracy
	 * @param vaccuracy
	 *            the vaccuracy
	 * @param address
	 *            the address
	 * @param cross_street
	 *            the cross_street
	 * @param city
	 *            the city
	 * @param country
	 *            the country
	 * @param postal_code
	 *            the postal_code
	 * @param phone
	 *            the phone
	 * @param twitter
	 *            the twitter
	 * @param categories
	 *            the categories
	 * @return the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws TopoosException
	 *             the topoos exception
	 */
	public static Image ImageUploadNewPOI(Context context, byte[] file,
			String filename, Double lat, Double lng, String name,
			String description, Integer elevation, Integer accuracy,
			Integer vaccuracy, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter, Integer[] categories) throws IOException,
			TopoosException {
		return ImageUploadNewPOI(file, filename, lat, lng, name, description,
				elevation, accuracy, vaccuracy, address, cross_street, city,
				country, postal_code, phone, twitter, categories,
				AccessTokenOAuth.GetAccessToken(context));
	}

	/**
	 * Gets the image uri.
	 * 
	 * @param filename_unique
	 *            the filename_unique
	 * @return the string
	 */
	public static String GetImageURI(String filename_unique) {
		String uri = APICaller.GetURLPICAPItopoos() + "/"
				+ URLEncoder.encode(filename_unique);
		return uri;
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
	public static Boolean Delete(AccessTokenOAuth accessTokenPregenerated,
			String fileName) throws IOException, TopoosException {
		boolean delete = false;
		if (accessTokenPregenerated.isValid()) {
			ImageDelete imDel = new ImageDelete ("Delete",method_get, format, version,
					accessTokenPregenerated.getAccessToken(), fileName);
			GenericResult genericResult = new GenericResult();
			APICaller.ExecuteOperation(imDel, genericResult, APICaller.SERVICE_PIC);
			delete = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return delete;
	}
	
	

	/**
	 * Update privacy, and keywords.
	 * 
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @param filename_unique Unique image ID
	 * @param keywords for the image
	 * @param privacy for the image
	 * @return Boolean    
	 * @throws TopoosException 
	 * @throws IOException 
	 *  */
	public static Boolean ImageUpdate(String filename_unique,
				AccessTokenOAuth accessTokenPregenerated, String[] kewywords,
				int privacy) throws TopoosException, IOException {
		Boolean update = false;
		if (accessTokenPregenerated.isValid()) {
			String privacystr = "public";
			switch (privacy) {
			case PRIVACY_PUBLIC:
				privacystr = "public";
				break;
			case PRIVACY_CLIENT:
				privacystr = "client";
				break;
			case PRIVACY_USER:
				privacystr = "user";
				break;
			default:
				break;
			}
			String string_keywords = getKeyWords (kewywords);
			GenericResult genericResult = new GenericResult();
			ImageUpdate imUpd = new ImageUpdate ("ImageUpdate",method_get, format, version,
					accessTokenPregenerated.getAccessToken(),filename_unique,string_keywords,privacystr);
			APICaller.ExecuteOperation(imUpd, genericResult, APICaller.SERVICE_PIC);
			update = genericResult.getCode() == 200;
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		
		return update;
	}


	/**
	 * Build a string of keywords (String) list
	 * */
	private static String getKeyWords (String [] kwrs){
		String string_keywords=  "";
		if (kwrs !=null){
			if (kwrs.length >0){
				for (int i =0; i < kwrs.length ; i++){
					string_keywords += kwrs[i];
					if (i+1 <kwrs.length){
						string_keywords +=",";
					}
				}
			}
		}
		return string_keywords;
	}
	
	/**
	 * Search images
	 * 
	 * @param accessTokenPregenerated 
	 * 			(required) access_token to user resources
	 * @param filename_unique unique identifier image
	 * @param keywords keywords id of image
	 * @param count max number of items that will be returned
	 * @param page result page number. First page is 0. Default 0
	 * @return List <Image> */
	public static List <Image> SearchImage (AccessTokenOAuth accessTokenPregenerated,String filename_unique, String [] keywords, Integer count, Integer page) throws TopoosException, IOException{
		List <Image> imagesFound= null;
		if (accessTokenPregenerated.isValid()) {
			String strctKeywords= getKeyWords (keywords);
			ImageSearch imSearch = new ImageSearch ("ImageSearch", method_get, format, version, accessTokenPregenerated.getAccessToken(),filename_unique, strctKeywords, count, page );
			ImageCollectionResult imColRes= new ImageCollectionResult ();
			APICaller.ExecuteOperation(imSearch, imColRes, APICaller.SERVICE_PIC);
			imagesFound = imColRes.getImageCollection().getImageList();
		}else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return imagesFound;
	}
	
	/**
	 * Gets the image uri with privacy
	 * 
	 * @param filename_unique
	 *            the filename_unique
	 * @param privacy
	 *            the privacy
	 * @return the string
	 */
	public static String GetImageURI(String filename_unique,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
		String uri = null;
		if (accessTokenPregenerated.isValid()) {
			uri = APICaller.GetURLPICAPItopoos()
					+ "/"
					+ URLEncoder.encode(filename_unique)
					+ "?access_token="
					+ URLEncoder.encode(accessTokenPregenerated
							.getAccessToken());
		} else {
			throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
		}
		return uri;
	}
	
	/**
	 * Gets the image uri thumb by size.
	 * 
	 * @param accessTokenPregenerated for the privacy
	 * @param filename_unique
	 *            the filename_unique
	 * @param size
	 *            the size
	 * 
	 * @return the URI
	 * 
	 */
	public static String GetImageURIThumb(AccessTokenOAuth accessTokenPregenerated,String filename_unique, int size, int dpi, int mode) throws TopoosException {
		String strsize = "small";
		String strmode = "maintain";
		if (filename_unique == null || size <0){
			throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		}
		if (accessTokenPregenerated != null){
			if (!accessTokenPregenerated.isValid()){
				throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
			}
		}
		switch (size) {
		case SIZE_LARGE:
			strsize = "large";
			break;
		case SIZE_SMALL:
			strsize = "small";
			break;
		case SIZE_XLARGE:
			strsize = "x-large";
			break;
		case SIZE_XSMALL:
			strsize = "x-small";
			break;
		case SIZE_XXLARGE:
			strsize = "xx-large";
			break;
		case SIZE_XXSMALL:
			strsize = "xx-small";
			break;
		case SIZE_XXXLARGE:
			strsize = "xxx-large";
			break;
		case SIZE_XXXSMALL:
			strsize = "xxx-small";
			break;
		default:
			break;
		}
		switch (mode){
			case MODE_MAINTAIN:
				strmode = "maintain";
				break;
			case MODE_FIT:
				strmode = "fit";
				break;
			default:
				break;
		}
		
		ImageURIThumb imURIThumb = new ImageURIThumb (accessTokenPregenerated.getAccessToken(),filename_unique, strsize, Integer.toString(dpi), strmode);
		imURIThumb.setParameters();
		return imURIThumb.getUriThumb();
	}

	/**
	 * Gets the image uri thumb by width and high.
	 * 
	 * @param accessTokenPregenerated for the privacy
	 * @param filename_unique
	 *            the filename_unique
	 * @param width the width
	 * @param high the high
	 * @return the URI
	 * 
	 */
	public static String GetImageURIThumb(AccessTokenOAuth accessTokenPregenerated,String filename_unique, Integer width, Integer high, int dpi, int mode) throws TopoosException {
		String strmode = "maintain";
		if (filename_unique == null || (width == null && high == null)){
			throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		}else if (width!= null){
			if (width <0) throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		}else if (high != null){
			if (high <0)throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		}
		if (accessTokenPregenerated != null){
			if (!accessTokenPregenerated.isValid()){
				throw new TopoosException(TopoosException.NOT_VALID_TOKEN);
			}
		}
		switch (mode){
			case MODE_MAINTAIN:
				strmode = "maintain";
				break;
			case MODE_FIT:
				strmode = "fit";
				break;
			default:
				break;
		}
		ImageURIThumb imURIThumb = new ImageURIThumb (accessTokenPregenerated.getAccessToken(),filename_unique, Integer.toString(width),Integer.toString(high), Integer.toString(dpi), strmode);
		imURIThumb.setParameters();
		return imURIThumb.getUriThumb();
	}
	
	
}
