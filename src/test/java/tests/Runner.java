package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty","html:target/htmlReport/cucumber-report.html"},
        tags = "@regressao",
        glue = "steps",
        monochrome = true,
        dryRun = false)

public class Runner {


}
