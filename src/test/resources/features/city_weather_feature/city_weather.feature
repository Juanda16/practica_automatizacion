Feature: As a user I need to be able to get the weather of a city

  Scenario: Get the stability of the weather API
    Given the user is on the weather page
    When the user enters a city
    Then the user should see the status code 200

  Scenario Outline: Get the temperature of "<city>"
    Given the user is on the weather page
    When the user enters "<city>"
    Then the user should see the temperature

    Examples:
      | city         |
      | Cali         |
      | Bogota       |
      | Medellin     |
      | Cartagena    |
      | Barranquilla |
      | Santa Marta  |
