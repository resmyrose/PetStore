@tag
Feature: Delete Pet by Id

  @DeletePetByIdTest_01
  Scenario: Successfully delete the pet details by pet id
    Given Admin creates a DELETE pet by id request
    When Admin sends a DELETE request with valid endpoint
    Then The pet details are Deleted and admin receives response code 200
