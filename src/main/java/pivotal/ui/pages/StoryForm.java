package pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StoryForm extends BasePage{

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//div[@class='container droppable tn-panelWrapper___fTILOVmk']")
    WebElement storyForm;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//form[@class='story model']//textarea[@aria-label='story title']")
    WebElement nameStory;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//div[contains(text(),\"Add a description\")]")
    WebElement descriptionStory;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//div[@data-aid='Tasks']//span[contains(text(),\"Add a task\")]")
    WebElement taskStory;

    @FindBy(xpath = " //div[starts-with(@id,'panel_backlog')]//textarea[starts-with(@id,'comment-edit-')]")
    WebElement activityStory;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(storyForm));
    }


    public void createStory() {
    }

    private void addNameStory() {
        nameStory.sendKeys();
    }
    private void addDescriptionStory() {
        descriptionStory.sendKeys();
    }
    private void addTaskStory() {
        taskStory.sendKeys();
    }
    private void addActivityStory() {
        activityStory.sendKeys();
    }
}
