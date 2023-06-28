package apiAutomation.test;//package apiAutomation.test;

import apiAutomation.base.TestBase;
import apiAutomation.client.AsynchHttpClient;
import apiAutomation.client.ClosabHttpClienttt;
import apiAutomation.client.JavaNetHttpClıent;
import apiAutomation.client.UrlConnectionClient;
import apiAutomation.datas.Users;
import apiAutomation.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.asynchttpclient.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

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
    public void postApiTestAsynch() throws IOException, ParseException, InterruptedException, ExecutionException {
        AsynchHttpClient restClient = new AsynchHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        Users users = new Users("mert2", "engineer2", null);//expected users object
        //I need to convert the object to json object-- object to json file -- serialization
        String jsonString = mapper.writeValueAsString(users);
        System.out.println(jsonString);
        responseAs = restClient.post(URI, jsonString, headerMap);
        int statusCode = responseAs.getStatusCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 201, "Status code is not 201");
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

    @Test
    public void postApiTest() throws IOException, ParseException {
        ClosabHttpClienttt restClient = new ClosabHttpClienttt();
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        //i need to convert pojo to json! serialization -- marsheiling

        //I need jackson api!! jackson is converting pojo to json!! or json to object
        ObjectMapper mapper = new ObjectMapper();
        Users users = new Users("mert", "engineer", null);//expected users object
        //I need to convert the object to json object-- object to json file -- serialization
        mapper.writeValue(new File("C:\\Users\\Mert.Mansuroglu\\Desktop\\InterviewJavaMavenn\\src\\main\\java\\apiAutomation\\datas\\Users.json"), users);
        String jsonString = mapper.writeValueAsString(users);
        System.out.println(jsonString);
        closeableHttpResponse = restClient.post(URI, jsonString, headerMap);
        int statusCode = closeableHttpResponse.getCode();
        System.out.println("status code is:" + statusCode);
        Assert.assertEquals(statusCode, 201, "Status code is not 201");

        //2.jsonString--- burda sonu aldik geri json objecte te cevirdimk deserailzie ettik!!
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        String job = TestUtil.getValueByJsPath(responseJson, "job");
        System.out.println(job);

        //json to java object --- deserialization
        Users userObj = mapper.readValue(responseString, Users.class);//actual users object
        //actualda id mevcut mesela onun icin json ignore kullanmaliyiz cunku requestte ihtiyacimiz yok buna
        System.out.println(users.getName().equals(userObj.getName()));
        System.out.println(users.getJob().equals(userObj.getJob()));

        System.out.println(userObj.getId());
        System.out.println(userObj.getCreatedAt());
    }


}
