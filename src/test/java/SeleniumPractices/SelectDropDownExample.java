package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SelectDropDownExample {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F/");
        System.out.println(driver.getTitle());
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement element= driver.findElement(By.cssSelector("div.switch-account-type-reg"));

        FluentWait<WebDriver> waitf= new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(25));
        waitf.until(ExpectedConditions.visibilityOf(element));

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='businessaccount-radio']")));
        driver.findElement(By.xpath("//label[@for='businessaccount-radio']")).click();

        Select select= new Select(driver.findElement(By.id("businessCountry")));
        select.selectByVisibleText("Algeria");
        driver.quit();
    }
}
