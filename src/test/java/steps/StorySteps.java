package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pivotal.entities.Story;
import pivotal.ui.pages.StoryForm;
import static org.testng.Assert.assertEquals;

import java.util.Map;

/**
 * AppPage class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class StorySteps {

    StoryForm storyForm = new StoryForm();

    private Story story;

    public StorySteps(Story story) {
        this.story = story;
    }

    @When("^I add a new Story with the following data$")
    public void openStoryForm(Map<String,String> newStory) {

        story.setName(newStory.get("name_Story"));
        story.setDescription(newStory.get("description_Story"));
        story.setTask(newStory.get("task_Story"));
        story.setActivity(newStory.get("activity_Story"));

        storyForm.createStory(story);
    }

    @Then("^the name of new Story should be displayed on Current Operation and Backlog panel in the Project page$")
    public void validateNameNewStory() {
        assertEquals( story.getName(), storyForm.getNameStory());
    }
}
