package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RadioButtonOptions {

        public static void main(String[] args) {
            // Set the path to the WebDriver executable (ChromeDriver in this case)
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Create a new instance of ChromeDriver
            WebDriver driver = new ChromeDriver();

            // Navigate to the Amazon Language Settings page
            driver.get("https://www.amazon.com/customer-preferences/edit?ie=UTF8&preferencesReturnUrl=%2Fref%3Dnav_logo&ref_=topnav_lang_ais");

            // Find all the language options on the page
            List<WebElement> languageOptions = driver.findElements(By.cssSelector("div[id*='lang'] span.a-label"));

            // Verify all the language options are correct
            assertTrue(verifyLanguageOptions(languageOptions));

            // Close the browser
            driver.quit();
        }


        public static boolean verifyLanguageOptions(List<WebElement> languageOptions) {
            // Expected language options
            String[] expectedOptions = {
                    "English - EN - Translate",
                    "العربية - AR - الترجمة",
                    "简体中文 - ZH-CN - 翻译",
                    "繁體中文 - ZH-TW - 翻譯",
                    "Nederlands - NL - Vertaling",
                    "Français - FR - Traduction",
                    "Deutsch - DE - Übersetzung",
                    "Bahasa Indonesia - ID - Terjemahan",
                    "Italiano - IT - Traduzione",
                    "日本語 - JA - 翻訳",
                    "한국어 - KO - 번역",
                    "Português - PT - Tradução",
                    "Español - ES - Traducción",
                    "Türkçe - TR - Çeviri"
            };

            if (languageOptions.size() != expectedOptions.length) {
                return false;
            }

            for (int i = 0; i < expectedOptions.length; i++) {
                String actualOption = languageOptions.get(i).getText().trim();
//                String actualValue = languageOptions.get(i).getAttribute("value");

                if (!actualOption.equals(expectedOptions[i])) {
                    return false;
                }
            }

            return true;
        }
    }