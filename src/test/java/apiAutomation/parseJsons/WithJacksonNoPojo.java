package apiAutomation.parseJsons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

public class WithJacksonNoPojo {
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

        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Deserialize JSON string to JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Accessing values
            System.out.println("ID: " + jsonNode.get("id").asText());
            System.out.println("Type: " + jsonNode.get("type").asText());
            System.out.println("Name: " + jsonNode.get("name").asText());
            System.out.println("PPU: " + jsonNode.get("ppu").asDouble());

            // Accessing nested structures
            System.out.println("\nBatters:");
            for (JsonNode batter : jsonNode.get("batters").get("batter")) {
                System.out.println("  ID: " + batter.get("id").asText() + ", Type: " + batter.get("type").asText());
            }

            System.out.println("\nToppings:");
            for (JsonNode topping : jsonNode.get("topping")) {
                System.out.println("  ID: " + topping.get("id").asText() + ", Type: " + topping.get("type").asText());
            }

            // Modify the JsonNode
            ((ObjectNode) jsonNode).put("id", "9999");
            ((ObjectNode) jsonNode).put("name", "Modified Cake");
            ((ObjectNode) jsonNode).put("ppu", 1.99);

            // Serialize modified JsonNode to JSON string
            String modifiedJsonString = objectMapper.writeValueAsString(jsonNode);
            System.out.println("\nModified JSON String: " + modifiedJsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGet()
    {
        String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users/2").then().spec(getResponseSpec()).extract().response().asString();
        //deserialize
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialize JSON string to JsonNode
        JsonNode jsonNode;
        try {
             jsonNode = objectMapper.readTree(jsonStringForDeserialize);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonNode.get("support").get("url").asText());
        System.out.println( (jsonNode.get("data").get("id").asText()));
    }

    @Test
    public void testGet2()
    {
        String jsonStringForDeserialize= RestAssured.given(getRequestSpec()).when().get("api/users?page=2").then().spec(getResponseSpec()).extract().response().asString();
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialize JSON string to JsonNode
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(jsonStringForDeserialize);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Objects.equals( (jsonNode.get("data").get(0).get("last_name").asText()),"Lawson"));
    }

    @Test
    public void testPost() throws JsonProcessingException {
        String jsonUserReegister="{\n" +
                "    \"name\": \"mor\",\n" +
                "    \"job\": \"leaderrr\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;
        jsonNode = objectMapper.readTree(jsonUserReegister);
        // Parse JSON string to JsonObject
        ((ObjectNode) jsonNode).put("job", "kkkkk");

        // Serialize modified JsonNode to JSON string
        String modifiedJsonString = objectMapper.writeValueAsString(jsonNode);
        String jsonStringForSerialize =RestAssured.given(getRequestSpec()).body(modifiedJsonString).when().post("/api/users").then().spec(getResponseSpec()).extract().response().asString();
        try {
            jsonNode = objectMapper.readTree(jsonStringForSerialize);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);

        }
        System.out.println(jsonNode.get("job").asText());
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
