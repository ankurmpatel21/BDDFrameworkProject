package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features=".//Features//Login.feature",
		//features=".//Features//Customers.feature",
		features=".//Features//",
		glue="stepDefinitions",
		monochrome=true,
		tags = {"@Sanity"},
		plugin= {"pretty","html:test-output"}
		)
public class TestRunner 
{

}
