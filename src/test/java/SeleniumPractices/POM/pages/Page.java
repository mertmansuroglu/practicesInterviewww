package SeleniumPractices.POM.pages;

import SeleniumPractices.POM.base.BasePage;
import SeleniumPractices.POM.helpers.WaitHelper;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



public class Page extends BasePage {

    protected void initPage(){
        var ajax = new AjaxElementLocatorFactory(driver, getWaitTime());
        PageFactory.initElements(ajax, this);
        new WaitHelper().waitUntilPageLoad();
    }
}
