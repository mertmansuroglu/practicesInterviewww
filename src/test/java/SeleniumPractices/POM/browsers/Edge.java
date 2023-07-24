package SeleniumPractices.POM.browsers;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;

public class Edge implements BrowserSelectable {


    @Override
    public EdgeDriver getBrowser() {
        EdgeOptions options = new EdgeOptions();
        var prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setCapability("prefs",prefs);
        return new EdgeDriver(options);
    }
}

