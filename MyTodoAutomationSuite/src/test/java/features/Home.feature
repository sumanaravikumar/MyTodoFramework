Feature: MyTodo Management Functionality

  @regression @runAll
  Scenario: User successfully adds single Todo
    Given User lands in the home page of application
    When User keys in todoName and press Enter
    Then Verify Todo is added successfully

  @regression @runAll
  Scenario: User successfully adds multiple Todos
    Given User lands in the home page of application
    When User keys in multiple todoNames and press Enter
    Then Verify multiple Todos are added successfully

  @runAll
  Scenario: User successfully mark Todo as completed
    Given User lands in the home page of application
    When User keys in multiple todoNames and press Enter
    Then User mark todo as completed
    And Verify count of pending task

  @regression @runAll
  Scenario: User successfully delete Todo from the list
    Given User lands in the home page of application
    When User keys in multiple todoNames and press Enter
    Then User delete Todo
    And Verify count of pending task

  @runAll
  Scenario: User successfully clear completed todo
    Given User lands in the home page of application
    When User keys in multiple todoNames and press Enter
    When User mark todo as completed
    Then User click on Clear Completed button
    And Verify todo removal from the list

  @regression @runAll
  Scenario: User count Active todos
    Given User lands in the home page of application
    When User keys in multiple todoNames and press Enter
    When User mark todo as completed
    Then User click on Active button and verify count
