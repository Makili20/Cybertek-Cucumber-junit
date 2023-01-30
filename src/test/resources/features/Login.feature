@Login
Feature: Login feature
  Agile Story: As I User,I should be able to login with correct credentials to
  different accounts And dashboard should be displayed.

#this is how you comment in feature file
@Librarian @Employee @Sunday
  Scenario: Librarian login scenario
    Given User is on the login page
    When User logs in as librarian
    Then User should see dashboard
  @Student
  Scenario: Student Login scenario
    Given User is on the login page
    When User logs in as student
    Then User should see dashboard
  @Admin @Employee @Sunday
  Scenario: Admin Login scenario
    Given User is on the login page
    When User logs in as admin
    Then User should see dashboard