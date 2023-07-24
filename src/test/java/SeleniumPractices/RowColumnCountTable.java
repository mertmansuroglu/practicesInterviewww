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

//    public static By questionnairesContainer = By.xpath("//div[@class='cb-all-survey-section']");

//
//    public static By questionnairesStatusInLink = By.xpath("//span[starts-with(@class,'status-block')]");

//
//    public static By questionnairesStatusComponentForUserSurveyActive = By.xpath("//div[@class='mat-menu-content']//span[contains(text(),'Active')]");
//
//
//
//
//    public static By questionnairesProceedInLink = By.xpath("//td[@class='cell actions-cell'] /button");
//
//    public static By questionnairesSignOutInLink = By.xpath("//button[starts-with(@class,'btn-signout')]");
//

//    public static By questionnarieStatusection2InResponse = By.xpath("(//mat-cell[starts-with(@class, 'mat-cell cdk-column-status')])[3] /span");
//    public static By questionnarieShareButton = By.xpath(" //div[@class='survey-mi-left add-new-panel']/button");
//

//    public static By previewMenuItem = By.xpath("//a[text()=' Preview ']");
//
//    public static By previewMenuItemFinishButton = By.xpath("//button[text()='Submit'] ");
//    public static By payloadQeustionInPreview = By.xpath("//div[@class='cb-question-item-title']//p[contains(text(),'are you okay')]");
//
//    //button[text()='Finish']
//    public static By createQuestBtn = By.xpath("//button[@class='btn-new-survey mat-focus-indicator mat-menu-trigger mat-raised-button mat-button-base']");
//    public static By newQuestBtn = By.xpath("//button[text()='New Questionnaire']");
//    public static By createQuestDialogue = By.xpath("//h2[text()='Create Questionnaire']/ancestor::div[@class='cdk-overlay-pane']");
//    public static By createQuestNameField = By.xpath("//h2[text()='Create Questionnaire']/ancestor::div[@class='cdk-overlay-pane']//input[@formcontrolname='name']");
//    public static By ceoEvOption = By.xpath("//span[text()=' CEO Evaluation ']");
//    public static By ceoEvDropdown = By.xpath("//span[text()='No questionnaire type']");
//    public static By createQuestDateBtn = By.xpath("//input[@aria-label='datepicker']");
//    public static By dateSet = By.xpath("//span[text()='Set']");
//    public static By newQuestCreateBtn = By.xpath("//span[text()=' Create ']");
//    public static By createdQuestTitle = By.xpath("//input[@id='mat-input-1']");
//    public static By createdQuestRespondentsHeader = By.xpath("//input[starts-with(@class,'survey-name')]");
//    public static By addRespondendAimhBtn = By.xpath("//div[text()=' abc@aimh ']//parent::div[@class='cb-permissions-user-item ng-star-inserted']//button");
//    public static By previewQuestioanarieLabel = By.xpath("//h2[text()='Preview Questionnaire'] ");
//    public static By addRespondendSearchButton = By.xpath("(//div[@class='search-group'])[1] //button");
//    public static By respondentsSection = By.xpath("//a[@ng-reflect-router-link='respondents']");
//
//
//    //    (//div[@class='search-group'])[1] //button
//    public static By aimhRespondentAdded = By.xpath("//div[@class='cb-permissions-users-list']//div[text()='abc@aimh']");
//    public static By questEditBtn = By.xpath("//a[@ng-reflect-router-link='editor']");
//    public static By questEditAddSection = By.xpath("//span[text()=' Add New Section ']");
//    public static By questAddQuestion = By.xpath("//span[text()=' Add Question ']");
//    public static By singleLineQuestion = By.xpath("//span[text()='Single line text']");
//    //    public static By addQuestionTextBox = By.xpath("//body[@data-mce-placeholder='Enter your question text']");
//    public static By checkboxQuestion = By.xpath("//span[text()='Checkboxes']");
//    //span[text()='Checkboxes']
//    public static By checkboxQuestionChoice1 = By.xpath("//input[contains(@placeholder,'Choice 1')]");
//    public static By checkboxQuestionChoice2 = By.xpath("//input[contains(@placeholder,'Choice 2')]");
//    public static By checkboxQuestionAddChoiceButton = By.xpath("//a[contains(text(),'Add Choice')]");
//
//    public static By reopenButtonInResponses = By.xpath("//button[contains(text(),'Reopen')]");
//
//    public static By reOpenTextboxInResponses = By.xpath("//input[@formcontrolname='delete_confirm']");
//    //mat-cell[contains(text(),'horacio.jones@aimh')] /following-sibling::mat-cell[3]
//    public static By addQuestionTextBox = By.xpath("//body[@id='tinymce'][1]");
//    public static By addQuestionSave = By.xpath("//span[text()=' Save ']//parent::button");
//    public static By createadQuestion = By.xpath("//div[@class='cb-question-item-title']//p");
//    public static By frameById = By.xpath("//iframe[starts-with(@id,'tiny-angular_')][1]");
//
//    public static By frameByIdInpreviewQuestionnaire = By.xpath("//iframe");
//
//    public static By statusBtn = By.xpath("//div[@class='edit-survey-info-status']");
//    public static By statusGenericOptionsLocator = By.xpath("//span[@role='menuitem']");
//    public static By statusActiveMenuOption = By.xpath("//span[text()=' Active ']");
//
//

