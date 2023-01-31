Feature: Wiki title and search verifications

  Background: User is on the Wiki home page
    Given User is on the Wikipedia home page
@wiki
  Scenario: Search funcionality title verification
    When User types "Steve Jobs" in the wiki search box
    Then User should see "Steve Jobs" in the wiki title

  Scenario: Search funcionality header verification
    When User types "Steve Jobs" in the wiki search box
    Then User should see "Steve Jobs" in the main header