package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Hooks 
{
    private static ExtentReports extent = ExtentManager.getInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setup(Scenario scenario) 
    {
        // Start the report logger for this specific scenario
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
        
        // Start the Grid Browser
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) 
    {
        if (scenario.isFailed()) 
        {
            test.get().fail("Scenario Failed!");
        } 
        else 
        {
            test.get().pass("Scenario Passed!");
        }

        DriverFactory.quitDriver();
        extent.flush(); // Save the HTML report
    }
}