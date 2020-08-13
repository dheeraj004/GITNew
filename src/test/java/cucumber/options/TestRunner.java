package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features = "E:\\Selenium_Practice\\APITesting\\src\\test\\java\\features\\placevalidations.feature",	
	glue= {"stepDefinations"},
	//tags = {"@deletePlace"}
   plugin = "json:target/jsonReports/cucumber-report.json"
		
)
	

public class TestRunner {


}
