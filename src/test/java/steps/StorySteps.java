package steps;

import cucumber.api.java.en.When;
import pivotal.entities.Story;
import pivotal.ui.pages.StoryForm;

import java.util.List;
import java.util.Map;

public class StorySteps {

    StoryForm storyForm = new StoryForm();

    private Story story;

    public StorySteps(Story story) {
        this.story = story;
    }

    @When("^I add a new Story with the following data$")
    public void openStoryForm(List<Map<String,String>> stories) {
        // Populate entity information
//        story = storyList.get(0);
//
//        // Create StorySteps by UI
//        storyForm.createStory(story);

        storyForm.createStory();
    }
}