//    public static By createQuestCreateBtnDisabled = By.xpath("//button[@type='submit' and @disabled = 'true']");
//
//    public static By invitationNameTextboxInSettingsSection = By.xpath("//input[@ng-reflect-name='name']");
//
//    public static By submitButtonNext = By.xpath("//button[starts-with(@class,'btn-submit')]");
//
//    public static By selectRecipientsSection = By.xpath("//a[contains(text(),'Select Recipients')]");
//    public static By statusSection = By.xpath("//a[text()=' Status ']");
//
//    public static By selectRecipientsButton = By.xpath("//span[text()=' Select Recipients '] //parent::button");
//
//    public static By messageButton = By.xpath("//a[text()=' Message ']");
//
//    public static By selectRecipientsWholeCheckbox = By.xpath("//mat-header-cell[text()='user name'] /preceding-sibling::mat-header-cell /mat-checkbox");
//
//    public static By selectGroupWholeCheckbox = By.xpath("//mat-header-cell[text()='user name'] /preceding-sibling::mat-header-cell /mat-checkbox");
//
//    public static By selectGroupSection = By.xpath("//div[@role='tablist'] //div[text()='Groups']");
//
//    public static By searchButtonInRecipientsPopup = By.xpath("//button[starts-with(@class,'search')]");
//
//
//    public static By searchPlaceholderInGroupsSectionOfRecipients = By.xpath("(//mat-form-field  //input[@placeholder='Search'])[2]");
//
//    public static By respondedCountInShareSectionOfQuestionnaire = By.xpath("//div[text()=' Responded '] //parent::td //parent::tr //following-sibling::tr //td[2] /span");

//
//
//    public static By uploadPanel = By.xpath("//div[@class='upload-exhibit-half-width ng-star-inserted']");
//
//    public static By invitationStatusLabel(String status) {
//        return By.xpath("//span[text()='Invitation'] //parent::div //cb-survey-item-status[@ng-reflect-status='" + status + "']");
//
//    }
//
//    public static By surveyRespondStatus(String status) {
//        return By.xpath("//mat-header-cell[1] /parent::mat-header-row/following-sibling::mat-row[1] //mat-cell[5] //div[@ng-reflect-ng-switch='" + status + "']");
//
//    }
//
//    public static By sendButtonInMessage = By.xpath("//span[text()=' Send ']");
//
//    public static By recipientWithCheckbox(String whichuserRow) {
//        return By.xpath("//mat-table//mat-row[" + whichuserRow + "] //mat-cell[1]");
//
//    }
//
//    public static By recipientsSearchTableMailCell(String whichuserRow) {
//        return By.xpath("//mat-header-cell[1] /parent::mat-header-row/following-sibling::mat-row[" + whichuserRow + "] //mat-cell[3]");
//
//    }
//
//    //mat-table//mat-row[1] //mat-cell[1]
//    public static By recipientsSearchResult = By.xpath("//mat-table//mat-row[1] //mat-cell[2]");
//
//    public static By addUserAimhButtonForSurvey(String userAimh) {
//        return By.xpath("//div[@title='" + userAimh + "']//parent::div[@class='cb-groups-list-item ng-star-inserted'] //button");
//
//    }
//

