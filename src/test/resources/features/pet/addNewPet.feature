@tag
Feature: Add a new pet to the store
  I want to add a new pet to the store so that it is available in the store

  @AddNewPetTest_01
  Scenario Outline:
: Successfully add a new pet with valid data
    Given Admin creates a POST request with "<scenarioName>"
    When Admin sends a POST request with valid data with "<scenarioName>"
    Then A new pet is added to the store and admin receives response code 200
    Examples: 
     | scenarioName                             |
      | Add new pet to the store with valid data |
      | Add new pet to the store with valid data2 |

