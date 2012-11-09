package topoos.APIAccess.Operations;

import java.util.Date;

/**
 * Obtiene información de un Track
 * @author MAJS
 *
 */

public class TracksGet extends APIOperation{

	public static final String LAYER_DEFAULT="default";
	public static final String LAYER_BEARING="bearing";
	public static final String LAYER_TRACKLINE="trackline";
	
	private String  oauth_token=null; // (obligatorio) access_token a los recursos del usuario
	private String  	track=null; // (obligatorio) identificador del Track solicitado
	private Integer  	total=null; // (opcional) si se especifica un valor N, se obtendrán las últimas N posiciones del Track
	private Date initdate=null;
	private Date endate=null;
	//: (opcional) fechas en formato UTC que permiten filtrar posiciones registradas dentro del rango especificado, según el estándar ISO 8601. No se incluyen las posiciones registradas en la fecha indicada.
	private String[]  	layer=null; // :(opcional) capas KML solicitadas, separadas por comas
		//default (valor por defecto) marcadores de posición
	  	//bearing flechas de rumbo
	 	//trackline  línea de trayectoria

	public TracksGet(String operationName, String method, String format,
			Integer version, String oauth_token, String track, Integer total,
			Date initdate, Date endate, String[] layer) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.track = track;
		this.total = total;
		this.initdate = initdate;
		this.endate = endate;
		this.layer = layer;
	}



	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(track);
		validate = validate && isValid(oauth_token);
		validate = validate && isValidorNull(APIUtils.toStringDate(initdate));
		validate = validate && isValidorNull(APIUtils.toStringDate(endate));
		validate = validate && isValidorNull(APIUtils.toStringInteger(total));
		for(int i=0; i<layer.length;i++){
			validate = validate && isValidorNull(layer[i]);
		}
		return validate;
	}

	@Override
	public String ConcatParams() {
		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/tracks/get."
					+ this.Format 
					+ "?oauth_token=" + this.oauth_token
					+ "?track=" + this.track
					+(total == null? "" : "&total="+APIUtils.toStringInteger(total))
					+(initdate == null? "" : "&initdate="+APIUtils.toStringDate(initdate))
					+(endate == null? "" : "&endate="+APIUtils.toStringDate(endate));
					if(layer!=null)
						params=params+"&layer=";
					for(int i=0; i<layer.length;i++){
						if(i==0){
							params=params+layer[i];
						}else{
							params=","+params+layer[i];
						}
					}
					;

		}
		return params;
	}

}
