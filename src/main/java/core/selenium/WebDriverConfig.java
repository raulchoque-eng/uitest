package core.selenium;

import core.utils.PropertyGradle;
import core.utils.PropertyWebDriver;

/**
 * WebDriverConfig class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class WebDriverConfig {
    private static final String BROWSER = "browser";

    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;

    private static WebDriverConfig instance;

    /**
     * Constructor of page WebDriverConfig.
     */
    private WebDriverConfig() {
        initialize();
    }

    /**
     * Constructor of WebDriverConfig.
     * Gets WebDriverConfig as Singleton.
     *
     * @return a instance.
     */
    public static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    /**
     * Initializes WebDriverConfig.
     */
    private void initialize() {
        browser = System.getProperty(BROWSER);  //Get the browser system property
        PropertyWebDriver propertyWebDriver = PropertyWebDriver.getInstance();
        implicitWaitTime = Integer.parseInt(propertyWebDriver.getImplicitWaitTime());
        explicitWaitTime = Integer.parseInt(propertyWebDriver.getExplicitWaitTime());
        waitSleepTime = Integer.parseInt(propertyWebDriver.getWaitSleepTime());
    }

    /**
     * Gets the browser in which the tests are being executed.
     *
     * @return Browser.
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return The implicit time.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time set for the WebDriver.
     *
     * @return The explicit time.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Gets the sleep time wait set for the WebDriver.
     *
     * @return Sleep time wait.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
