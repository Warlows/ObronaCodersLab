
Feature: User Login on the shop and add new address


  Scenario Outline: User add new address on the account
    Given I'm on the shop main page
    When I sign in
    And I login using "jin4ster.pr1@gmail.com" and "terakonia84"
    And I open my address page
    And I enter new address "<Alias>, <Address>, <City>, <Postal_code>,<Country>, <Phone>
    Then success message with text "Address successfully added!"
#    And I delete new address
#    And New adress is delete
#    And I close Shop browser

    Examples:
      | Alias   | Address | City   | Postal_code | Country        | Phone       |
      | Aliassa | fog     | Szczec | 71-830      | United Kingdom | 555-444-333 |






