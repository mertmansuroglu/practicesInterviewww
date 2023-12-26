package apiAutomation.parseJsons;

import apiAutomation.parseJsons.pojo.Batter;
import apiAutomation.parseJsons.pojo.Donut;
import apiAutomation.parseJsons.pojo.Topping;
import apiAutomation.parseJsons.pojoResource.Root;
import apiAutomation.restassured.Requests;
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

public class WithGsonPojo {
    public static void main(String[] args) {
        // Your JSON string
        String jsonString = "{\n" +
                "    \"id\": \"0001\",\n" +
                "    \"type\": \"donut\",\n" +
                "    \"name\": \"Cake\",\n" +
                "    \"ppu\": 0.55,\n" +
                "    \"batters\": {\n" +
                "        \"batter\": [\n" +
                "            {\"id\": \"1001\", \"type\": \"Regular\"},\n" +
                "            {\"id\": \"1002\", \"type\": \"Chocolate\"},\n" +
                "            {\"id\": \"1003\", \"type\": \"Blueberry\"},\n" +
                "            {\"id\": \"1004\", \"type\": \"Devil's Food\"}\n" +
                "        ]\n" +
                "    },\n" +
                "    \"topping\": [\n" +
                "        {\"id\": \"5001\", \"type\": \"None\"},\n" +
                "        {\"id\": \"5002\", \"type\": \"Glazed\"},\n" +
                "        {\"id\": \"5005\", \"type\": \"Sugar\"},\n" +
                "        {\"id\": \"5007\", \"type\": \"Powdered Sugar\"},\n" +
                "        {\"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\"},\n" +
                "        {\"id\": \"5003\", \"type\": \"Chocolate\"},\n" +
                "        {\"id\": \"5004\", \"type\": \"Maple\"}\n" +
                "    ]\n" +
                "}";

        // Deserialize JSON string to POJO using Gson
        Gson gson = new Gson();
        Donut donut = gson.fromJson(jsonString, Donut.class);

        // Accessing values in POJO
        System.out.println("ID: " + donut.getId());
        System.out.println("Type: " + donut.getType());
        System.out.println("Name: " + donut.getName());
        System.out.println("PPU: " + donut.getPpu());
        System.out.println("PPU: " + donut.getBatters().getBatter().get(0).getId());

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

        // Serialize POJO to JSON string using Gson
        String modifiedJsonString = gson.toJson(donut);
        System.out.println("\nModified JSON String: " + modifiedJsonString);
    }

    @Test
    public void testGet()
    {
       String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users/2").then().spec(getResponseSpec()).extract().response().asString();
        Requests.Get().asString()
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