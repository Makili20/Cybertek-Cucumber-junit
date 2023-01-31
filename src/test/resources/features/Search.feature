Feature: Search
  Agile story:As I User,I should be able to search when I am on Google search page

Background: User shoul be on Google search page
  Given User is on the google search page

  Scenario: Google default title verification
    Then User should see title is Google


Scenario: Google title verification after search
  When user searches apple
  Then user should see apple in the google title

  Scenario: Google title verification after search
      When user searches "peach"
      Then user should see "peach" in the google title
  @wip
Scenario: Google search page -About-link title verification
  Then User should see about link
  And User click to About link
  Then User should see title Google - About Google,Our Culture & Company News