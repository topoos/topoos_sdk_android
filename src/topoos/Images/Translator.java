package topoos.Images;

import java.io.IOException;
import java.net.URLEncoder;

import android.content.Context;

import topoos.AccessTokenOAuth;
import topoos.APIAccess.APICaller;
import topoos.APIAccess.Operations.ImageUpload;
import topoos.APIAccess.Results.ImageResult;
import topoos.Exception.TopoosException;
import topoos.Objects.Image;

class Translator {

	public static final int SIZE_XXXSMALL = 0;
	public static final int SIZE_XXSMALL = 1;
	public static final int SIZE_XSMALL = 2;
	public static final int SIZE_SMALL = 3;
	public static final int SIZE_LARGE = 4;
	public static final int SIZE_XLARGE = 5;
	public static final int SIZE_XXLARGE = 6;
	public static final int SIZE_XXXLARGE = 7;

	private static String method_post = "POST";
	private static String format = "json";
	private static Integer version = topoos.Constants.APIVERSION;

	
	
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

	public static Image ImageUploadNewPOI(byte[] file, String filename,
		    Double lat, Double lng, String name,
			String description, Integer elevation, Integer accuracy,
			Integer vaccuracy, String address, String cross_street,
			String city, String country, String postal_code, String phone,
			String twitter, Integer[] categories,
			AccessTokenOAuth accessTokenPregenerated) throws IOException,
			TopoosException {
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

	public static Image ImageUploadPosition(Context context, byte[] file,
			String filename, Integer pos_id) throws IOException,
			TopoosException {
		return ImageUploadPosition(file, filename, pos_id,
				AccessTokenOAuth.GetAccessToken(context));
	}

	public static Image ImageUploadPOI(Context context, byte[] file,
			String filename, Integer poi_id) throws IOException,
			TopoosException {
		return ImageUploadPOI(context, file, filename, poi_id);
	}

	public static Image ImageUploadNewPOI(Context context, byte[] file,
			String filename, Double lat, Double lng,
			String name, String description, Integer elevation,
			Integer accuracy, Integer vaccuracy, String address,
			String cross_street, String city, String country,
			String postal_code, String phone, String twitter,
			Integer[] categories) throws IOException, TopoosException {
		return ImageUploadNewPOI(file, filename, lat, lng, name,
				description, elevation, accuracy, vaccuracy, address,
				cross_street, city, country, postal_code, phone, twitter,
				categories, AccessTokenOAuth.GetAccessToken(context));
	}

	public static String GetImageURI(String filename_unique) {
		String uri = APICaller.GetURLPICAPItopoos() + "/" + URLEncoder.encode(filename_unique);
		return uri;
	}

	public static String GetImageURIThumb(String filename_unique, int size) {
		String strsize = "small";
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
		String uri = APICaller.GetURLPICAPItopoos() + "/thumb/"
				+ URLEncoder.encode(filename_unique) + "?size=" + URLEncoder.encode(strsize);
		return uri;
	}

}
