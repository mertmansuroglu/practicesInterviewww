package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TableXpath {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new EdgeDriver();
        driver.get("https://en.wikipedia.org/wiki/Dell");
        WebElement scrollPart=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollPart);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(scrollPart)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(3000);


        //write all rows!!!
        List<WebElement> rows= driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter'] /tbody/tr"));
        WebElement firstRowThirdData=  driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter'] /tbody/tr[1] /td[3]"));
        List<WebElement> NinthRowData=  driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter'] /tbody/tr[9] /td"));
        for(WebElement element:rows){
            System.out.println(element.getText()+"\n");
        }
        System.out.println("------------------------------------------- \n");
        //Write ninth row data !!!!
        for(WebElement element:NinthRowData){
            System.out.println(element.getText()+"\n");
        }
        //you can also add assertion
        driver.quit();
    }
}
