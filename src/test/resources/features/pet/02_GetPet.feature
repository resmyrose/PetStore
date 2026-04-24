@tag
Feature: Get Pet by Id

  @GetPetByIdTest_01
  Scenario: Successfully retrieve the pet details by pet id
    Given Admin creates a GET pet by id request
    When Admin sends a GET request with valid endpoint
    Then The pet details are retrieved and admin receives response code 200
