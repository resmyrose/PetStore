@tag
Feature: Returns Pet Inventories by Status
Verify Inventory is fetched successfully

@GetOrderPetTest_01
 Scenario Outline:
 Verify Inventory is fetched successfully
 
    Given Admin creates the GET request with "<scenarioName>"
    When Admin sends the GET request for Inventory with "<scenarioName>"
    Then Admin receives response code 200
    
    Examples: 
     |             scenarioName                   |
     |   Returns Pet Inventories by Status        | 