
Feature:User Login on the shop and operation

  Scenario Outline:Shop account operation

    Given On the login page
    And I login  "jin4ster.pr1@gmail.com" and "terakonia84"
    When I user page i go clothes
    And  I click Hummingbird printed sweater
    Then I chose the <Size> and <Quantity>
    And Add to cart
    Then go steps on buy
    And Click
    And I click order whit and doing a print screen
    Examples:
    |Size |Quantity |
    |M    |5        |