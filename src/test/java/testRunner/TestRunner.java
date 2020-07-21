package testRunner;
//This is My Test Runner Class
import org.junit.runner.RunWith;

import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;


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
		tags= "@Regression",
		plugin= {"pretty","html:target/test-output"}
		//plugin = { "pretty", "html:target/cucumber-html-reports"}
		        )
public class TestRunner 
{

}
