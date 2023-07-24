package SeleniumPractices.POM.browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Chrome implements BrowserSelectable {



    @Override
    public ChromeDriver getBrowser() {
        var options = new ChromeOptions();

        options.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        options.addArguments("--kiosk");
        options.addArguments("--log-level=3");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-logging");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }
}
