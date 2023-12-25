package apiAutomation.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static apiAutomation.restassured.SpecBuilder.getResponseSpec;
import static apiAutomation.restassured.SpecBuilder.getResponseSpecWithoutContentType;


public class Requests {

    public static Response Post(String path, Object payload) {
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 15000)
                        .setParam("http.connection.timeout", 15000));
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given(SpecBuilder.getRequestSpec()).
                body(payload).
                when().
                post(path).
                then().
                spec(getResponseSpec()).
                extract().
                response();

    }


    public static Response PostWithSpecs(String path, Object payload, RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 15000)
                        .setParam("http.connection.timeout", 15000));
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given(requestSpecification).
                body(payload).
                when().
                post(path).
                then().
                spec(responseSpecification).
                extract().
                response();
    }

    public static Response GetWithSpecs(String path, RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 15000)
                        .setParam("http.connection.timeout", 15000));
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given(requestSpecification).
                when().
                get(path).
                then().
                spec(responseSpecification).
                extract().
                response();
    }


    public static Response Get(String path) {
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 20000)
                        .setParam("http.connection.timeout", 20000));
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given(SpecBuilder.getRequestSpec()).
                when().
                get(path).
                then().
                spec(getResponseSpec()).
                extract().
                response();


    }


}
