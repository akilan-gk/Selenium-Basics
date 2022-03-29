package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractingWithImagesExample {
    WebDriver driver;

    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/Image.html");
    }

    public void clickOnTheImageToReachHomepage() {
        WebElement homeImage = driver.findElement
                (By.cssSelector(".innerblock>div:nth-child(1) .large-6.small-12.columns>img"));
        homeImage.click();
        WebElement imageElement = driver.findElement
                (By.cssSelector(".wp-categories-list>li:nth-child(4)>a"));
        imageElement.click();
    }

    public void findItsABrokenImageOrNot() {
        WebElement brokenImage = driver.findElement
                (By.xpath("//section[@class='innerblock']/div[2]/div/div/img"));
        if (brokenImage.getAttribute("naturalWidth").equals("0")) {
            System.out.println("Oops, the image is broken.");
        } else {
            System.out.println("The image is not broken.");
        }
        driver.quit();
    }

    public static void main(String[] args) {
        InteractingWithImagesExample run = new InteractingWithImagesExample();
        run.openUrl();
        run.clickOnTheImageToReachHomepage();
        run.findItsABrokenImageOrNot();
    }
}
