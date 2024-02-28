package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Featurefiles/Coursera.feature"},
		glue = "stepDefinitions",
		plugin = {"pretty" , "html:reports/myreport.html",
				"rerun:target/rerun.txt"},
		dryRun=false,
		monochrome=true,
		publish=true
		)

public class TestRunner{
	
}