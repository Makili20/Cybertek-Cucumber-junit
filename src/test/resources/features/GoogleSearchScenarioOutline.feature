Feature: Search
  Agile story:As I User,I should be able to search when I am on Google search page

  @scenarioOutline
  Scenario Outline: Google title verification after search
    Given User is on the google search page
    When user searches "<searchValue>"
    Then user should see "<expectedTitle>" in the google title

    Examples: Search values I want to search in Google
      | searchValue | expectedTitle |
      | apple       | apple         |
      | kiwi        | kiwi          |