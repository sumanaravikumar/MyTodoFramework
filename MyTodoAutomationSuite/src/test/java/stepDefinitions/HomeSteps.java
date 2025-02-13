package stepDefinitions;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.api.java.en.*;

import steps.HomePage;

public class HomeSteps {

    WebDriver driver;
    WebDriverWait wait;
    
    private String url="https://todomvc.com/examples/react/dist/";

    // Method to generate random names
    public static String generateRandomName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder name = new StringBuilder();
        Random random = new Random();
        int length = random.nextInt(3) + 3; // Length between 3 to 5
        for (int i = 0; i < length; i++) {
            name.append(characters.charAt(random.nextInt(characters.length())));
        }
        return name.toString();
    }
    public static String generateRandomTicket() {
        String ticketPrefix = "TICKET:New Feature- ";
        String randomText = generateRandomName();
        return ticketPrefix + randomText;
    }
    @Given("User lands in the home page of application")
    public void User_lands_in_the_home_page_of_application() throws Exception {
    
        System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        wait = new WebDriverWait(driver, 10);  // Initializing WebDriverWait
        Assert.assertEquals(driver.getTitle(), "TodoMVC: React","Application launch unsuccessful");
        Thread.sleep(1000);

    }

    @When("User keys in todoName and press Enter")
    public void enterTodoName() throws InterruptedException {
       driver.findElement(By.xpath(HomePage.todoInput)).sendKeys(generateRandomTicket());
       driver.findElement(By.xpath(HomePage.todoInput)).sendKeys(Keys.ENTER);
       Thread.sleep(1000);


    }
    
    @When("User keys in multiple todoNames and press Enter")
    public void enterMultipleTodoName() throws InterruptedException {
    	int count=4;
    	for (int i=0; i<count;i++) {
       driver.findElement(By.xpath(HomePage.todoInput)).sendKeys(generateRandomTicket());
       driver.findElement(By.xpath(HomePage.todoInput)).sendKeys(Keys.ENTER);
       Thread.sleep(2000);
    	}
    }

    @When("Verify Todo is added successfully")
    public void verifyGeneratedTodoName() {
    	String var = driver.findElement(By.className(HomePage.todoCount)).getText();
    	int todoCount = Integer.parseInt(var.replaceAll("[^0-9]", ""));
    	Assert.assertEquals(todoCount, 1,"Addition of todo unsuccessful");
    	String createdTodo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(HomePage.createdTodo))).getText();
        System.out.println("Todo added successfully: " + createdTodo);
        driver.quit();
    }
    
    @When("Verify multiple Todos are added successfully")
    public void verifyMultipleTodoNames() {
    	String var = driver.findElement(By.className(HomePage.todoCount)).getText();
    	int todoCount = Integer.parseInt(var.replaceAll("[^0-9]", ""));
    	Assert.assertEquals(todoCount, 4,"Addition of todo unsuccessful");
        List<WebElement> createdTodos = driver.findElements(By.cssSelector(HomePage.createdTodo));
        for(WebElement todo : createdTodos) {
        	String createdTodoName = todo.getText();
            System.out.println("Todo added successfully: " + createdTodoName);
        }
        driver.quit();
    }

      @When("User mark todo as completed")
    public void userMarkTodoCompleted() throws Exception {
        Thread.sleep(1000);
        String var = driver.findElement(By.className(HomePage.todoCount)).getText();
      	int todoCount = Integer.parseInt(var.replaceAll("[^0-9]", ""));
      	Assert.assertEquals(todoCount, 4,"Todo count mismatch");
        Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.xpath(HomePage.todoCheckBox))).click().perform();
        driver.findElement(By.xpath(HomePage.completedBtn)).click();
        Thread.sleep(1000);
      }
      
      @And("Verify count of pending task")
      public void verifyPendingTaskCount() {
      	String var = driver.findElement(By.className(HomePage.todoCount)).getText();
      	int todoCount = Integer.parseInt(var.replaceAll("[^0-9]", ""));
      	Assert.assertEquals(todoCount, 3,"Todo count mismatch");
          driver.quit();
      }


      @Then("User delete Todo")
      public void deleteTodo() throws InterruptedException {
    		String var = driver.findElement(By.className(HomePage.todoCount)).getText();
          	int todoCount = Integer.parseInt(var.replaceAll("[^0-9]", ""));
          	Assert.assertEquals(todoCount, 4,"Todo count mismatch");
    	  Actions actions = new Actions(driver);
          actions.moveToElement(driver.findElement(By.xpath(HomePage.todoLabel))).perform();

    	  driver.findElement(By.xpath(HomePage.deleteTodoBtn)).click();
          Thread.sleep(1000);

      }
    
      @Then("User click on Clear Completed button")
      public void clickClearCompleted() throws InterruptedException {
    	  driver.findElement(By.xpath(HomePage.clearCompletedBtn)).click();
          Thread.sleep(1000);
      	}
      
      @And("Verify todo removal from the list")
      public void verifyTodoListSize() throws InterruptedException {

      	int totalTodos = driver.findElements(By.xpath(HomePage.pendingTodoList)).size();
      	Assert.assertEquals(totalTodos, 0,"Todo is not removed from the list");
      	Thread.sleep(1000);
      	driver.quit();
      }
 
      @Then("User click on Active button and verify count")
      public void clickActiveBtn() throws InterruptedException {
    	  driver.findElement(By.xpath(HomePage.activeBtn)).click();
          Thread.sleep(1000);
          String var = driver.findElement(By.className(HomePage.todoCount)).getText();
        	int todoCount = Integer.parseInt(var.replaceAll("[^0-9]", ""));
        	int totalTodos = driver.findElements(By.xpath(HomePage.pendingTodoList)).size();
          	Assert.assertEquals(totalTodos, todoCount,"Mismatch found in verifying active todos");
          	driver.quit();
        	
          

    	  
      }
       
    
    
