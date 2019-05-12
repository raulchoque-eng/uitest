package pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * GooglePage class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class GooglePage extends BasePage{

    @FindBy(id="viewport")
    private WebElement googlePage;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(googlePage));
    }
}
