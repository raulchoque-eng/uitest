Feature: Story manages.

  A story (called a “user story” by some practitioners) in Tracker is a short description
  of functionality or an incremental piece of capability that is of value to the customer
  or delivery team.

  Scenario: I should be able to create a new Story
    Given   I go to app web page
    And     I have a Project with name "Project to add a Story"
    And     I log in with a valid password and username
    When    I open the Project from Project Dashboard page
    And     I open the Story form from Current Operation and Backlog panel in the Project page
    And     I add a new Story with the following data
      |name_Story        | New Story test    |
      |blocker_Story     | none              |
      |description_Story | text description  |
      |label_Story       | none              |
      |task_Story        | activity_story    |
      |activity_Story    | text activity     |
    Then    the name of new Story should be displayed on Current Operation and Backlog panel in the Project page


