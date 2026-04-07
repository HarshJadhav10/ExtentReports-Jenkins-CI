package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.URL;

public class DriverFactory 
{
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() 
    {
        try 
        {
            ChromeOptions options = new ChromeOptions();
            
            // THIS IS THE LINE YOU NEED FOR JENKINS:
            options.addArguments("--headless=new"); 
            
            // Connects to your Standalone Grid!
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), options));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() 
    {
        return driver.get();
    }

    public static void quitDriver() 
    {
        if (getDriver() != null) 
        {
            getDriver().quit();
            driver.remove();
        }
    }
}