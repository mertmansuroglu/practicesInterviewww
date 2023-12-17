package SeleniumPractices.POM.helpers;


import SeleniumPractices.POM.base.BasePage;

public class SwitchHelper extends BasePage {

    public void switchToWindow() {
        driver.close();
        driver.getWindowHandles()
                .forEach(w -> driver.switchTo().window(w));
    }

}
