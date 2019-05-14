package core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyWebDriver class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class PropertyWebDriver {

    private static PropertyWebDriver propertyWebDriver;
    private Properties properties;

    private PropertyWebDriver() {
        try(FileInputStream fileInputStream = new FileInputStream("web_driver.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (FileNotFoundException fe){
            throw new RuntimeException(fe);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static PropertyWebDriver getInstance() {
        if (propertyWebDriver == null) {
            propertyWebDriver = new PropertyWebDriver();
        }
        return propertyWebDriver;
    }

    public String getImplicitWaitTime() {
        return properties.getProperty("implicitWaitTime");
    }
    public String getExplicitWaitTime() { return properties.getProperty("explicitWaitTime"); }
    public String getWaitSleepTime() { return properties.getProperty("explicitWaitTime"); }
}
