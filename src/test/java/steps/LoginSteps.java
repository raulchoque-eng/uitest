package steps;

import cucumber.api.java.en.Given;
import pivotal.ui.pages.LoginPage;
import pivotal.ui.pages.PageTransporter;

public class LoginSteps {

    PageTransporter pageTransporter = PageTransporter.getInstance();

    // Pages
    private LoginPage loginPage;

    @Given("^I log in with a valid password and username$")
    public void logIn() {
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.login();
    }
}
