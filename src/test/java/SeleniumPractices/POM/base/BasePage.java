package SeleniumPractices.POM.base;


import SeleniumPractices.POM.browsers.BrowserSelectable;
import SeleniumPractices.POM.browsers.Chrome;
import SeleniumPractices.POM.browsers.Edge;
import SeleniumPractices.POM.browsers.Firefox;
import SeleniumPractices.POM.enums.Browsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Locale;

import static org.openqa.selenium.remote.Browser.*;

public class BasePage {
    private final static Logger log = LogManager.getLogger(BasePage.class);
    public static WebDriver driver;
    private static int waitTime;

    public static int getWaitTime() {
        return waitTime;
    }
    private static void setWaitTime(int time) {
        waitTime = time;
    }
    public void quitDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        } catch (NoSuchSessionException e) {
            log.warn("Driver already closed");
        }
    }
    public void createDriver(Browsers browser) {
        BrowserSelectable browserSelectable;
        switch (browser) {
            case EDGE -> {
                browserSelectable = new Edge();
                driver = browserSelectable.getBrowser();
                driver.manage().window().maximize();
            }
            case FIREFOX -> {
                browserSelectable = new Firefox();
                driver = browserSelectable.getBrowser();
                driver.manage().window().maximize();
            }
            case CHROME -> {
                browserSelectable = new Chrome();
                driver = browserSelectable.getBrowser();
            }
            default -> throw new IllegalArgumentException(String.format("%s undefined type of browser", browser.value()));

        }
    }
    @AfterMethod
    public void afterTestMethod() {
        quitDriver();
    }


    @BeforeMethod
    public void beforeTestMethod() {
        setWaitTime(15);
        String browserName = "edge";
        Browsers browserType = Browsers.valueOf(browserName.toUpperCase(Locale.ROOT));
        createDriver(browserType);
        log.info("{} is lunched", browserType);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getWaitTime()));
        var baseUrl = "https://www.amazon.in";
        driver.get(baseUrl);
        driver.manage().deleteAllCookies();
        log.info("{} is loaded", baseUrl);
        driver.manage().window().fullscreen();
    }

}

