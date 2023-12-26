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

public class Requests {

    public static Response Post(String path, Object payload) {
        return RestAssured.given(getRequestSpec()).
                body(payload).
                when().
                post(path).
                then().
                spec(getResponseSpec()).
                extract().
                response();


    }

    public static Response Get(String path) {
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 20000)
                        .setParam("http.connection.timeout", 20000));
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given(getRequestSpec()).
                when().
                get(path).
                then().
                spec(getResponseSpec()).
                extract().
                response();


    }
    public static RequestSpecification getRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("LoginProps.API_BASE_URI.value");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer ");
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }
    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
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




}
