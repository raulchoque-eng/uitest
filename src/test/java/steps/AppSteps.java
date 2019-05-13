package steps;

import cucumber.api.java.en.Given;
import pivotal.ui.pages.AppPage;
import pivotal.ui.pages.PageTransporter;

/**
 * AppSteps class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class AppSteps {

    PageTransporter pageTransporter = PageTransporter.getInstance();

    //Page
    AppPage appPage;

    @Given("^I go to app web page$")
    public void goToAppWebPage() {
        appPage = pageTransporter.navigatePivotalTrackerPage();
    }
}
