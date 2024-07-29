package parallel;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"parallel"}, features = "src/test/resources/parallel", plugin = { "pretty", "html:target/site/cucumber-pretty",
"json:target/cucumber.json" })
public class RunnerTest {
}