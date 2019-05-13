package pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppPage extends BasePage {

    @FindBy(css = "header.header__container")
    WebElement pivotalTrackerHeader;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pivotalTrackerHeader));
    }
}
