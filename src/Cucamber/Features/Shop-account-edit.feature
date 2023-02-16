@shop
Feature: Complete teh user data

  @edit
  Scenario: User adds first address and data to the account
    Given I'm on shop main page
    When I go to login page
    And I login using "jin4ster.pr1@gmail.com and "terakonia84"
    And I go to add first address
    When I add new address
    And I enter new address "Alias", "Address", "City", "Zip/postal code", "Phone"
    Then I check the correct data in the address
#   And I delete new address
#   And I can see new address delete*


