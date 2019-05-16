package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pivotal.api.ProjectAPI;
import pivotal.entities.Project;
import pivotal.ui.pages.ProjectPage;

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
public class ProjectSteps {

    private ProjectPage projectPage = new ProjectPage();
    private Project project;

    public ProjectSteps(Project project) {
        this.project = project;
    }

    @When("^I open the Project from Project Dashboard page$")
    public void navigateToProjectDashboardPage() {
        projectPage.goIntoProject();
    }

    @When("^I open the Story form from Current Operation and Backlog panel in the Project page$")
    public void openStoryForm() {
        projectPage.goStoryForm();
    }

    @Given("^I have a Project with name \"([^\"]*)\"$")
    public void createProjectForAPI(String nameProject) {
        project.setName(nameProject);
        ProjectAPI.createProject(project);
    }
}
