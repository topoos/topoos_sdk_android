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

import android.util.Log;
import topoos.Constants;
import topoos.APIAccess.Operations.APIOperation;
import topoos.APIAccess.Results.APICallResult;
import topoos.Exception.TopoosException;

public class APICaller {

	public static String GetUriOperation(APIOperation operation) {
		return Constants.TOPOOSURIAPI + operation.ConcatParams();
	}

	public static void ExecuteOperation(APIOperation operation,
			APICallResult result) throws IOException, TopoosException {
		HttpClient hc = new DefaultHttpClient();
		if(!operation.ValidateParams())
			throw new TopoosException(TopoosException.NOT_VALID_PARAMS);
		String OpURI = Constants.TOPOOSURIAPI + operation.ConcatParams();
		if (Constants.DEBUG)
			Log.d(Constants.TAG, OpURI);
		HttpPost post = new HttpPost(OpURI);

		HttpResponse rp = hc.execute(post);

		HttpParams httpParams = hc.getParams();
		HttpConnectionParams.setConnectionTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		HttpConnectionParams.setSoTimeout(httpParams,
				Constants.HTTP_WAITING_MILISECONDS);
		if (rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result.setResult(EntityUtils.toString(rp.getEntity()));
			if (Constants.DEBUG)
				Log.d(Constants.TAG, result.getResult());
			result.setError(null);
			result.setParameters();
		} else {
			switch (rp.getStatusLine().getStatusCode()) {
			case 400:
				throw new TopoosException(TopoosException.ERROR400);
			default:
				throw new TopoosException("¿Error?");
			}
			
		}
	}

}
