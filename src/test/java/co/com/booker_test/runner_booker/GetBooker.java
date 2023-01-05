package co.com.booker_test.runner_booker;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		features = {"src/test/resources/features/booker/booker_get.feature"},
		glue = "co.com.booker_test.step_definitions_booker"
)
public class GetBooker {
}
