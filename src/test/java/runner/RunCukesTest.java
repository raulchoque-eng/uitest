package runner;

import core.selenium.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

import static runner.GenerateReport.generateMasterReport;

/**
 * Created by Yesica on 06/05/2019.
 */
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"}, features = {"src/test/resources/features/test.feature"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    @AfterTest
    public void afterExecution() {
        WebDriverManager.getInstance().getWebDriver().close();
        generateMasterReport();
    }
}
