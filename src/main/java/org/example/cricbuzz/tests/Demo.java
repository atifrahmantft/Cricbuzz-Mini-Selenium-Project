package org.example.cricbuzz.tests;

import org.example.cricbuzz.base.BaseClass;
import org.example.cricbuzz.logger.ExtentLogger;
import org.example.cricbuzz.reports.CreateTestForEachThread;
import org.example.cricbuzz.reports.ExtentReport;
import org.example.cricbuzz.utilities.Utilities;
import org.example.cricbuzz.locators.CricBuzzPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Demo extends BaseClass {

    @Test
    @Parameters("browser")
    public void test1(String browser) throws InterruptedException, AWTException, IOException {

        getDriver().get("https://www.cricbuzz.com/");
        ExtentReport.create_test("Test for clicking screenshot and zooming out", browser);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CricBuzzPage cricBuzzPage = new CricBuzzPage(getDriver());

        cricBuzzPage.clickWebElement();
        cricBuzzPage.scrollScreen();
        ExtentLogger.info("Screen scrolled");

        Utilities.zooming_out();
        ExtentLogger.info("Zooming out succesful");
        Utilities.takeScreenShot(getDriver());
        ExtentLogger.info("Screenshot clicked");
        ExtentLogger.pass("Test passed successfully");
    }

}
