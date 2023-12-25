package apiAutomation.parseJsons;

import apiAutomation.parseJsons.pojo.Batter;
import apiAutomation.parseJsons.pojo.Donut;
import apiAutomation.parseJsons.pojo.Topping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WithSimpleJsonPOJO
{
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
}