@B4G2A-122
Feature: Demo how to upload json report to xray


  @xray @B4G2A-178 @B4G2A-179
  Scenario: Login as a client
    Given user is on Docuport login page
    When user enters username for Client
    And User enters password for client
    And user clicks login button
    Then user should be able to see the home for client