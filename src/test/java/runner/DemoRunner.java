package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/sauceDemo.feature",
        glue = "stepdefinitions",
        tags = "@SAUCE-1",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)


public class DemoRunner {
}
