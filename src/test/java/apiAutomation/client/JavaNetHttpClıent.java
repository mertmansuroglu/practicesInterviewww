package apiAutomation.client;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaNetHttpClıent {

    public HttpResponse get(String url) throws IOException, ParseException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
    //asagisini abine sor map.entry ile nasil yaparsin
    public HttpResponse getWithHeaders(String url, String headerkey, String HeaderValue) throws IOException, ParseException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).header(headerkey, HeaderValue)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    }

    public HttpResponse post(String url, String payload, String headerkey, String HeaderValue) throws IOException, ParseException, InterruptedException {
        //first create the client
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header(headerkey, HeaderValue)
                .method("POST", HttpRequest.BodyPublishers.ofString(payload))
                .build();
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


    }
}
