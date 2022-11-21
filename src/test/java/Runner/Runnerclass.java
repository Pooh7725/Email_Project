package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/proudparselmouth/eclipse-workspace-3/Email_Project/src/test/java/EmailCucumberFeature/Cucumber.feature", glue = {
		"StepDef" })
public class Runnerclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
