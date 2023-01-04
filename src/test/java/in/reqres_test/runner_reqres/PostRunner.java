package in.reqres_test.runner_reqres;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		features = {"src/test/resources/features/reqres_post/reqres_post.feature"},
		glue = "in.reqres_test.step_definitions_reqres"
)
public class PostRunner {
}
