//package SeleniumPractices;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class RowColumnCountTable {
//    //driver initialization
//    WebDriver driver = new EdgeDriver();
//    @Test
//    public void test() {
//        ;
//        Assert.assertTrue(checkIfFieldIsAvailableOnTable("Joe Root"));
//        driver.quit();text
//    }
//
//
//    public boolean checkIfFieldIsAvailableOnTable(String text) {
//        //default boolean value is false
//           boolean isValid = false;
//
//        try {
//            //get to the URL
//            driver.get("https://selectorshub.com/xpath-practice-page/");
//            //scroll to table
//            WebElement scroll= driver.findElement(By.xpath("//table[@id='resultTable'] "));
//            JavascriptExecutor js= (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView(true)",scroll);
//            //get total row and column count
//            int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
//            int column_count = driver.findElements(By.xpath("//table[@id='resultTable']//th")).size();
//            System.out.println((rowCount) + "//" + (column_count));
//            //having loop for finding the rolan mendel and verifying on the page
////            //table[@id='resultTable’]//tbody/tr[2]/td[4]  bu bizim actual value
//            for (int i = 0; i < rowCount; i++) {
//                for (int a = 1; a < column_count; a++) {
//                    String actVal = driver.findElement(By.xpath("//table[@id='resultTable'] /tbody/tr[" + (i + 1) + "]/td[" + a + "]")).getText();
//                    if (actVal.equals(text)) {
//                        isValid = true;
//                        System.out.println("the text is valid");
//                    }
//                }
//
//            }
//
//        }catch (Exception e){
//            driver.quit();
//        }
//            //first get to the url
//        return isValid;
//    }
//}
