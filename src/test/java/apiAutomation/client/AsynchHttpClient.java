package apiAutomation.client;//package apiAutomation.client;


import org.apache.hc.core5.http.ParseException;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class AsynchHttpClient {

    public Response get(String url) throws IOException, ParseException, InterruptedException, ExecutionException {


        AsyncHttpClient client = new DefaultAsyncHttpClient();
        Response r = client.prepare("GET", url)
                .execute()
                .toCompletableFuture().get();
        client.close();
        return r;
    }

    public Response post(String url, String payload, HashMap<String, String> headers) throws IOException, ParseException, InterruptedException, ExecutionException {

        AsyncHttpClient client = new DefaultAsyncHttpClient();
        BoundRequestBuilder r = client.prepare("POST", url);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            r.addHeader(entry.getKey(), entry.getValue());
        }
        Response response = r.setBody(payload).execute().toCompletableFuture().get();
        client.close();
        return response;
    }
}
