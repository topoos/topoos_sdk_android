package topoos.APIAccess;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import topoos.Constants;
import topoos.APIAccess.Operations.APIOperation;
import topoos.APIAccess.Results.APICallResult;
import topoos.Exception.TopoosException;
import android.util.Log;

/**
 * Class that implements http call to topoos api
 * 
 * @author topoos
 * 
 */
public class APICaller {

	public static final int SERVICE_API = 0;
	public static final int SERVICE_LOGIN = 1;
	public static final int SERVICE_PIC = 2;

	/**
	 * Returns the url for the object operation.
	 * 
	 * @param operation
	 * @return URL
	 */
	public static String GetUriAPIOperation(APIOperation operation) {
		return Constants.TOPOOSURIAPI + operation.ConcatParams();
	}

	/**
	 * Returns the url for topoos api service
	 * 
	 * @return URL
	 */
	public static String GetURLAPItopoos() {
		return Constants.TOPOOSURIAPI;
	}

	/**
	 * Returns the url for topoos pic service
	 * 
	 * @return String
	 */
	public static String GetURLPICAPItopoos() {
		return Constants.TOPOOSURIPIC;
	}

	/**
	 * Initiates an operation on topoos API.
	 * 
	 * @param operation
	 *            Represents the operation to be executed
	 * @param result
	 *            Represents a result returned from a query to API topoos
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static void ExecuteOperation(APIOperation operation,
			APICallResult result) throws IOException, TopoosException {
		HttpClient hc = new DefaultHttpClient();
		if (!operation.ValidateParams())
			throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		String OpURI = Constants.TOPOOSURIAPI + operation.ConcatParams();
		if (Constants.DEBUGURL) {
			Log.d(Constants.TAG, OpURI);
//			appendLog(OpURI);
		}
		HttpPost post = new HttpPost(OpURI);
		// POST
		if (operation.getMethod().equals("POST")) {
			post.setEntity(operation.BodyParams());
		}
		HttpResponse rp = hc.execute(post);
		HttpParams httpParams = hc.getParams();
		HttpConnectionParams.setConnectionTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		HttpConnectionParams.setSoTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result.setResult(EntityUtils.toString(rp.getEntity()));
			if (Constants.DEBUGURL) {
				Log.d(Constants.TAG, result.getResult());
//				appendLog(result.getResult());
			}
			result.setError(null);
			result.setParameters();
		} else {
			switch (rp.getStatusLine().getStatusCode()) {
			case 400:
				throw new TopoosException(TopoosException.ERROR400);
			case 405:
				throw new TopoosException(TopoosException.ERROR405);
			default:
				throw new TopoosException("Error: "
						+ rp.getStatusLine().getStatusCode() + "");
			}

		}
	}

	/**
	 * Initiates an operation on topoos API.
	 * 
	 * @param operation
	 *            Represents the operation to be executed
	 * @param result
	 *            Represents a result returned from a query to API topoos
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static void ExecuteOperation(APIOperation operation,
			APICallResult result, Integer service) throws IOException,
			TopoosException {
		HttpClient hc = new DefaultHttpClient();
		if (!operation.ValidateParams())
			throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		String OpURI = "";
		switch (service) {
		case SERVICE_API:
			OpURI = GetURLAPItopoos() + operation.ConcatParams();
			break;
		case SERVICE_PIC:
			OpURI = GetURLPICAPItopoos() + operation.ConcatParams();
			break;
		default:
			OpURI = GetURLAPItopoos() + operation.ConcatParams();
			break;
		}
		if (Constants.DEBUGURL) {
			Log.d(Constants.TAG, OpURI);
//			appendLog(OpURI);
		}
		HttpPost post = new HttpPost(OpURI);
		// POST
		if (operation.getMethod().equals("POST")) {
			post.setEntity(operation.BodyParams());
		}
		HttpResponse rp = hc.execute(post);
		HttpParams httpParams = hc.getParams();
		HttpConnectionParams.setConnectionTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		HttpConnectionParams.setSoTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result.setResult(EntityUtils.toString(rp.getEntity()));
			if (Constants.DEBUGURL) {
				Log.d(Constants.TAG, result.getResult());
//				appendLog(result.getResult());
			}
			result.setError(null);
			result.setParameters();
		} else {
			switch (rp.getStatusLine().getStatusCode()) {
			case 400:
				throw new TopoosException(TopoosException.ERROR400);
			case 405:
				throw new TopoosException(TopoosException.ERROR405);
			default:
				throw new TopoosException("Error: "
						+ rp.getStatusLine().getStatusCode() + "");
			}

		}
	}

//	private static void appendLog(String text) {
//		try {
//			File logFile = new File(Environment.getExternalStorageDirectory(),
//					"logoperations.txt");
//			if (!logFile.exists()) {
//				logFile.createNewFile();
//			}
//
//			BufferedWriter buf = new BufferedWriter(new FileWriter(logFile,
//					true));
//			buf.append(text);
//			buf.newLine();
//			buf.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
