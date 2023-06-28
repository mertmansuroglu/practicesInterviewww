package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FindBrokenLinks {

    public static void main(String[] args) {
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
        List<WebElement> LINKS= driver.findElements(By.tagName("a"));
        System.out.println("size is "+LINKS.size());

        for(WebElement e: LINKS){
            String url= e.getAttribute("href");
            checkBrokens(url);
        }
        driver.quit();
    }
    public static void checkBrokens(String linkUrl){
        try{
            URL url= new URL(linkUrl);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>=400)
            {
                System.out.println("Broken link is"+linkUrl+"response message is"+httpURLConnection.getResponseMessage());
            }else{
                System.out.println(linkUrl+"not broken"+httpURLConnection.getResponseMessage());
            }
        }catch (Exception e){

        }
    }
}
