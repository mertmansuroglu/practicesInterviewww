package apiAutomation.restassured;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.InputStream;
import java.util.Properties;

public class SpecBuilder {

    public static String token = "";

    public static RequestSpecification getRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("LoginProps.API_BASE_URI.value");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer " + token);
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }


    public static RequestSpecification getRequestSpecforGetMethod() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("LoginProps.API_BASE_URI.value");
        requestSpecBuilder.addHeader("Authorization", "Bearer " + token);
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }


    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }


    public static ResponseSpecification getResponseSpecWithoutContentType() {
        return new ResponseSpecBuilder().expectContentType("").
                log(LogDetail.ALL).
                build();
    }

    public static RequestSpecification getRequestSpecWithoutAuthHeader() {


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("LoginProps.API_BASE_URI.value");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setRelaxedHTTPSValidation();
        return requestSpecBuilder.build();
    }
    public static String getConfigprop(String propKey) {
        Properties configProps = null;
        try (InputStream is = ClassLoader.getSystemResourceAsStream("config.properties")) {
            configProps = new Properties();
            configProps.load(is);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Properties read finished.");
        }
        return configProps.getProperty(propKey);
    }

}