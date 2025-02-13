$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\java\\stories\\abc.feature");
formatter.feature({
  "name": "Todos Management website test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add todo task",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User navigation to the todo management website",
  "keyword": "Given "
});
formatter.match({
  "location": "loginsteps1.userNavigationToTheTodoManagementWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter name on todo field",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.enterNameOnTodoField()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be click on enter button",
  "keyword": "And "
});
formatter.match({
  "location": "loginsteps1.userShouldBeClickOnEnterButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify generated todo name",
  "keyword": "And "
});
formatter.match({
  "location": "loginsteps1.verifyGeneratedTodoName()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Count of todo",
  "keyword": "And "
});
formatter.match({
  "location": "loginsteps1.verifyCountOfTodo()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add multiple todos",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User navigate to the todo management website",
  "keyword": "Given "
});
formatter.match({
  "location": "loginsteps1.userNavigateToTheTodoManagementWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should create multiple todos",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userShouldCreateMultipleTodos()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Counts of todos",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.verifyCountsOfTodos()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Mark a Todo as completed",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User navigatev to the todo  website",
  "keyword": "Given "
});
formatter.match({
  "location": "loginsteps1.userNavigatevToTheTodoWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should create 4 todos",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userShouldCreateTodos(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should mark completed Todo",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userShouldMarkCompletedTodo()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete Todo with assert verify",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User Navigate to the todo websiteA",
  "keyword": "Given "
});
formatter.match({
  "location": "loginsteps1.userNavigateToTheTodoWebsiteA()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User add todo",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userAddTodo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User delete todo",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userDeleteTodo()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Count the number of completed Todos",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User Navigatev to the todo websiteB",
  "keyword": "Given "
});
formatter.match({
  "location": "loginsteps1.userNavigatevToTheTodoWebsiteB()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User add todoB",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userAddTodoB()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify completed todo count",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.verifyCompletedTodoCount()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Count of all the Todos present",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User Navigatev to the todo websiteC",
  "keyword": "Given "
});
formatter.match({
  "location": "loginsteps1.userNavigatevToTheTodoWebsiteC()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User add todoC",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userAddTodoC()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the all tab todo count",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.verifyTheAllTabTodoCount()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Count of pending Todos",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User Navigatev to the todo websiteD",
  "keyword": "Given "
});
formatter.match({
  "location": "loginsteps1.userNavigatevToTheTodoWebsiteD()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User add todoD",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userAddTodoD()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be completed some todo",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.userShouldBeCompletedSomeTodo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Pending todo count",
  "keyword": "When "
});
formatter.match({
  "location": "loginsteps1.verifyPendingTodoCount()"
});
formatter.result({
  "status": "passed"
});
});