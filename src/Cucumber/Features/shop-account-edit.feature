@shop
Feature: User Login it the shop and edit account


  Scenario Outline: User adds  address email and password to the account
    Given I'm on the shop main page
    When I sign in
    And I login using "jin4ster.pr1@gmail.com" and "terakonia84"
    And I open my address page
    And I enter new address "<Alias>", "<Address>", "<City>", "<Postal code>","<Country>", "<Phone>"
   Then I check the correct data in the address
#   And I delete new address
#   And I can see new address delete*

    Examples:
      |Alias     |Address   |City   |Postal code |Country     |Phone         |
      |Alias01   |Dog       |Szczec |71-830      |Pol         |555-444-333   |
      |Alias02   |Fog       |Starg  |70-830      |Pol         |333-444-555   |





