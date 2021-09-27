Feature: Visualize options select one and learn more about the trip

  Background: User wants to land on cruise search page
    Given User lands on carnival page
    When User closes offer modal
    And User closes cookie banner
    And User clicks on Sail To filter
    And User clicks on The Bahamas button
    And User clicks on Duration to filter
    And User clicks on six to nine Days button
    And User clicks on search cruises
    Then User lands on cruise search page

  @UserStory01
  Scenario: As a user I want to search cruises to The Bahamas with duration between 6 and 9 days
  so that I will visualize all the options to choose one. Right now, I don’t care about departure port.
    When User clicks on pricing filter
    And User slides minimum pointer
    And User slides maximum pointer
    Then The results are different
    Then User verifies that the prices are from cheapest to expensive

  @UserStory02
  Scenario: As a user I want to choose one sail and learn more about the trip,
  so that I will get more info about itinerary
    When User clicks on a trip
    Then User lands on itinerary page
    Then User verify additional info about every day
    Then User verify book now is placed into the page