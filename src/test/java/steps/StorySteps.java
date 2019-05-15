package steps;

import cucumber.api.java.en.When;
import pivotal.entities.Story;
import pivotal.ui.pages.StoryForm;

import java.util.Map;

public class StorySteps {

    StoryForm storyForm = new StoryForm();

    private Story story;

    public StorySteps(Story story) {
        this.story = story;
    }

    @When("^I add a new Story with the following data$")
    public void openStoryForm(Map<String,String> newStory) {

        story.setName(newStory.get("name_Story"));
        System.out.println("test:" + story.getName());
        story.setDescription(newStory.get("description_Story"));
        System.out.println(story.getDescription());
        story.setTask(newStory.get("task_Story"));
        story.setActivity(newStory.get("activity_Story"));

        storyForm.createStory(story);
    }
}
