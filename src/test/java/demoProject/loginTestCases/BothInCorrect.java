package demoProject.loginTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BothInCorrect {
    public void loginWithBothInCorrect() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin1");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin1");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        driver.quit();
    }
}
