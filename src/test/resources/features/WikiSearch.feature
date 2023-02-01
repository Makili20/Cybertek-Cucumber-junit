Feature: Wikipedia search functionality and verifications

  Background: User is on the Wiki home page
    Given User is on the Wiki home page


  Scenario: Search funcionality title verification
    When User types "Steve Jobs" in the wiki search page
    Then User should see "Steve Jobs" in the wiki title


  Scenario: Search funcionality header verification
    When User types "Steve Jobs" in the wiki search page
    Then USer should see "Steve Jobs" in the main header

  @wikiScenarioOutline
  Scenario Outline: Search funcionality header verification
    When User types "<searchValue>" in the wiki search page
    Then User should see "<expectedTitle>" in the wiki title
    Then USer should see "<expectedMainHeader>" in the main header
    Then USer should see "<expectedImageHeader>" in the image header

    Examples: example test data for wikipedia search
      | searchValue     | expectedTitle   | expectedMainHeader        | expectedImageHeader |
      | John Travolta   | John Travolta   | John Travolta             | John Travolta       |
      | Albert Einstein | Albert Einstein | Albert Einstein           | Albert Einstein     |
      | Bruce Lee       | Bruce Lee       | Bruce Lee                 |  Bruce Lee |