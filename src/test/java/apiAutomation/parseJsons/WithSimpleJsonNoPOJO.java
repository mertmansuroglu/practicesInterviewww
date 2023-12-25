package apiAutomation.parseJsons;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WithSimpleJsonNoPOJO {
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
            // Parse JSON string to JSONObject
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);

            // Accessing values
            System.out.println("ID: " + jsonObject.get("id"));
            System.out.println("Type: " + jsonObject.get("type"));
            System.out.println("Name: " + jsonObject.get("name"));
            System.out.println("PPU: " + jsonObject.get("ppu"));

            // Accessing nested structures
            System.out.println("\nBatters:");
            JSONObject batters = (JSONObject) jsonObject.get("batters");
            JSONArray batterArray = (JSONArray) batters.get("batter");
            for (Object batterObj : batterArray) {
                JSONObject batter = (JSONObject) batterObj;
                System.out.println("  ID: " + batter.get("id") + ", Type: " + batter.get("type"));
            }

            System.out.println("\nToppings:");
            JSONArray toppings = (JSONArray) jsonObject.get("topping");
            for (Object toppingObj : toppings) {
                JSONObject topping = (JSONObject) toppingObj;
                System.out.println("  ID: " + topping.get("id") + ", Type: " + topping.get("type"));
            }

            // Modify the JSONObject
            jsonObject.put("id", "9999");
            jsonObject.put("name", "Modified Cake");
            jsonObject.put("ppu", 1.99);

            // Serialize modified JSONObject to JSON string
            String modifiedJsonString = jsonObject.toJSONString();
            System.out.println("\nModified JSON String: " + modifiedJsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}