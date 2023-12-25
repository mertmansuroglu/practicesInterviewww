package apiAutomation.test;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Assertionnns {


    @Test
    public void testStatusCode() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testResponseContent() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void testMultipleAssertions() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("id", greaterThan(0));
    }

    @Test
    public void testJsonPathAssertion() {
        String responseBody = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .extract().asString();

        String userId = from(responseBody).get("userId");
        String title = from(responseBody).get("title");

        // Use extracted values for further assertions or validations
        assertThat(userId, equalTo("1"));
        assertThat(title, equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
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


