package apiAutomation.test;//package apiAutomation.test;

import apiAutomation.base.TestBase;
import apiAutomation.client.AsynchHttpClient;
import apiAutomation.client.ClosabHttpClienttt;
import apiAutomation.client.JavaNetHttpClıent;
import apiAutomation.client.UrlConnectionClient;
import apiAutomation.datas.Users;
import apiAutomation.restassured.Requests;
import apiAutomation.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.asynchttpclient.Response;
import org.json.JSONObject;
import org.models.RegisteredUserResponse;
import org.models.UserRegisterRequest;
import org.models.UserRegisterResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static apiAutomation.restassured.SpecBuilder.getConfigprop;

public class PostAPiTest extends TestBase {


    TestBase testBase;
    String baseUrl;
    String apiUrl;
    String URI;

    CloseableHttpResponse closeableHttpResponse;
    HttpResponse httpResponse;
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
    public void postApiTestNetClient() throws IOException, ParseException, InterruptedException {
        JavaNetHttpClıent restClient = new JavaNetHttpClıent();
        ObjectMapper mapper = new ObjectMapper();
        Users users = new Users("mert2", "engineer2", null);//expected users object

        //yada istersek hashmap yaratip direk gonderip jacksonin parse serialize etmesini bekleriz
        var values = new HashMap<String, String>() {{
            put("name", users.getName());
            put("occupation", users.getJob());
        }};
        //I need to convert the object to json object-- object to json file -- serialization
        String jsonString = mapper.writeValueAsString(users);
        System.out.println(jsonString);
        httpResponse = restClient.post(URI, jsonString, "Content-Type", "application/json");
        int statusCode = httpResponse.statusCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 201, "Status code is not 201");
    }

    @Test
    public void postApiTestUrlConnection() throws IOException, ParseException, InterruptedException {

        UrlConnectionClient restClient = new UrlConnectionClient();
        String jsonString = "{\"name\": \"mert\", \"job\": \"Programmer\"}";
        response = restClient.post(URI, jsonString, "Content-Type", "application/json");
    }
    static int id;
    UserRegisterRequest userRegisterRequest= new UserRegisterRequest();

    @Test(priority =0)
    public void registerUserTest()
    {
        userRegisterRequest.setEmail("janet.weaver@reqres.in");
        userRegisterRequest.setPassword("pistol");
        io.restassured.response.Response response= Requests.Post(getConfigprop("registerUserPath"),userRegisterRequest);
        Assert.assertEquals(response.statusCode(),200);
        UserRegisterResponse userRegisterResponse=response.jsonPath().getObject("$",UserRegisterResponse.class);
        id= userRegisterResponse.getId();
    }
    @Test(priority = 1)
    public void getRegisteredUserTest()
    {
        io.restassured.response.Response response= Requests.Get(getConfigprop("getUser")+id);
        Assert.assertEquals(response.statusCode(),200);
        RegisteredUserResponse registeredUserResponse=response.jsonPath().getObject("data",RegisteredUserResponse.class);
        Assert.assertEquals(registeredUserResponse.getEmail(),userRegisterRequest.getEmail());
        Assert.assertEquals(registeredUserResponse.getId(),2);
    }
    @Test
    public void getApTestUrlConnection() throws IOException, ParseException, InterruptedException {
        testBase = new TestBase();
        baseUrl = prop.getProperty("URL2");
        apiUrl = prop.getProperty("apiURL2");
        URI = baseUrl + apiUrl;
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

}
