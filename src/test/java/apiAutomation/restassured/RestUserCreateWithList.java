package apiAutomation.restassured;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
//
//public class RestUserCreateWithList extends Global {
//    private RequestSpecification httpRequest;
//     Response response;
//     JsonPath jsonPathEvaluator;
//    Faker faker;
//
//    @BeforeMethod
//    public void set_up(){
//        RestAssured.baseURI =$("RESTURI");
//        RestAssured.port = Integer.valueOf($("PORT"));
//        httpRequest = RestAssured.given();
//    }
//
//    @Test
//    public void getTest(){
//        response = httpRequest.get("/pet/5");
//        response = httpRequest.param("search", "gjore").param("search", "zaharchev").get("/pet/5");
//        jsonPathEvaluator = response.jsonPath();
//
//        assertThat(response.statusCode()).isEqualTo(200);
//        assertThat(response.header("Content-Type")).isEqualTo("application/json");
//        assertThat(response.time()).isLessThan(10000);
//        assertThat(jsonPathEvaluator.get("id").toString()).isEqualTo(5);
//    }
//
//    @Test
//    public void postTest(){
//        httpRequest.post("user/createWithList");
//        httpRequest.header("ContentType", "json");
//        httpRequest.body(new Gson().toJson(userCreateWithList));
//        response.prettyPrint();
//    }
//
//
//}