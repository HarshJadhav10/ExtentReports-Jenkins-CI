package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import hooks.Hooks; 
import org.testng.Assert;

public class LoginSteps 
{

    WebDriver driver;

    @Given("user opens the browser")
    public void openBrowser() 
    {
        driver = DriverFactory.getDriver();
        Hooks.test.get().info("Browser retrieved from Grid successfully");
    }

    @When("user navigates to {string}")
    public void navigateTo(String url) 
    {
        driver.get(url);
        Hooks.test.get().info("Navigated to URL: " + url);
    }

    @Then("page title should contain {string}")
    public void validateTitle(String expected) 
    {
        boolean isMatch = driver.getTitle().contains(expected);
        Hooks.test.get().info("Validating title contains: " + expected);
        Assert.assertTrue(isMatch);
    }
}