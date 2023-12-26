package apiAutomation.parseJsons;

import apiAutomation.parseJsons.pojo.Batter;
import apiAutomation.parseJsons.pojo.Donut;
import apiAutomation.parseJsons.pojo.Topping;
import apiAutomation.parseJsons.pojoResource.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

public class WithSimpleJsonPOJO
{
        public static void main(String[] args) {
            // Your JSON string
            FileReader fileReader;
            try {
                 fileReader = new FileReader("src/test/resources/payload.json");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                // Parse JSON string to JSONObject
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(fileReader);

                // Convert JSONObject to POJO using Jackson
//                If you are using a library like Jackson or Gson for JSON parsing,
//                you typically don't need to manually set each field using a method like setJsonObjectData.
//                Instead, these libraries can directly map the fields from the JSON to the corresponding fields in your Java class
                ObjectMapper objectMapper = new ObjectMapper();
                Donut donut = objectMapper.readValue(jsonObject.toJSONString(), Donut.class);
                // Access and modify the POJO
                System.out.println("ID: " + donut.getId());
                System.out.println("Type: " + donut.getType());
                System.out.println("Name: " + donut.getName());
                System.out.println("PPU: " + donut.getPpu());

                // Accessing nested structures in POJO
                System.out.println("\nBatters:");
                for (Batter batter : donut.getBatters().getBatter()) {
                    System.out.println("  ID: " + batter.getId() + ", Type: " + batter.getType());
                }

                System.out.println("\nToppings:");
                for (Topping topping : donut.getTopping()) {
                    System.out.println("  ID: " + topping.getId() + ", Type: " + topping.getType());
                }

                // Modify the POJO
                donut.setId("9999");
                donut.setName("Modified Cake");
                donut.setPpu(1.99);

                // Convert POJO to JSONObject using Jackson
                JSONObject modifiedJsonObject = objectMapper.convertValue(donut, JSONObject.class);

                // Serialize modified JSONObject to JSON string
                // If you are using a library like Jackson or Gson for JSON parsing,
           //you typically don't need to manually set each field using a method like setJsonObjectData.
             //Instead, these libraries can directly map the fields from the JSON to the corresponding fields in your Java class
                String modifiedJsonString = modifiedJsonObject.toJSONString();
                System.out.println("\nModified JSON String: " + modifiedJsonString);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Test
    public void testGet()
    {
        String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users/2").then().spec(getResponseSpec()).extract().response().asString();
        Gson gson = new Gson();
        //deserialize
        Root root = gson.fromJson(jsonStringForDeserialize, Root.class);
        System.out.println( root.getSupport().text);
        System.out.println( root.getData().last_name);
    }

    @Test
    public void testGet2()
    {
        String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users?page=2").then().spec(getResponseSpec()).extract().response().asString();
        Gson gson = new Gson();
        //deserialize
        apiAutomation.parseJsons.pojoUsers.Root root = gson.fromJson(jsonStringForDeserialize, apiAutomation.parseJsons.pojoUsers.Root.class);
        Assert.assertTrue(Objects.equals(root.getData().get(0).getAvatar(),"https://reqres.in/img/faces/7-image.jpg"));
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