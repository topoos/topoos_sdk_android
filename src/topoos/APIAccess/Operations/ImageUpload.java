package topoos.APIAccess.Operations;

import java.io.IOException;
import java.net.URLEncoder;

import topoos.APIAccess.mime.content.StringBody;
import topoos.APIAccess.mime.content.ByteArrayBody;
import topoos.APIAccess.mime.HttpMultipartMode;
import topoos.APIAccess.mime.MultipartEntity;

public class ImageUpload extends APIOperation {

	public static final Integer TYPE_POI = 0;
	public static final Integer TYPE_POS = 1;

	private String oauth_token = null; // (obligatorio) access_token a los
	// recursos del usuario
	private byte[] file = null; // (obligatorio) Imagen serializada y codificada
								// en Base64.
	private String filename = null;
	private Integer pos_id = null;
	private Integer poi_id = null;
	private Double lat = null; // latitud de la posición en grados decimales.
	private Double lng = null; // longitud de la posición en grados decimales.
	private String name = null; // (obligatorio): nombre del punto de interés.
	private String description = null; // (opcional): descripción del punto de
										// interés.
	private Integer elevation = null; // (opcional): elevación de la posición
										// respecto al nivel del mar, en metros.
	private Integer accuracy = null; // (opcional): precisión de la latitud y
										// lontigud en metros.
	private Integer vaccuracy = null; // (opcional): precisión de la elevación
										// en metros.
	private String address = null; // (opcional): dirección del punto de interés
	private String cross_street = null; // (opcional): transversal a la
										// dirección del punto de interés.
	private String city = null; // (opcional): ciudad del punto de interés
	private String country = null; // (opcional): estado al que pertenece la
									// ciudad
	private String postal_code = null; // (opcional): código postal
	private String phone = null; // (opcional): número de teléfono
	private String twitter = null; // (opcional): identificador de usuario en
									// twitter o hashtag
	private String categories = null; // (obligatorio): identificadores de
										// categorías a las que pertenece el
										// punto de interés, separadas por comas

	/**
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param file
	 * @param filename
	 * @param id
	 * @param type_id
	 */
	public ImageUpload(String operationName, String method, String format,
			Integer version, String oauth_token, byte[] file, String filename,
			Integer id, Integer type_id) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.file = file;
		this.filename = filename;
		if (type_id == TYPE_POI) {
			this.poi_id = id;
		} else if (type_id == TYPE_POS) {
			this.pos_id = id;
		} else {
			this.pos_id = this.poi_id = null;
		}
	}
	

	/**
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param file
	 * @param filename
	 * @param lat
	 * @param lng
	 * @param name
	 * @param description
	 * @param elevation
	 * @param accuracy
	 * @param vaccuracy
	 * @param address
	 * @param cross_street
	 * @param city
	 * @param country
	 * @param postal_code
	 * @param phone
	 * @param twitter
	 * @param categories
	 */
	public ImageUpload(String operationName, String method, String format,
			Integer version, String oauth_token, byte[] file, String filename,
			Double lat, Double lng, String name, String description,
			Integer elevation, Integer accuracy, Integer vaccuracy,
			String address, String cross_street, String city, String country,
			String postal_code, String phone, String twitter, String categories) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.file = file;
		this.filename = filename;
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.description = description;
		this.elevation = elevation;
		this.accuracy = accuracy;
		this.vaccuracy = vaccuracy;
		this.address = address;
		this.cross_street = cross_street;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.phone = phone;
		this.twitter = twitter;
		this.categories = categories;
	}




	/**
	 * validate the params
	 * 
	 * @return Boolean
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && file != null;
		validate = validate && isValid(filename);
		validate = validate
				&& (isValid(APIUtils.toStringInteger(pos_id))
						|| isValid(APIUtils.toStringInteger(poi_id)) || (isValid(APIUtils
						.toStringDouble(lat)) && isValid(APIUtils
						.toStringDouble(lng))));
		validate = validate && isValidorNull(name);
		validate = validate && isValidorNull(description);
		validate = validate
				&& isValidorNull(APIUtils.toStringInteger(elevation));
		validate = validate
				&& isValidorNull(APIUtils.toStringInteger(accuracy));
		validate = validate
				&& isValidorNull(APIUtils.toStringInteger(vaccuracy));
		validate = validate && isValidorNull(address);
		validate = validate && isValidorNull(cross_street);
		validate = validate && isValidorNull(city);
		validate = validate && isValidorNull(country);
		validate = validate && isValidorNull(postal_code);
		validate = validate && isValidorNull(phone);
		validate = validate && isValidorNull(twitter);
		validate = validate && isValidorNull(categories);
		return validate;
	};

	@Override
	public MultipartEntity BodyParams() throws IOException {
		MultipartEntity multipart = null;
		if (this.ValidateParams()) {
			multipart = new MultipartEntity(
					HttpMultipartMode.BROWSER_COMPATIBLE);// ,contentType,Charset.forName("UTF-8"));
			ByteArrayBody bab = new ByteArrayBody(file, filename);
			if (bab != null)
				multipart.addPart("File", bab);
			multipart.addPart("Oauth_token",
					new StringBody(oauth_token));
			if(pos_id!=null){
				multipart.addPart("pos_id",
						new StringBody(APIUtils.toStringInteger(pos_id)));
			}else if(poi_id!=null){
				multipart.addPart("poi_id",
						new StringBody(APIUtils.toStringInteger(poi_id)));
			}else if(lat!=null && lng!=null){
				multipart.addPart(
						"Lat",
						new StringBody(URLEncoder.encode(Double.toString(lat)
								.replace(',', '.'))));
				multipart.addPart(
						"Lng",
						new StringBody(URLEncoder.encode(Double.toString(lng)
								.replace(',', '.'))));
				multipart.addPart("Name",
						new StringBody(APIUtils.toStringUrlEncoded(name)));
				multipart.addPart("Description",
						new StringBody(APIUtils.toStringUrlEncoded(description)));
				multipart.addPart("Elevation",
						new StringBody(APIUtils.toStringInteger(elevation)));
				multipart.addPart("Accuracy",
						new StringBody(APIUtils.toStringInteger(accuracy)));
				multipart.addPart("Vaccuracy",
						new StringBody(APIUtils.toStringInteger(vaccuracy)));
				multipart.addPart("Address",
						new StringBody(APIUtils.toStringUrlEncoded(address)));
				multipart.addPart("Cross_street",
						new StringBody(APIUtils.toStringUrlEncoded(cross_street)));
				multipart.addPart("City",
						new StringBody(APIUtils.toStringUrlEncoded(city)));
				multipart.addPart("Country",
						new StringBody(APIUtils.toStringUrlEncoded(country)));
				multipart.addPart("Postal_code",
						new StringBody(APIUtils.toStringUrlEncoded(postal_code)));
				multipart.addPart("phone",
						new StringBody(APIUtils.toStringUrlEncoded(phone)));
				multipart.addPart("twitter",
						new StringBody(APIUtils.toStringUrlEncoded(twitter)));
				multipart.addPart("categories",
						new StringBody(APIUtils.toStringUrlEncoded(categories)));
			}
		}
		return multipart;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/image/upload";
		}
		return params;
	}

}
