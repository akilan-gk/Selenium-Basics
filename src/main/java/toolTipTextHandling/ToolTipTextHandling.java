package toolTipTextHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipTextHandling {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/tooltip.html");
    }

    public void getToolTipTextUsingAttribute() {
        WebElement nameTextBox = driver.findElement(By.cssSelector("#age"));
        String toolTipText = nameTextBox.getAttribute("title");
        System.out.println("The tool tip text displayed:(Get Attribute) " + toolTipText);
    }

    public void getToolTipTextUsingActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#age"))).build().perform();
        WebElement locationOfText = driver.findElement(By.cssSelector(".ui-helper-hidden-accessible"));
        String toolTipText = locationOfText.getText();
        System.out.println("The tool tip text displayed:(Actions Class) " + toolTipText);
        driver.quit();
    }

    public static void main(String[] args) {
        ToolTipTextHandling run = new ToolTipTextHandling();
        run.openUrl();
        run.getToolTipTextUsingAttribute();
        run.getToolTipTextUsingActions();
    }
}
