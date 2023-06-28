package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTable {
   WebDriver driver= new FirefoxDriver();
    @Test
    public void testTableItem()
    {
        Assert.assertTrue(checkTable("Joe Root"));
        driver.quit();
    }

    public boolean checkTable(String text)
    {   boolean isValid=false;
        try {
            driver.get("https://selectorshub.com/xpath-practice-page/");
            WebElement elementScroll=driver.findElement(By.xpath("//table[@id='resultTable']"));
            JavascriptExecutor js=  (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true)",elementScroll);
            int rowCount=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
            int columnCount=driver.findElements(By.xpath("//table[@id='resultTable']//th")).size();
            System.out.println("row count is:"+rowCount+"///"+"column count is"+columnCount);
            for(int i=1;i<rowCount;i++){
                for(int a=1;a<columnCount;a++)
                {

                    String actVal=driver.findElement(By.xpath("//table[@id='resultTable'] /tbody/tr[ex]/td[" + a + "]")).getText();
                    if(actVal.equals(text))
                    {
                        isValid=true;
                        System.out.println("the desired text is valid");
                    }
                }
            }
        }catch (Exception e)
        {
            driver.quit();
        }

      return isValid;
    }
}
