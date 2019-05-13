package core.selenium.webDrivers;

/**
 * BrowserFactory class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class BrowserFactory {

    public Browser getBrowser(String nameBrowser) {

        Browser browser;
        switch (nameBrowser.toUpperCase()) {
            case "FIREFOX" :
                browser = new Firefox();
                break;
            case "CHROME" :
                browser = new Chrome();
                break;
            default :
                System.out.println("Put a name Browser valid!!");
                browser = new Chrome();
                break;
        }
        return browser;
    }
}
