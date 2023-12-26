package apiAutomation.parseJsons;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonPathExample {
//Bunu düzeltmek için, dosya içeriğini bir JSON string'e dönüştürmeniz gerekmektedir.
// Aşağıda, dosya içeriğini bir String olarak okuma ve ardından JsonPath.read() fonksiyonunu kullanma örneği bulunmakta
    public static void main(String[] args) {
        // Your JSON string
        String jsonString = "";
        try {
            // Dosyadan JSON verisini oku
             jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/payload.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JsonPath kullanarak değerlere erişme
        String id = JsonPath.read(jsonString, "$.id");
        String type = JsonPath.read(jsonString, "$.type");
        String name = JsonPath.read(jsonString, "$.name");
        Double ppu = JsonPath.read(jsonString, "$.ppu");

        System.out.println("ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("PPU: " + ppu);

        // JsonPath ile nested yapıdaki değerlere erişme
       JSONArray batters=JsonPath.read(jsonString, "$.batters.batter");
        System.out.println("\nBatters:");
        for (Object batter : batters) {
            String batterId = JsonPath.read(batter, "$.id");
            String batterType = JsonPath.read(batter, "$.type");
            System.out.println("  ID: " + batterId + ", Type: " + batterType);
        }

        JSONArray toppings = JsonPath.read(jsonString, "$.topping");
        System.out.println("\nToppings:");
        for (Object topping : toppings) {
            String toppingId = JsonPath.read(topping, "$.id");
            String toppingType = JsonPath.read(topping, "$.type");
            System.out.println("  ID: " + toppingId + ", Type: " + toppingType);
        }
    }

}

