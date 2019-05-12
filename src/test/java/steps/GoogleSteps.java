package steps;

import cucumber.api.java.en.Given;
import pivotal.ui.pages.GooglePage;
import pivotal.ui.pages.PageTransporter;

/**
 * GoogleSteps class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class GoogleSteps {

    PageTransporter pageTransporter = PageTransporter.getInstance();

    private GooglePage googlePage;

    @Given("^I go to Google page$")
    public void iGoToGooglePage() {
        googlePage = pageTransporter.navigateGooglePageTest();
    }
}
