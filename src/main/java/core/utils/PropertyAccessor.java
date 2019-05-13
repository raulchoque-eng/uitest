package core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyAccessor class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class PropertyAccessor {

    private static PropertyAccessor propertyAccessor;
    private Properties properties;

    private PropertyAccessor(String nameFile) {
        try(FileInputStream fileInputStream = new FileInputStream(nameFile)) {
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (FileNotFoundException fe){
            throw new RuntimeException(fe);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static PropertyAccessor getInstance(String nameFile) {
        if (propertyAccessor == null) {
            propertyAccessor = new PropertyAccessor(nameFile);
        }
        return propertyAccessor;
    }

    public String getProperty(String nameProperty) {
        return properties.getProperty(nameProperty);
    }
}
