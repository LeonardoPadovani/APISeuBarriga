package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty","html:target/htmlReport/cucumber-report.html","json:target/jsonReports/cucumber-report.json"},
        tags = "@regressao",
        glue = "steps",
        monochrome = true,
        dryRun = false)

public class RunnerTest {


}
