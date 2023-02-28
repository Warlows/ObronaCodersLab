@Operation
Feature:User Login on the shop and operation

  Scenario Outline:Shop account operation

    Given I'm on the main page
    And I sign in to account
    When I login  "jin4ster.pr1@gmail.com" and "terakonia84"
    And On the site i search Hummingbird Printed Sweater
    And I check if the discount is active
    Then I chose the size and quantity
    And Add to cart
    Then I go to checkout and confirm the address
    And I chose the payment method and option
    And I click order whit and doing a print screen
    Examples:
