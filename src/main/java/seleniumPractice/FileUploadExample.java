package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class FileUploadExample {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://leafground.com/pages/upload.html");
    }

    public void clickUploadButton() {
        WebElement uploadButton = driver.findElement(By.name("filename"));
        Actions actions = new Actions(driver);
        actions.click(uploadButton).build().perform();
    }

    public void uploadTheFile() throws AWTException, InterruptedException {
        /*Another type
        uploadButton.sendKeys("C:\\Users\\akilan.kanagarajan\\Downloads\\testleaf.xlsx");*/

        String path = "C:\\Users\\akilan.kanagarajan\\Downloads\\testleaf.xlsx";
        StringSelection selection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(350);
        driver.quit();
    }

    public static void main(String[] args) throws AWTException, InterruptedException {
        FileUploadExample run = new FileUploadExample();
        run.openUrl();
        run.clickUploadButton();
        run.uploadTheFile();
    }
}
