Feature: Passing multiple parameters to the same step

  @google_search_data_table @smoke @headless
  Scenario: Searching multiple items
    Given user in on Google search page
    Then user searches the following items
      |item|
      | loop academy |
      | java         |
      | selenium     |
      | cucumber bdd |
      | sql          |
      | Pavlo        |
      | Kate         |
    And we love Loop Academy

     # option + command + L  - mac
     # CTRL + ALT + L        - window
