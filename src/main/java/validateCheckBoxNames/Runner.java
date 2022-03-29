package validateCheckBoxNames;

public class Runner {
    public static void main(String[] args) {
        CheckBoxValidator check = new CheckBoxValidator();
        check.openBrowser();
        check.readTheDepartmentNames();
        check.isElementPresent();
        check.closeBrowser();
    }
}
