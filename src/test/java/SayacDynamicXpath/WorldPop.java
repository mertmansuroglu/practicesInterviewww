package SayacDynamicXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WorldPop {
    public static void main(String[] args) {
        WebDriver driver= new EdgeDriver();
        driver.get("https://www.worldometers.info/world-population/");
//        System.out.println(webDriverWait.until(ExpectedConditions.visibilityOf(popSpan.get(1))).isDisplayed());
        //span secmek yerine degismeyen class i sectik hep ayni kaliyor cunku
        List<WebElement> popSpan = driver.findElements(By.xpath("//div[@class='maincounter-number'] /span[@class='rts-counter']"));
        List<WebElement> xpath_todays=driver.findElements(By.xpath("//div[text()='Today']//parent::div//span[@class='rts-counter']"));
        List<WebElement> xpath_thisYear=driver.findElements(By.xpath("//div[text()='This year']//parent::div//span[@class='rts-counter']"));
        List<WebElement> xpath_thisYearOrToday=driver.findElements(By.xpath(" //div[text()='This year' or text()= 'Today']//parent::div//span[@class='rts-counter']"));
       int a=0;
       while(a<20){
           for(WebElement e:xpath_thisYearOrToday)
           {
               System.out.println(e.getText());
           }
           a++;

       }
       driver.quit();

    }

    public static void getpopCount(WebDriver driver)
    {
        //asagidaki solution olmaz cunku surekli eleman yenileniyor ve stale elemente dusuyor
        //cunku spanler hep degisiyor!!!!
        while(true)
        {
            List<WebElement> popSpan = driver.findElements(By.xpath("//div[@class='maincounter-number'] /span/span"));
            for(WebElement el : popSpan){
                System.out.println(el.getText());
            }
            popSpan = driver.findElements(By.xpath("//div[@class='maincounter-number'] /span/span"));
        }
    }
}
