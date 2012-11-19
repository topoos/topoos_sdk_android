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

public class APICaller {

	public static String GetUriOperation(APIOperation operation) {
		return Constants.TOPOOSURI + operation.ConcatParams();
	}

	public static void ExecuteOperation(APIOperation operation,
			APICallResult result) throws IOException {
		HttpClient hc = new DefaultHttpClient();
		String OpURI = Constants.TOPOOSURI + operation.ConcatParams();
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
			result.setError(null);
			result.setParameters();
		} else {
			result.setResult(null);
			result.setError("" + rp.getStatusLine().getStatusCode());
		}
	}

}
