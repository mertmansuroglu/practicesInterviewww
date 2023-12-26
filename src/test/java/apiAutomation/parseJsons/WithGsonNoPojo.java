package apiAutomation.parseJsons;

import apiAutomation.parseJsons.pojoResource.Root;
import com.google.gson.*;
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

public class WithGsonNoPojo {
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

        // Parse JSON string to JsonObject
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

        // Accessing values
        System.out.println("ID: " + jsonObject.get("id").getAsString());
        System.out.println("Type: " + jsonObject.get("type").getAsString());
        System.out.println("Name: " + jsonObject.get("name").getAsString());
        System.out.println("PPU: " + jsonObject.get("ppu").getAsDouble());


        // Accessing nested structures
        System.out.println("\nBatters:");
        JsonArray batterArray = jsonObject.getAsJsonObject("batters").getAsJsonArray("batter");
        for (JsonElement batterElement : batterArray) {
            JsonObject batter = batterElement.getAsJsonObject();
            System.out.println("  ID: " + batter.get("id").getAsString() + ", Type: " + batter.get("type").getAsString());
        }

        System.out.println("\nToppings:");
        JsonArray toppings = jsonObject.getAsJsonArray("topping");
        for (JsonElement toppingElement : toppings) {
            JsonObject topping = toppingElement.getAsJsonObject();
            System.out.println("  ID: " + topping.get("id").getAsString() + ", Type: " + topping.get("type").getAsString());
        }

        // Modify the JsonObject
        jsonObject.addProperty("id", "9999");
        jsonObject.addProperty("name", "Modified Cake");
        jsonObject.addProperty("ppu", 1.99);

        // Serialize modified JsonObject to JSON string
        String modifiedJsonString = jsonObject.toString();
        System.out.println("\nModified JSON String: " + modifiedJsonString);
    }
    @Test
    public void testGet()
    {
        String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users/2").then().spec(getResponseSpec()).extract().response().asString();
        //deserialize
        JsonObject jsonObject = JsonParser.parseString(jsonStringForDeserialize).getAsJsonObject();
        System.out.println( jsonObject.getAsJsonObject("support").get("url").getAsString());
        System.out.println( jsonObject.getAsJsonObject("data").get("id").getAsString());
    }

    @Test
    public void testGet2()
    {
        String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users?page=2").then().spec(getResponseSpec()).extract().response().asString();
        Gson gson = new Gson();
        //deserialize
        JsonObject jsonObject = JsonParser.parseString(jsonStringForDeserialize).getAsJsonObject();
        Assert.assertTrue(Objects.equals( jsonObject.getAsJsonArray("data").get(0).getAsJsonObject().get("last_name").getAsString(),"Lawson"));
    }

    @Test
    public void testPost()
    {
        String jsonUserReegister="{\n" +
                "    \"name\": \"mor\",\n" +
                "    \"job\": \"leaderrr\"\n" +
                "}";
        Gson gson = new Gson();
        // Parse JSON string to JsonObject
        JsonObject jsonObject = JsonParser.parseString(jsonUserReegister).getAsJsonObject();
        jsonObject.addProperty("job", "5");
        String jsonStringForSerialize =RestAssured.given(getRequestSpec()).body(jsonObject.toString()).when().post("/api/users").then().spec(getResponseSpec()).extract().response().asString();
        JsonObject jsonObject2 = JsonParser.parseString(jsonStringForSerialize).getAsJsonObject();
        Assert.assertTrue(Objects.equals(jsonObject2.getAsJsonObject().get("job").getAsString(),"5"));
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