package SeleniumPractices.POM.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;

public class Firefox implements BrowserSelectable {

    @Override
    public FirefoxDriver getBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        var prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.addArguments("--kiosk");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        options.setCapability("prefs", prefs);
        options.setCapability(CapabilityType.BROWSER_NAME,"firefox");

        return new FirefoxDriver(options);
    }
}
