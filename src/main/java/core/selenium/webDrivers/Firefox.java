package core.selenium.webDrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Firefox class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class Firefox implements Browser {

    @Override
    public WebDriver initDriver() {

        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}
