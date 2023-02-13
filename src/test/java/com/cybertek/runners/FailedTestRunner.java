package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "@target/rerun.txt",
        glue="src/test/resources/features",
        tags="@wikiScenarioOutline"

)
    public class FailedTestRunner{

}