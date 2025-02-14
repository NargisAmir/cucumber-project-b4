Feature:Docuport Login Logout Feature
   @test1 @test2
  Scenario: Login as a client
    Given user is on Docuport login page
    When user enters username for Client
    And User enters password for client
    And user clicks login button
    Then user should be able to see the home for client

     @test1 @test2
     Scenario: Nadir is cool
       Given Nadir is best
       When Nadir gets angry
       Then Nadir is still best