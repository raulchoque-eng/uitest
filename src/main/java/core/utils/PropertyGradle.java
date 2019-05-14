package core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyGradle class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class PropertyGradle {

    private static PropertyGradle propertyGradle;
    private Properties properties;

    private PropertyGradle() {
        try(FileInputStream fileInputStream = new FileInputStream("gradle.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (FileNotFoundException fe){
            throw new RuntimeException(fe);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static PropertyGradle getInstance() {
        if (propertyGradle == null) {
            propertyGradle = new PropertyGradle();
        }
        return propertyGradle;
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }
}
