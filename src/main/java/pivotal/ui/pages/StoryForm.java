package pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotal.entities.Story;

/**
 * AppPage class
 *
 * @author raulchoque
 * @version 0.0.1
 */
public class StoryForm extends BasePage{

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//div[@class='container droppable tn-panelWrapper___fTILOVmk']")
    WebElement storyForm;

    @FindBy(xpath = "//div[@id='sidebar_area']//div[@class='panels']//ul//li[@title='Epics']")
    WebElement areaPanel;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//div[@class='container droppable tn-panelWrapper___fTILOVmk']//button[starts-with(@id,'story_close')]")
    WebElement saveBtn;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//form[@class='story model']//textarea[@aria-label='story title']")
    WebElement nameStory;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//section[@class='description full']//div[@data-aid='renderedDescription']")
    WebElement openDescriptionStoryAreatext;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//section[@class='description full']//textarea[@data-aid='textarea']")
    WebElement descriptionStory;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//div[@data-aid='Tasks']//span[contains(text(),\"Add a task\")]")
    WebElement taskStory;

    @FindBy(id = "blocker-edit-new")
    WebElement taskTextEdit;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//textarea[starts-with(@id,'comment-edit-')]")
    WebElement activityStory;

    @FindBy(xpath = "//div[starts-with(@id,'panel_backlog')]//div[@class='container droppable tn-panelWrapper___fTILOVmk']//div[@class='tn-panel__loom']//span[contains(text(), \"New Story test\")]")
    WebElement nameNewStory;


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(storyForm));
    }


    public void createStory(Story story) {
        nameStory.click();
        nameStory.sendKeys(story.getName());
        openDescriptionStoryAreatext.click();
        descriptionStory.sendKeys(story.getDescription());
        saveBtn.click();
    }

    public String getNameStory() {
        return nameNewStory.getText();
    }

}
