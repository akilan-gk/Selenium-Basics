package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoCompletionExample {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/autoComplete.html");
    }

    public void interactWithAutoComplete() {
        WebElement autoCompleteTextBox = driver.findElement(By.id("tags"));
        Actions actions = new Actions(driver);
        actions.sendKeys(autoCompleteTextBox, "s").build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.cssSelector("#ui-id-1>li")));
        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals("Web Services")) {
                actions.click(option).build().perform();
                System.out.println("Selecting " + optionText);
                break;
            }
        }
        driver.quit();
    }

    public static void main(String[] args) {
        AutoCompletionExample run = new AutoCompletionExample();
        run.openUrl();
        run.interactWithAutoComplete();
    }
}
