package testRunner;
//This is My Test Runner Class
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features=//"Features//Login.feature",
		"Features//SearchBox.feature",
		//features=".//Features//Customers.feature",
		//features=".//Features//",
		//"Features//Customers.feature",
		glue="stepDefinitions",
		monochrome=true,
		//tags = {"@Sanity", "@Regression"}, //And
		//tags={"@Sanity,@Regression"}, //Or
		tags= {"@Regression"},
		plugin= {"pretty","html:target/test-output"}
		)
public class TestRunner 
{

}
