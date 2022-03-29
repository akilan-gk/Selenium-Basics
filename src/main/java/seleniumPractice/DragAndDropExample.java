package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/drop.html");
    }

    public void dragAndDrop() {
        WebElement from = driver.findElement(By.cssSelector("#draggable"));
        WebElement to = driver.findElement(By.cssSelector("#droppable"));
        Actions actions = new Actions(driver);
        /*Two ways
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();*/
        actions.dragAndDrop(from,to).build().perform();
        driver.close();
    }

    public static void main(String[] args) {
        DragAndDropExample run = new DragAndDropExample();
        run.openUrl();
        run.dragAndDrop();
    }
}
