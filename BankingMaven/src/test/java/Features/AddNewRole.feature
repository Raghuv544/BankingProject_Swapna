#Author: Swapna
@tag
Feature: Primus Bank feature
  
  @tag1
  Scenario: Add New Role
    Given Admin Logs In to The application
    Then  Go to Roles Page
    When Click On New Role button
    Then Enter New Role Details
    Then Click Submit button
