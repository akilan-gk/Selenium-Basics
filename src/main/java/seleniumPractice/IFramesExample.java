package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IFramesExample {
    WebDriver driver;

    public WebElement findElement(String id) {
        return driver.findElement(By.id(id));
    }

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/frame.html");
    }

    public void handleFrames() {
        driver.switchTo().frame(0);
        findElement("Click").click();
        System.out.println(findElement("Click").getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame("frame2");
        findElement("Click1").click();
        System.out.println(findElement("Click1").getText());
        driver.switchTo().defaultContent();
        List<WebElement> totalFramesInThePage = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of frames in the page: " + totalFramesInThePage.size());
        driver.quit();
    }

    public static void main(String[] args) {
        IFramesExample run = new IFramesExample();
        run.openUrl();
        run.handleFrames();
    }
}
