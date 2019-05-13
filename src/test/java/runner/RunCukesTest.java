package runner;

import core.selenium.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
/**
 * RunCukesTest class
 *
 * @author raulchoque
 * @version 0.0.1
 */
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"}, features = {"src/test/resources/features/story.feature"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    @AfterTest
    public void afterExecution() {
        WebDriverManager.getInstance().getWebDriver().close();
    }
}
