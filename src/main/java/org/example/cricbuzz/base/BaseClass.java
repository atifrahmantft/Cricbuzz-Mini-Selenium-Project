package org.example.cricbuzz.base;

import org.example.cricbuzz.reports.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return dr.get();
    }

    @BeforeSuite
    public void beforeSuite() throws IOException {
        ExtentReport.initReports();
    }
    @AfterSuite
    public void afterSuite(){
        ExtentReport.flushReports();
    }


    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(" http://localhost:4444"), options);
        }
        else if(browser.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(new URL(" http://localhost:4444"), options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dr.set(driver);

    }
    @AfterMethod
    public void tearDown(){
        dr.get().quit();
        dr.remove();
    }
}
