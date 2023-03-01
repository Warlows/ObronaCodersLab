
Feature:User Login on the shop and operation

  Scenario Outline:Shop account operation

    Given On the login page
    And I login  "jin4ster.pr1@gmail.com" and "terakonia84"
    When I user page i go clothes
    And  I click Hummingbird printed sweater
    Then I chose the <size> and "<quantity>"
    And Add to cart
    Then go steps on buy
    And I doing a screenshot
    And Confirm buy
    Examples:
    |size |quantity |
    |M    |5        |