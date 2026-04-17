@tag
Feature: Delete Purchase Order by Id

  @DeleteOrderByIdTest_01
  Scenario Outline: 
    Check admin able to delete Order by ID

    Given Admin creates DELETE request for Order by ID
    When Admin sends DELETE request with "<scenarioName>"
    Then Admin receives 200 ok with order id details

    Examples: 
      | scenarioName                |
      | Delete Purchase Order by Id |
