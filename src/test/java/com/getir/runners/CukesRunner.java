package com.getir.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml",
        "html:target/default-html-reports.html"
        },
        features = "src/test/resources/features",
        glue = "com/getir/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
