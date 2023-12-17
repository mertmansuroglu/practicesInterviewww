package SeleniumPractices.POM.helpers;


import SeleniumPractices.POM.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class WaitHelper extends BasePage {

    protected long DEFAULT_WAIT = 15;
    protected long DEFAULT_SLEEP_IN_MILLIS = 500;

    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT), Duration.ofMillis(DEFAULT_SLEEP_IN_MILLIS));
    }

    public void waitUntilPageLoad() {
        getWait().until((ExpectedCondition<Boolean>) driver ->
                String.valueOf(((JavascriptExecutor) Objects.requireNonNull(driver))
                                .executeScript("return document.readyState"))
                        .equals("complete"));
    }

    public WebElement elementToBeClickable(WebElement elm) {
        return getWait().until(ExpectedConditions.elementToBeClickable(elm));
    }
}
