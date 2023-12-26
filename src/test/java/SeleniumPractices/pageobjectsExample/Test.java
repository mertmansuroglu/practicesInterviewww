package SeleniumPractices.pageobjectsExample;

import groovy.util.logging.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test {
    WebDriver driver;
    @org.testng.annotations.Test
    public void testLogin()
    {   driver=new EdgeDriver();
        LoginPage L= new LoginPage(driver);
        Assert.assertTrue(L.login());
    }
}
