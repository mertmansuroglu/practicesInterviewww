package SeleniumPractices;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        WebDriver driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://google.com");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> IT=windows.iterator();
        String first=IT.next();
        String second=IT.next();
        driver.switchTo().window(second).get("https://facebook.com");
        System.out.println(driver.getTitle());
        driver.switchTo().window(first);
        System.out.println(driver.getTitle());

    }
}
