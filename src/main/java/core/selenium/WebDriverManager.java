package core.selenium;

import core.selenium.webDrivers.Browser;
import core.selenium.webDrivers.BrowserFactory;
import core.utils.PropertyGradle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * WebDriverManager class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class WebDriverManager {

    private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private BrowserFactory browsers;
    private PropertyGradle properties;

    private static WebDriverManager instance = null;

    /**
     * Constructor of page WebDriverManager.
     */
    private WebDriverManager() {
        initialize();
    }

    /**
     * Gets Instance of a WebElement.
     *
     * @return Instance of WebElement.
     */
    public static WebDriverManager getInstance() {
        if (instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    /**
     * Initializes the settings for the driver.
     */
    private void initialize() {
        browsers = new BrowserFactory();
        String nameBrowser = properties.getInstance().getBrowser();
        Browser firefox = browsers.getBrowser(nameBrowser);
        this.webDriver = firefox.initDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage()
                .timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(),
                webDriverConfig.getWaitSleepTime());
    }

    /**
     * Gets the WebDriver.
     *
     * @return WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets the WebDriver Wait.
     *
     * @return WebDriverWait.
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }
}
