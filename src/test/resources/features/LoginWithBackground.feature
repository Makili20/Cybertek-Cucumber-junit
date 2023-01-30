@LoginWithBackground
Feature: Login feature
  Agile Story: As I User,I should be able to login with correct credentials to
  different accounts And dashboard should be displayed.

#this is how you comment in feature file

  Scenario: Librarian login scenario
    Given User is on the login page
    When User logs in as librarian
    Then User should see dashboard

  Scenario: Student Login scenario
    Given User is on the login page
    When User logs in as student
    Then User should see dashboard

  Scenario: Admin Login scenario
    Given User is on the login page
    When User logs in as admin
    Then User should see dashboard