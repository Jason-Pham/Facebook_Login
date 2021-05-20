package _runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import helpers.Hooks;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@WebUI",
        plugin = {"pretty", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/Facebook-reports/report.html"},
        glue = "step_definitions")

public class TestRunner extends Hooks {
    @Test
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}

