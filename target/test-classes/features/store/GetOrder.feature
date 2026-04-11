@tag
Feature: Returns Pet Inventories by Status
Returns a map of status codes to quantities

@GetOrderPetTest_01
 Scenario Outline:
 Returns a map of status codes to quantities
 
    Given Admin creates the GET request with "<scenarioName>"
    When Admin sends the GET request for Inventory with "<scenarioName>"
    Then Returns Pet Inventories by Status and Admin receives response code 200
    
    Examples: 
     |             scenarioName                   |
     |   Get store Inventory valid                | 