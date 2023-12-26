package apiAutomation.restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestMethods {


    @Test
    public void testStatusCode() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testResponseContent() throws JsonProcessingException {

     Response response= given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200).extract().response();

     ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.asString());
        Assert.assertTrue(Objects.equals(jsonNode.get("userId").asText(), "1"));
    }

    @Test
    public void testMultipleAssertions() {

        Response response=    given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200).extract().response();

        JsonObject object= JsonParser.parseString(response.asString()).getAsJsonObject();
        System.out.println( object.get("id").getAsString());
        System.out.println( object.get("title").getAsString());
        System.out.println( object.get("body").getAsString());
    }

    public class RestAssuredHamcrestExamples {

        @Test
        public void testHamcrestMatchers() {
            given()
                    .when()
                    .get("https://jsonplaceholder.typicode.com/posts/1")
                    .then()
                    .statusCode(200)
                    .body("userId", equalTo(1))
                    .body("title", containsString("aut facere"))
                    .body("id", greaterThan(0));
        }
    }

    @Test
    public void testCustomMatchers() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("userId", is(equalTo(1)))
                .body("title", is(notNullValue()))
                .body("id", is(greaterThan(0)));
    }
    @Test
    public void testTestNGAssertions() {
        int statusCode = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1").getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code should be 200");

        String responseBody = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1").asString();
        Assert.assertTrue(responseBody.contains("userId"), "Response body should contain 'userId'");
    }
}


