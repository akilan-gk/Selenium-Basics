package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class HandlingHttpCertificationsExample {
    public static void main(String[] args) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.acceptInsecureCerts();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://leafground.com/pages/Window.html");
    }
}
