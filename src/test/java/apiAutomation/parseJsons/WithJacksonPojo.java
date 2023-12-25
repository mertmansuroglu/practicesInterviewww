package apiAutomation.parseJsons;

import apiAutomation.parseJsons.pojo.Batter;
import apiAutomation.parseJsons.pojo.Donut;
import apiAutomation.parseJsons.pojo.Topping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}

