package testRunner;



import org.testng.annotations.*;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@CucumberOptions(
		features = {"src/test/java/features" },
		snippets = SnippetType.CAMELCASE, // for remove the underscore
		monochrome = true,
		glue = "stepDefinitions",
		tags = "@runAll"
		)

public class Runner extends AbstractTestNGCucumberTests {
	
	@BeforeClass
    public void setup() {
        System.out.println("Before running tests");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After running tests");
    }

    @Test
    public void runCucumberTests() {
        // Runs the Cucumber tests
    }
	
}
