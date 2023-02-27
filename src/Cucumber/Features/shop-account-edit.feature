@shop
Feature: User Login it the shop and edit account


  Scenario Outline: User adds  address email and password to the account
    Given I'm on the shop main page
    When I sign in
    And I login using "jin4ster.pr1@gmail.com" and "terakonia84"
    And I open my address page
    And I enter new address <Alias>, <Address>, <City>, <Postal_code>,<Country>, <Phone>
   Then I can see success message whit text "Your data has been created."
   And I delete new address
   And I can see new address delete*

    Examples:
      |Alias     |Address   |City   |Postal_code |Country         |Phone         |
      |Alias01   |Dog       |Szczec |71-830      |United Kingdom  |555-444-333   |






