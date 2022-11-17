package CucimberRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/proudparselmouth/eclipse-workspace-3/Email_Project/src/test/java/Cucumberfeature/login.feature", glue = {
		"StepDef" }

)

public class RunnerExecution {

	public static void main(String[] args) {

	}

}
