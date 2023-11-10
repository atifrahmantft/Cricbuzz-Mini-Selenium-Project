package org.example.cricbuzz.tests;

import org.example.cricbuzz.base.BaseClass;
import org.example.cricbuzz.locators.CricBuzzPage;
import org.example.cricbuzz.locators.GooglePage;
import org.example.cricbuzz.locators.StatPage;
import org.example.cricbuzz.logger.ExtentLogger;
import org.example.cricbuzz.reports.CreateTestForEachThread;
import org.example.cricbuzz.reports.ExtentReport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class CheckStats extends BaseClass {


    @Test
    @Parameters("browser")
    public void testForMostRuns(String browser){
        ExtentReport.create_test("Test for Most Runs", browser);
        initialSetup();
        StatPage statPage = new StatPage(getDriver());
        ExtentLogger.info("moved to stat page");
        List<WebElement> most_runs = statPage.getMostRuns();

        for(int i = 0;i < 5; i++){
            WebElement item = most_runs.get(i);
            System.out.println(item.getText());

        }
        ExtentLogger.pass("test passed");
    }
    @Test
    @Parameters("browser")
    public void testForMostSixes(String browser) throws InterruptedException {
        initialSetup();
        ExtentReport.create_test("Test for most sixes", browser);
        StatPage statPage = new StatPage(getDriver());
        ExtentLogger.info("Moved to stat page");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,550)");
        ExtentLogger.info("Window Scrolled by 500 pixels");
        Thread.sleep(2000);

        statPage.clickMostSixesBtn();
        ExtentLogger.info("Clicked most sixes button");
        Thread.sleep(2000);

        List<WebElement> most_sixes = statPage.getMostSixes();
        for(int i = 0;i < 5; i++){
            WebElement item = most_sixes.get(i);
            System.out.println(item.getText());

        }
        ExtentLogger.pass("Test passed");
    }

    public void initialSetup(){
        getDriver().get("https://www.google.com/");
        GooglePage googlePage = new GooglePage(getDriver());
        CricBuzzPage cricBuzzPage = new CricBuzzPage(getDriver());

        googlePage.sendKeysToSearchField("cricbuzz");
        googlePage.clickToElement();

        cricBuzzPage.clickStatsBtn();
    }


}
