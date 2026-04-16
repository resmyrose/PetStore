@tag
Feature: Find Purchase Order by Id
 @GetByIdTest_01
  Scenario Outline: Check admin able to retrieve Order by ID
    Given Admin creates GET request for Order by ID
    When Admin sends GET http request with endpoint and  ID
    Then Admin receives 200 ok with details of the order id

    Examples: 
     |             scenarioName                   |
     |        Find Purchase Order by Id           | 