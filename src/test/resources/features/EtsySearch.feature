Feature:Etsy search feature
  Agile Story: User should be able to enter search terms and see relevant results in the page and in the title

  Background:User is on the etsy home page
    Given  User is on the etsy home page


  Scenario: Title verification
    Then User should see title is as expected
  @etsywip
  Scenario: Title verification after search term
    When User searches "Wooden spoon" in the search box
    And User clicks tosearch button
    Then User should see "Wooden spoon" in the Etsy title