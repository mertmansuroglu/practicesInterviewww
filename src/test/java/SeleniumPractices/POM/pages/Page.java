package SeleniumPractices.POM.pages;

import base.BasePage;
import helpers.WaitHelper;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static base.BasePage.getWaitTime;

public class Page extends BasePage {

    protected void initPage(){
        var ajax = new AjaxElementLocatorFactory(driver, getWaitTime());
        PageFactory.initElements(ajax, this);
        new WaitHelper().waitUntilPageLoad();
    }
}
