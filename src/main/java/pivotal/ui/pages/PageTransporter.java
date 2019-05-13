package pivotal.ui.pages;

import core.selenium.WebDriverManager;
import core.utils.AppJsonAccessor;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yesica on 06/05/2019.
 */
public class PageTransporter {

    private String baseURL =  AppJsonAccessor.getInstance().getBaseURL();
    private WebDriver webDriver;

    private static PageTransporter instance;

    /**
     * Constructor of page transporter.
     */
    protected PageTransporter() {
        initialize();
    }

    /**
     * Gets instance of SelectSiteUserConfig.
     *
     * @return the instance or a new instance.
     */
    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    /**
     * Initializes page transporter.
     */
    private void initialize() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Goes to the given URL.
     *
     * @param url - Site's URL.
     */
    private void goToURL(final String url) {
        try {
            webDriver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to PivotalTracker Page.
     *
     */
    public AppPage navigatePivotalTrackerPage() {
       goToURL(baseURL);
       return new AppPage();
    }
}
