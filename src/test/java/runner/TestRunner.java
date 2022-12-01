package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/features",glue = {"stepDefinitions"},plugin = {"pretty", "html:src/test/resources/reports/cucumber.html"})

public class TestRunner {
    
}