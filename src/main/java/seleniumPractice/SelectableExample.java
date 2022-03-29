package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SelectableExample {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/selectable.html");
    }

    public void selectTheFirstThreeElements() {
        List<WebElement> allElements = driver.findElements(By.cssSelector("#selectable > li"));
        int listSize = allElements.size();
        System.out.println("Number of elements: " + listSize);
        Actions actions = new Actions(driver);
        /*Two Ways
        actions.keyDown(Keys.CONTROL)
                .click(allElements.get(0))
                .click(allElements.get(1))
                .click(allElements.get(2))
                .build().perform();*/
        actions.clickAndHold(allElements.get(0))
                .clickAndHold(allElements.get(1))
                .clickAndHold(allElements.get(2))
                .build().perform();
        driver.quit();
    }

    public static void main(String[] args) {
        SelectableExample run = new SelectableExample();
        run.openUrl();
        run.selectTheFirstThreeElements();
    }
}
