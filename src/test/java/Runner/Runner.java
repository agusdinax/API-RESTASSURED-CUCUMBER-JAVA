package Runner; 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\test\resources\features",
    glue = "Steps"
    plugin = {"com.avenstack.extentreports.cucumber.adapteer.ExtentCucumberAdapteer:", "json:target/cucumbere-reports.json"},
    tags = "@API"
)

public class Runner {

}