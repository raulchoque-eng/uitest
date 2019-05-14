package steps;

import cucumber.api.java.en.Given;
import org.testng.annotations.Test;
import pivotal.ui.pages.AppPage;
import pivotal.ui.pages.PageTransporter;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * AppPage class
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

    @Test
    @Given("^I have a Project with name \"([^\"]*)\"$")
    public void createProjectForAPI(String nameProject) {

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", nameProject);

        given().
            header("X-TrackerToken", "65fb37c3caad0c00c3acf0158f15f6c7").
            contentType(JSON).
            body(jsonAsMap).
        when().
            post("https://www.pivotaltracker.com/services/v5/projects").
        then().
            assertThat().
            statusCode(200).
            log().
            body().
        and().
            contentType(JSON);
    }
}
