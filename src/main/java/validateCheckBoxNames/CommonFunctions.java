package validateCheckBoxNames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonFunctions {
    String userWorkingDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");

    public String configFilePath() {
        return userWorkingDirectory + pathSeparator + "src" + pathSeparator + "main" +
                pathSeparator + "java" + pathSeparator + "validateCheckBoxNames"
                + pathSeparator + "files" + pathSeparator + "config.properties";
    }

    public Properties getPropertiesObject() {
        Properties property = new Properties();
        try {
            FileInputStream file = new FileInputStream(configFilePath());
            property.load(file);
        } catch (FileNotFoundException exception) {
            System.out.println("The specified file is not present in the given path.");
        } catch (IOException exception) {
            System.out.println("Check the given path of the file");
        }
        return property;
    }

    public String getUrl() {
        return getPropertiesObject().getProperty("url");
    }

    public String getGenericLocatorToFindCheckBoxes() {
        return getPropertiesObject().getProperty("genericLocatorToFindCheckBoxes");
    }

    public String getNamesLocator() {
        return getPropertiesObject().getProperty("namesLocator");
    }
}
