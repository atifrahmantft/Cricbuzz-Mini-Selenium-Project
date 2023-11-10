package org.example.cricbuzz.tests;

import org.checkerframework.checker.units.qual.C;
import org.example.cricbuzz.base.BaseClass;
import org.example.cricbuzz.locators.CricBuzzPage;
import org.example.cricbuzz.locators.RankingsPage;
import org.example.cricbuzz.logger.ExtentLogger;
import org.example.cricbuzz.reports.CreateTestForEachThread;
import org.example.cricbuzz.reports.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class CheckRankings extends BaseClass {

    @Test
    @Parameters("browser")
    public void rankingTest(String browser){
        getDriver().get("https://www.cricbuzz.com/");
        ExtentReport.create_test("Test for checking rankings", browser);
        CricBuzzPage cricBuzzPage = new CricBuzzPage(getDriver());
        RankingsPage rankingsPage = new RankingsPage(getDriver());

        WebElement element = cricBuzzPage.getRankingDropDown();
        Actions ac = new Actions(getDriver());
        ac.moveToElement(element).build().perform();

        ExtentLogger.info("hovering dropdown");
        //a[contains(text(),"Rankings")]
        //"//nav/a[text()=\"ICC Rankings - Men\"]"
        WebElement dropDownElement = getDriver().findElement(By.xpath("//nav/a[text()='ICC Rankings - Men']"));
        dropDownElement.click();

        ExtentLogger.info("moved to ranking page");
        rankingsPage.clickTeamsTab();

        rankingsPage.clickTeamsT20Tab();

        ExtentLogger.info("clicked the T20 ranking page for teams");

        List<String> ranking_T20 = rankingsPage.getRankingT20Page();
        for(String i :ranking_T20){
            System.out.println(i);
        }
        ExtentLogger.pass("Test passed");
    }


}
