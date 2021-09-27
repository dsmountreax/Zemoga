Feature: Visualize options select one and learn more about the trip

  @UserStory01
  Scenario: As a user I want to search cruises to The Bahamas with duration
    Given User lands on carnival page
    When User closes offer modal
    And User closes cookie banner
    And User clicks on Sail To filter
    And User clicks on The Bahamas button
    And User clicks on Duration to filter
    And User clicks on six to nine Days button
    And User clicks on search cruises
    Then User lands on cruise search page
    When User clicks on pricing filter
    And User slides minimum pointer
    And User slides maximum pointer
    Then The results are different
    Then User verifies that the prices are from cheapest to expensive


