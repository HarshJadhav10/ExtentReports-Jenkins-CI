package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    }
)

// Before Running, In normal PowerShell Session 
// type this line :- java -jar selenium-server-4.41.0.jar standalone on normal cmd
// and open selenium grid on chrome
public class TestRunner extends AbstractTestNGCucumberTests 
{
    
    @Override
    @DataProvider(parallel = false) 
    public Object[][] scenarios() 
    {
        return super.scenarios();
    }

    // By bringing this method to the surface and tagging it with @Test,
    // VS Code's Java extension will finally "see" it and generate the Run button!
    @Override
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(io.cucumber.testng.PickleWrapper pickleWrapper, io.cucumber.testng.FeatureWrapper featureWrapper) 
    {
        super.runScenario(pickleWrapper, featureWrapper);
    }
}