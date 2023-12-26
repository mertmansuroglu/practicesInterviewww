package SeleniumPractices.pageobjectsExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final static Logger log = LogManager.getLogger(LoginPage.class);
    public WebDriver driver;
    private By username= By.id("USERNAME");
    private By PASSWORD= By.id("PASSWORD");
    private By SIGNIN= By.id("SIGNIN");
    private By SUCCESSlABEL= By.id("SUCCESSlABEL");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean login() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("login");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(25));
        FluentWait<WebDriver> fwait= new FluentWait<>(driver);
        wait.until(ExpectedConditions.elementToBeClickable(username));
        driver.findElement(username).sendKeys("mmm");
        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD));
        driver.findElement(PASSWORD).sendKeys("PPPP");
        driver.findElement(SIGNIN).click();
       return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSlABEL)).isDisplayed();
    }

}
