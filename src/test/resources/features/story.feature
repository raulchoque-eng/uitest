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