package apiAutomation.parseJsons;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
}
