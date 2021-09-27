package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/Smoke.feature",
        glue = "stepDefinitions",
        stepNotifications = true,
        //tags = "@SmokeTest49", //To run test set
        //dryRun = true,    //To see methods that need implementation and others statistics, It does not show windows
        plugin = {"pretty", "html:target/reports/cucumber.html", //Html file with sample report
                "json:target/reports/cucumber.json", //Json file to generate report
                "junit:target/reports/cukes.xml"})   //Xml file to generate report

public class TestRunner {
}
