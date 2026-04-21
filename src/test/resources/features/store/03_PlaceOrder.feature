@tag
Feature: Place an Order for purchasing the Pet
  I want to Order a pet from the store

  @PlaceOrderPetTest_01
  Scenario Outline: Successfully Place an Order for the pet with valid data

    Given Admin creates the POST request with "<scenarioName>"
    When Admin sends the POST request with valid data with "<scenarioName>"
    Then An Order is placed to the store and admin receives response code 200

    Examples: 
      | scenarioName                          |
      | Place Order for Pets with valid data  |
      | Place Order for Pets with valid data2 |