//   
//    @When("User delete todo")
//    public void userDeleteTodo() throws Exception {
//     Thread.sleep(3000);
//    	 WebElement elementToHover =driver.findElement(By.xpath("//li[1]//div[1]//label[1]"));
//
//         // Use Actions class to hover
//         Actions actions = new Actions(driver);
//         actions.moveToElement(elementToHover).perform(); // Hover action
//
//         WebElement Tcount1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("todo-count")));
//         String text = Tcount1.getText(); // Example: "10 items left"
//         int TodocountB = Integer.parseInt(text.replaceAll("[^0-9]", ""));
//         Thread.sleep(2000);
//
//    	WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//div[1]//button[1]")));
//    delete.click();
//
//    WebElement Tcount2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("todo-count")));
//    String text2 = Tcount2.getText(); // Example: "10 items left"
//    int TodocountA = Integer.parseInt(text2.replaceAll("[^0-9]", ""));
//  
//    System.out.println("Before todo" +(((TodocountB))) + " -  After todo " + (((TodocountA))) + " = Reduce By :-" + ((TodocountB - TodocountA)));
//    System.out.println("3st Step Result Pass :- Todo deleted and reduce by 1" );
//  
//    Thread.sleep(3000);
//   driver.quit();
//    }
//     
//    
//    
////--------------------------------5nd scenario    
//    
//    
//    @Given("User Navigatev to the todo websiteB")
//    public void userNavigatevToTheTodoWebsiteB() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver-win64\\chromedriver.exe");
//      	driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.navigate().to("https://todomvc.com/examples/react/dist/");
//      	System.out.println("1st Step Result Pass :- Web Launch");
//      	 wait = new WebDriverWait(driver, 10);    	
//         Thread.sleep(3000);
//
//    }
//    
//    
//    
//    
//    @When("User add todoB")
//    public void userAddTodoB() {
//  	for (int i = 0; i < 4; i++) {  // Loop to create 4 todos
//            String randomName = generateRandomName();  // Generate a unique name for each todo
//            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='todo-input']")));
//            field.sendKeys(randomName);
//            field.sendKeys(Keys.ENTER);
//
//    }
//    	
//	       Actions actions = new Actions(driver);
//	       WebElement compAll = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/main[1]/div[1]/input[1]"));
//	       actions.moveToElement(compAll).click().perform();
//	
//  	
//  	
//        for (int i = 0; i < 7; i++) {  // Loop to create 4 todos
//            String randomName = generateRandomName();  // Generate a unique name for each todo
//            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='todo-input']")));
//            field.sendKeys(randomName);
//            field.sendKeys(Keys.ENTER);
//        }        
//        System.out.println("2st Step Result Pass :- Todo added"); 
//    }
//    
//     
//    @When("Verify completed todo count")
//    public void verifyCompletedTodoCount() throws Exception {
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/section[1]/footer[1]/ul[1]/li[3]/a[1]"))).click();
//    	List<WebElement> checkedItems = driver.findElements(By.xpath("//ul[@class='todo-list']/li[contains(@class,'completed')]"));
//    	
//    			int checkedCount = checkedItems.size();
//    	System.out.println("Count of Completed todo :- " +( checkedCount));
//        System.out.println("3rd Step Result Pass :- Count successful of Completed todo "); 
//    	
//        Thread.sleep(3000);
//        driver.quit();
//
//        }
//    
//    
//    
//    
//    
//    
////-----------    --------------------- 6th Scenario-------------------------------
//    
//    
//    
//    
//    
//    @Given("User Navigatev to the todo websiteC")
//    public void userNavigatevToTheTodoWebsiteC() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver-win64\\chromedriver.exe");
//        	driver = new ChromeDriver();
//           driver.manage().window().maximize();
//           driver.navigate().to("https://todomvc.com/examples/react/dist/");
//         	System.out.println("1st Step Result Pass :- Web Launch");
//        	 wait = new WebDriverWait(driver, 10);
//        	    Thread.sleep(3000);
//
//    	
//    	
//        }
//
//    @When("User add todoC")
//    public void userAddTodoC() {
//    	
//    	for (int i = 0; i < 5; i++) {  // Loop to create 4 todos
//            String randomName = generateRandomName();  // Generate a unique name for each todo
//            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='todo-input']")));
//            field.sendKeys(randomName);
//            field.sendKeys(Keys.ENTER);
//
//        }
//    	
////  	Actions actions = new Actions(d);
////	WebElement checkbox = d.findElement(By.xpath("//li[2]//div[1]//input[1]"));
////	actions.moveToElement(checkbox).click().perform();
////  	
//	Actions actions = new Actions(driver);
//	WebElement compAll = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/main[1]/div[1]/input[1]"));
//	actions.moveToElement(compAll).click().perform();
//	
//  	
//  	
//        for (int i = 0; i < 11; i++) {  // Loop to create 4 todos
//            String randomName = generateRandomName();  // Generate a unique name for each todo
//            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='todo-input']")));
//            field.sendKeys(randomName);
//            field.sendKeys(Keys.ENTER);
//        }
//        System.out.println("2st Step Result Pass :- Todo added"); 
//
//    	
//      }
//
//    @When("Verify the all tab todo count")
//    public void verifyTheAllTabTodoCount() throws Exception {
//      
//    
//    	List<WebElement> allTodos = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
//    	int totalTodos = allTodos.size();
//    	System.out.println("Total To-Do in all tab:- " + (totalTodos));
//        System.out.println("3rd Step Result Pass :- Count successful of All todo"); 
//        Thread.sleep(3000);
//
//    driver.quit();
//    
//    }  
//    
//    
//    
//    
//    
// //----------------------------------------7th Scenarios
//    
//    
//    
//    @Given("User Navigatev to the todo websiteD")
//    public void userNavigatevToTheTodoWebsiteD() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\chromedriver-win64\\chromedriver.exe");
//    	driver = new ChromeDriver();
//       driver.manage().window().maximize();
//       driver.navigate().to("https://todomvc.com/examples/react/dist/");
//    	System.out.println("1st Step Result Pass :- Web Launch");
//    	 wait = new WebDriverWait(driver, 10);
//    	    Thread.sleep(3000);
//
//         
//    }
//
//    @When("User add todoD")
//    public void userAddTodoD() {
//    	for (int i = 0; i < 5; i++) {  // Loop to create 4 todos
//            String randomName = generateRandomName();  // Generate a unique name for each todo
//            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='todo-input']")));
//            field.sendKeys(randomName);
//            field.sendKeys(Keys.ENTER);
//
//        }	
//    	 Actions actions = new Actions(driver);
//     	WebElement compAll = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/main[1]/div[1]/input[1]"));
//     	actions.moveToElement(compAll).click().perform();
//        System.out.println("2st Step Result Pass :- Todo added"); 
//
//         
//    }
//
//    @When("User should be completed some todo")
//    public void userShouldBeCompletedSomeTodo() {
//    	
//      	
//      	
//            for (int i = 0; i < 11; i++) {  // Loop to create 4 todos
//                String randomName = generateRandomName();  // Generate a unique name for each todo
//                WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='todo-input']")));
//                field.sendKeys(randomName);
//                field.sendKeys(Keys.ENTER);
//            }
//            System.out.println("3rd Step Result Pass :- Todo Marked completed "); 
//
//    }
//
//    
//    
//    
//    @When("Verify Pending todo count")
//    public void verifyPendingTodoCount() throws Exception {
//         
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@class='footer']//li[2]"))).click();
//    	List<WebElement> allTodos = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
//    	int totalTodos = allTodos.size();
//    	System.out.println("Total To-Do Pending items -: " + (totalTodos));
//        System.out.println("4rd Step Result Pass :- Count successful of pending todo "); 
//        Thread.sleep(3000);
//
//driver.quit();
//    }
//  
    
}







                   
