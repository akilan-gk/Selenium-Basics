package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowsHandlingExample {
    WebDriver driver;
    String homePageHandle;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/Window.html");
    }

    public void clickTheHomePageButtonAndClickTheEditButtonOnNewWindow() {
        WebElement openHomePageButton = driver.findElement(By.cssSelector("#home"));
        openHomePageButton.click();
        homePageHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String newWindow : allWindowHandles) {
            driver.switchTo().window(newWindow);
        }
        WebElement editButton = driver.findElement
                (By.cssSelector("ul.wp-categories-list>li:nth-child(1)>a"));
        editButton.click();
        driver.close();
    }

    public void clickTheMultipleWindowsButtonAndCountTheNumberOfWindows() {
        driver.switchTo().window(homePageHandle);
        WebElement openMultipleWindowsButton = driver.findElement
                (By.cssSelector(".large-6.small-12.columns > button[onclick='openWindows()']"));
        openMultipleWindowsButton.click();
        int numberOfWindowsOpened = driver.getWindowHandles().size();
        System.out.println("Number of windows opened: " + numberOfWindowsOpened);
    }

    public void clickTheDoNotCloseMeButtonAndCloseTheNewWindows() {
        WebElement doNotCloseMeButton = driver.findElement
                (By.cssSelector("button#color[onclick='openWindows();']"));
        doNotCloseMeButton.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String newWindow : allWindowHandles) {
            if (!newWindow.equals(homePageHandle)) {
                driver.switchTo().window(newWindow);
                driver.close();
            }
        }
    }

    public void clickTheWaitForFiveSecondsButtonToOpenNewWindows() {
        driver.switchTo().window(homePageHandle);
        WebElement waitForFiveSecondsButton = driver.findElement
                (By.cssSelector("button#color[onclick='openWindowsWithWait();']"));
        waitForFiveSecondsButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }

    public static void main(String[] args) {
        WindowsHandlingExample run = new WindowsHandlingExample();
        run.openUrl();
        run.clickTheHomePageButtonAndClickTheEditButtonOnNewWindow();
        run.clickTheMultipleWindowsButtonAndCountTheNumberOfWindows();
        run.clickTheDoNotCloseMeButtonAndCloseTheNewWindows();
        run.clickTheWaitForFiveSecondsButtonToOpenNewWindows();
    }
}
