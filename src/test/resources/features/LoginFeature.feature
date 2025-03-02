
Feature:Docuport Login Logout Feature

  Background: this is for navigation Docuport login page
    Given user is on Docuport login page


  @smoke
  Scenario: Login as a client
   # Given user is on Docuport login page
    When user enters username for Client
    And User enters password for client
    And user clicks login button
    Then user should be able to see the home for client

  @smoke
     Scenario: Login as a employee
      When user enters username for employee
       And User enters password for employee
       And user clicks login button
       Then user should be able to see the home for employee

  @smoke
  Scenario: Login as a advisor
    When user enters username for advisor
    And User enters password for advisor
    And user clicks login button
    Then user should be able to see the home for advisor

  @smoke
  Scenario: Login as a supervisor
    When user enters username for supervisor
    And User enters password for supervisor
    And user clicks login button
    Then user should be able to see the home supervisor

    @dataTableLogin @smoke
    Scenario: Login as a client Map practice
      When user enters credentials
      |username|b1g1_client@gmail.com|
      |password|Group1               |
      Then user should be able to see the home for client
