@LoginWithBackground
Feature: Login feature
  Agile Story: As I User,I should be able to login with correct credentials to
  different accounts And dashboard should be displayed.

#this is how you comment in feature file

  Background: User is on the login page
    Given User is on the login page
    #Then User sees title is library

  Scenario: Librarian login scenario
    When User logs in as librarian
    Then User should see dashboard

  Scenario: Student Login scenario
    When User logs in as student
    Then User should see dashboard

@db
  Scenario: Admin Login scenario
    When User logs in as admin
    Then User should see dashboard