package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HandleCheckbox {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the web page
            driver.get("https://example.com");

            // Wait for elements to load (optional)
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Locate the checkbox element by its ID (change this based on your HTML)
            WebElement checkbox = driver.findElement(By.id("checkboxId"));

            // Verify if the checkbox is present and not selected
            if (checkbox.isDisplayed() && !checkbox.isSelected()) {
                // Click the checkbox
                checkbox.click();
                System.out.println("Checkbox clicked!");
            } else {
                System.out.println("Checkbox not found, not visible, or already selected.");
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., ElementNotFoundException, TimeoutException, etc.)
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }


public void test()
{


  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

          // Initialize ChromeDriver
          WebDriver driver = new ChromeDriver();

          try {
          // Navigate to the web page
          driver.get("https://example.com");

          // Wait for elements to load (optional)
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          // Locate and fill the 24th field
          WebElement field24 = driver.findElement(By.id("field24"));
          field24.sendKeys("Data for Field 24");

          // Use WebDriverWait to wait for the auto-population of the 25th field
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

          // Wait until the 25th field is visible and has a non-empty value
          WebElement field25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field25")));
          wait.until(ExpectedConditions.attributeToBeNotEmpty(field25, "value"));

          // Retrieve the auto-populated value from the 25th field
          String autoPopulatedValue = field25.getAttribute("value");

          // Print the auto-populated value
          System.out.println("Auto-populated value in Field 25: " + autoPopulatedValue);

          // Optionally, perform additional actions with the auto-populated data

          } catch (Exception e) {
          e.printStackTrace();
          } finally {
          // Close the browser
          driver.quit();
          }
          }
}






























