package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipHandling {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/css/css_tooltip.asp");
    }

    public void getToolTipText() {

        WebElement ageLinkElement = driver.findElement(By.cssSelector(".tooltip"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ageLinkElement);
        actions.perform();
        WebElement toolTip = driver.findElement(By.cssSelector(".tooltiptext.tooltip-top"));
        String toolTipText = toolTip.getText();
        System.out.println("Tool Tip Text: " + toolTipText);
        driver.quit();
    }

    public static void main(String[] args) {
        ToolTipHandling run = new ToolTipHandling();
        run.openUrl();
        run.getToolTipText();
    }
}
