package steps;

import cucumber.api.java.en.When;
import pivotal.ui.pages.ProjectPage;

public class ProjectSteps {

    private ProjectPage projectPage = new ProjectPage();

    @When("^I open the Project from Project Dashboard page$")
    public void navigateToProjectDashboardPage() {
        projectPage.goIntoProject();
    }


    @When("^I open the Story form from Current Operation and Backlog panel in the Project page$")
    public void openStoryForm() {
        projectPage.goStoryForm();
    }
}
