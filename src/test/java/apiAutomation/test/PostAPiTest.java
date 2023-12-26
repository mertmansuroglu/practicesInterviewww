package apiAutomation.test;//package apiAutomation.test;

import apiAutomation.restassured.Requests;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.asynchttpclient.Response;
import org.models.UserRegisterRequest;
import org.models.UserRegisterResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.net.http.HttpResponse;


public class PostAPiTest {

    String baseUrl;
    String apiUrl;
    String URI;

    CloseableHttpResponse closeableHttpResponse;
    HttpResponse httpResponse;
    InputStream response;
    Response responseAs;




    static int id;
    UserRegisterRequest userRegisterRequest= new UserRegisterRequest();

    @Test(priority =0)
    public void registerUserTest()
    {
        userRegisterRequest.setEmail("janet.weaver@reqres.in");
        userRegisterRequest.setPassword("pistol");
        io.restassured.response.Response response= Requests.Post("userRegisterRequest","wf");
//        Assert.assertEquals(response.statusCode(),
        UserRegisterResponse userRegisterResponse=response.jsonPath().getObject("$",UserRegisterResponse.class);
        id= userRegisterResponse.getId();
    }
//    @Test(priority = 1)
//    public void getRegisteredUserTest()
//    {
////        io.restassured.response.Response response= Requests.Get(getConfigprop("getUser")+id);
//        Assert.assertEquals(response.statusCode(),200);
//        RegisteredUserResponse registeredUserResponse=response.jsonPath().getObject("data",RegisteredUserResponse.class);
//        Assert.assertEquals(registeredUserResponse.getEmail(),userRegisterRequest.getEmail());
//        Assert.assertEquals(registeredUserResponse.getId(),2);
//    }


}
