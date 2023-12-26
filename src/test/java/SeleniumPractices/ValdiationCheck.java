package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ValdiationCheck {
    public static void main(String[] args) {
        WebDriver driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.linkedin.com/login");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Sign in')] ")))).isDisplayed());
        driver.findElement(By.id("username")).sendKeys("mert");
        driver.findElement(By.id("password")).sendKeys("mert");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//DIV[@error-for='username']")));
        Assert.assertEquals(driver.findElement(By.xpath("//DIV[@error-for='username'] ")).getText(),"Please enter a valid username","actual:"+driver.findElement(By.xpath("//DIV[@error-for='username'] ")).getText());
        driver.quit();
    }
}
