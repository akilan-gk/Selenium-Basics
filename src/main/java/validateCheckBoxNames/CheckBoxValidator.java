package validateCheckBoxNames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;

public class CheckBoxValidator extends CommonFunctions {
    WebDriver driver;

    List<String> departmentNames = new ArrayList<>();

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }

    public void readTheDepartmentNames(){
        List<WebElement> departmentNamesLocators = driver.findElements(By.xpath(getNamesLocator()));
        for(WebElement individualElement : departmentNamesLocators){
            departmentNames.add(individualElement.getText());
        }
        //Adding these two names for failing cases
        departmentNames.add("Lokesh");
        departmentNames.add("Akilan");
        departmentNames.add("Men's Shoes");
    }

    public void isElementPresent() {
        for (String individualDepartmentName : departmentNames) {
            String locator = setLocatorText(individualDepartmentName);
            try {
                if (driver.findElement(By.xpath(locator)).isDisplayed()) {
                    System.out.println(individualDepartmentName + " is present in the website.");
                }
            } catch (NoSuchElementException exception) {
                System.out.println(individualDepartmentName + " is not present in the website.");
            }
        }
    }

    public String setLocatorText(String departmentName) {
        return String.format(getGenericLocatorToFindCheckBoxes(), departmentName);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
