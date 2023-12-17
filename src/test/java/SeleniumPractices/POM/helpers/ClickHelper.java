package SeleniumPractices.POM.helpers;

import SeleniumPractices.POM.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ClickHelper extends WaitHelper {

    private final static Logger log = LogManager.getLogger(HomePage.class);




    public void clickElement(WebElement element) {
        new ScrollHelper().scrollToElement(element);
        elementToBeClickable(element).click();
    }

    public void clickWithJavaScript(WebElement element) {
        var executor = new JavascriptHelper();
        executor.executeJavascript("arguments[0].click()", element);
    }
}
