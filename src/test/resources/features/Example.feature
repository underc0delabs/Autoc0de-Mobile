Feature: Basic Login

  @ExampleTag
  Scenario Outline: User login in ExampleApp
    Given the user is on the login screen of Example App
    When the user enter his credentials User Name: <username> and Password <password>
    And the user tap the Login button
    Then the user verifies that he was on the Welcome to Autoc0de screen
    Examples:
      | username                | password         |
      | validUsername@gmail.com | validPassword156 |
      | noValidUsername         | noValidPassword  |