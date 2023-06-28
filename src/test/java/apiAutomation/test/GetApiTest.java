package apiAutomation.test;//package apiAutomation.test;
//
//import apiAutomation.base.TestBase;
//import apiAutomation.client.AsynchHttpClient;
//import apiAutomation.client.ClosabHttpClienttt;
//import apiAutomation.client.JavaNetHttpClıent;
//import apiAutomation.client.UrlConnectionClient;
//import apiAutomation.util.TestUtil;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
//import org.apache.hc.core5.http.Header;
//import org.apache.hc.core5.http.ParseException;
//import org.apache.hc.core5.http.io.entity.EntityUtils;
//import org.asynchttpclient.Response;
//import org.json.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
import apiAutomation.base.TestBase;
import apiAutomation.client.AsynchHttpClient;
import apiAutomation.client.JavaNetHttpClıent;
import io.restassured.response.Response;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class GetApiTest extends TestBase {
    TestBase testBase;
    String baseUrl;
    String apiUrl;
    String URI;
    HttpResponse httpResponse;
    CloseableHttpResponse closeableHttpResponse;
    InputStream response;
    Response responseAs;

    @BeforeMethod
    public void setUp() {
        testBase = new TestBase();
        baseUrl = prop.getProperty("URL2");
        apiUrl = prop.getProperty("apiURL2");
        URI = baseUrl + apiUrl;


    }

    @Test
    public void getApiTestNAsynch() throws IOException, ParseException, InterruptedException, ExecutionException {
        AsynchHttpClient restClient = new AsynchHttpClient();
        responseAs = restClient.get(URI);
        //a-status code

        //in the closeableHttp response, everything regarding the response header adn everything is available
        int statusCode = responseAs.getStatusCode();
        System.out.println("Status Code:" + statusCode);
        //we need to get response a string
        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
        //b-json string
    }

    @Test
    public void getApiTestNet() throws IOException, ParseException, InterruptedException {
        JavaNetHttpClıent restClient = new JavaNetHttpClıent();
        httpResponse = restClient.get(URI);
        //a-status code

        //in the closeableHttp response, everything regarding the response header adn everything is available
        int statusCode = httpResponse.statusCode();
        System.out.println("Status Code:" + statusCode);
        //we need to get response a string
        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
        //b-json string
    }

    @Test
    public void getApTestUrlConnection() throws IOException, ParseException, InterruptedException {
        UrlConnectionClient restClient = new UrlConnectionClient();
        response = restClient.getWithHeader(URI, "Content-Type", "application/json");
        //asagidaki inputstream i json objecte donusturur!!!
        BufferedReader bR = new BufferedReader(new InputStreamReader(response));
        String line = "";
        StringBuilder responseStrBuilder = new StringBuilder();
        while ((line = bR.readLine()) != null) {

            responseStrBuilder.append(line);
        }
        response.close();

        JSONObject result = new JSONObject(responseStrBuilder.toString());
        //simdi artik bu result bizikm jsonobjectimiz biz bunu kullanip jpath cekeriz
        String total = TestUtil.getValueByJsPath(result, "/total");
        String lastname = TestUtil.getValueByJsPath(result, "data[1]/last_name");
        Assert.assertEquals(total, "12");
        Assert.assertEquals(lastname, "Weaver");
        System.out.println(lastname);
        //a-status code
    }

    @Test
    public void getApiTest() throws IOException, ParseException {
        ClosabHttpClienttt restClient = new ClosabHttpClienttt();
        closeableHttpResponse = restClient.get(URI);
        //a-status code

        //in the closeableHttp response, everything regarding the response header adn everything is available
        int statusCode = closeableHttpResponse.getCode();
        System.out.println("Status Code:" + statusCode);
        //we need to get response a strinG
        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
        //b-json string

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responsejSON = new JSONObject(responseString);
        System.out.println("Response json from api:\n" + responsejSON);

        //single value assertion
        //per_page
        String p = TestUtil.getValueByJsPath(responsejSON, "/per_page");
        String totalval = TestUtil.getValueByJsPath(responsejSON, "/total");
        System.out.println("value of per page is:" + p);

        //total
        System.out.println("value of total is:" + totalval);
        Assert.assertEquals(p, "6", "per page is not correct");
        Assert.assertEquals(totalval, "12", "total is not correct");

        //ge the value from json array
        String lastName = TestUtil.getValueByJsPath(responsejSON, "/apiAutomation.data[0]/last_name");
        String id = TestUtil.getValueByJsPath(responsejSON, "/apiAutomation.data[0]/id");
        System.out.println(lastName);
        System.out.println(id);

        //c -all headers

        Header[] headersArr = closeableHttpResponse.getHeaders();
        System.out.println("\nheaders array f:" + headersArr.toString());
        HashMap<String, String> allHeaders = new HashMap<>();
        for (Header header : headersArr) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("\nheaders array:" + allHeaders);
    }

    @Test
    public void getApiTestWithHeaders() throws IOException, ParseException {
        ClosabHttpClienttt restClient = new ClosabHttpClienttt();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        closeableHttpResponse = restClient.getWithHeaders(URI, headerMap);
        //a-status code

        //in the closeableHttp response, everything regarding the response header adn everything is available
        int statusCode = closeableHttpResponse.getCode();
        System.out.println("Status Code:" + statusCode);
        //we need to get response a strinG
        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
        //b-json string

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responsejSON = new JSONObject(responseString);
        System.out.println("Response json from api:\n" + responsejSON);

        //single value assertion
        //per_page
        String p = TestUtil.getValueByJsPath(responsejSON, "/per_page");
        String totalval = TestUtil.getValueByJsPath(responsejSON, "/total");
        System.out.println("value of per page is:" + p);

        //total
        System.out.println("value of total is:" + totalval);
        Assert.assertEquals(p, "6", "per page is not correct");
        Assert.assertEquals(totalval, "12", "total is not correct");

        //ge the value from json array
        String lastName = TestUtil.getValueByJsPath(responsejSON, "/apiAutomation.data[0]/last_name");
        String id = TestUtil.getValueByJsPath(responsejSON, "/apiAutomation.data[0]/id");
        System.out.println(lastName);
        System.out.println(id);

        //c -all headers

        Header[] headersArr = closeableHttpResponse.getHeaders();
        System.out.println("\nheaders array f:" + headersArr.toString());
        HashMap<String, String> allHeaders = new HashMap<>();
        for (Header header : headersArr) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("\nheaders array:" + allHeaders);
    }

}
