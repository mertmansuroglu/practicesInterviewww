package apiAutomation.parseJsons;

import apiAutomation.parseJsons.pojo.Batter;
import apiAutomation.parseJsons.pojo.Donut;
import apiAutomation.parseJsons.pojo.Topping;
import apiAutomation.parseJsons.pojoResource.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class WithJacksonPojo {
    public static void main(String[] args) {
        String jsonString = "{ \"id\": \"0001\", \"type\": \"donut\", \"name\": \"Cake\", \"ppu\": 0.55, \"batters\": { \"batter\": [ { \"id\": \"1001\", \"type\": \"Regular\" }, { \"id\": \"1002\", \"type\": \"Chocolate\" }, { \"id\": \"1003\", \"type\": \"Blueberry\" }, { \"id\": \"1004\", \"type\": \"Devil's Food\" } ] }, \"topping\": [ { \"id\": \"5001\", \"type\": \"None\" }, { \"id\": \"5002\", \"type\": \"Glazed\" }, { \"id\": \"5005\", \"type\": \"Sugar\" }, { \"id\": \"5007\", \"type\": \"Powdered Sugar\" }, { \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" }, { \"id\": \"5003\", \"type\": \"Chocolate\" }, { \"id\": \"5004\", \"type\": \"Maple\" } ] }";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Donut  donut = objectMapper.readValue(jsonString, Donut.class);
            //NOW SERIALIZE TIME//////////
//        If you want to modify the Java object and then convert it back to JSON:
            // Assume 'donut' is a modified Donut object
            donut.setId("00010");
            donut.setName("updated donut");
            String modifiedJsonString = objectMapper.writeValueAsString(donut);
            System.out.println("Modified JSON String: " + modifiedJsonString);


            // Now, 'donut' contains the parsed data and serialized data
            System.out.println("ID: " + donut.getId());
            System.out.println("Type: " + donut.getType());
            System.out.println("Name: " + donut.getName());
            System.out.println("PPU: " + donut.getPpu());

            // Access nested structures as needed
            for (Batter batter : donut.getBatters().getBatter()) {
                System.out.println("Batter ID: " + batter.getId() + ", Type: " + batter.getType());
            }

            for (Topping topping : donut.getTopping()) {
                System.out.println("Topping ID: " + topping.getId() + ", Type: " + topping.getType());
            }

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void testGet()
    {
        String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users/2").then().spec(getResponseSpec()).extract().response().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        Root  root = null;
        try {
              root = objectMapper.readValue(jsonStringForDeserialize, Root.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println( root.getSupport().text);
        System.out.println( root.getData().last_name);
    }


    @Test
    public void testPost()
    {
        apiAutomation.parseJsons.registerUser.Root root = new  apiAutomation.parseJsons.registerUser.Root("mert","sok",null,null);
        Gson gson = new Gson();
        String s=  gson.toJson(root);
        String jsonStringForSerialize =RestAssured.given(getRequestSpec()).body(s).when().post("/api/users").then().spec(getResponseSpec()).extract().response().asString();
        apiAutomation.parseJsons.registerUser.Root responses = gson.fromJson(jsonStringForSerialize,  apiAutomation.parseJsons.registerUser.Root.class);
        Assert.assertTrue(Objects.equals(responses.getJob(),"sok"));
    }

    public static RequestSpecification getRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in/");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }
    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }
}

