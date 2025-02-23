Feature: Scenario Outline practice

  @google_Search_outline
  Scenario Outline:
    Given user is on Google search page
    When user search for "<country>"
    Then user should see the "<capital>" in the results


    Examples:
    |country    | capital     |
    |Azerbaijan | Baku        |
    |Ukraine    | Kyiv        |
    |Afghanistan| Kabul       |
    |Usa        |Washington DC|
    |Turkey     |Ankara       |
    |Uzbekistan |Tashkent     |
    |Georgia    |Atlanta      |