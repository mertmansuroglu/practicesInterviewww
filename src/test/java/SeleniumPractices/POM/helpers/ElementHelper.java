package SeleniumPractices.POM.helpers;

import base.BasePage;
import org.openqa.selenium.By;

import java.time.Duration;

import static base.BasePage.getWaitTime;

public class ElementHelper extends BasePage {


    public static boolean isElementPresent(By by) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        var result = driver.findElements(by).size() > 0;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getWaitTime()));
        return result;
    }
}
