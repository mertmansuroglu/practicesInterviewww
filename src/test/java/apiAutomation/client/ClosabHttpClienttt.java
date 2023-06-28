package apiAutomation.client;//package apiAutomation.client;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClosabHttpClienttt {

    //1.GET Method without headers
    public CloseableHttpResponse get(String url) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);//http get request
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);//hit the get URL
        return closeableHttpResponse;

    }

    public CloseableHttpResponse getWithHeaders(String url, HashMap<String, String> headers) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);//http get request
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpGet.addHeader(entry.getKey(), entry.getValue());
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);//hit the get URL
        return closeableHttpResponse;

    }

    //POST METHOD
    public CloseableHttpResponse post(String url, String payload, HashMap<String, String> headers) throws IOException, ParseException {
        //first create the client
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //generate the request
        HttpPost httpPost = new HttpPost(url);//http post request
        //define payload
        httpPost.setEntity(new StringEntity(payload));
        //define headers
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }
        //finally execute the reqeust with client!! hit the post url
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
        return closeableHttpResponse;

    }


}
