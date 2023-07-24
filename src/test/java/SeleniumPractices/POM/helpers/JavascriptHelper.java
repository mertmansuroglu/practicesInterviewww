package SeleniumPractices.POM.helpers;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;

public class JavascriptHelper extends BasePage {

    public void executeJavascript(String script, Object... objects) {
        ((JavascriptExecutor) driver).executeScript(script, objects);
    }
}
