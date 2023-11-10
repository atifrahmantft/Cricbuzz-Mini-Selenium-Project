package org.example.cricbuzz.tests;

import org.example.cricbuzz.base.BaseClass;
import org.example.cricbuzz.locators.CricBuzzPage;
import org.example.cricbuzz.logger.ExtentLogger;
import org.example.cricbuzz.reports.CreateTestForEachThread;
import org.example.cricbuzz.reports.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckBrokenLinks extends BaseClass {

    @Test
    @Parameters("browser")
    public void test1(String browser) throws InterruptedException {
        CricBuzzPage cricBuzzPage = new CricBuzzPage(getDriver());
        getDriver().get("https://www.cricbuzz.com/");
        cricBuzzPage.clickMatchesBtn();
        Thread.sleep(3000);
        ExtentReport.create_test("Test for checking broken links", browser);
        List<WebElement> links = getDriver().findElements(By.xpath("//a[@class='cb-nav-tab']//following::a"));
        List<String> broken_links = new ArrayList<>();
        int broken_link_count = 0, success_link_count = 0, void_link_counts = 0;
        ExtentLogger.pass("Enter the matches section");
        for(WebElement link : links){
            String url = link.getAttribute("href");

            try{
                URL test_url = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) test_url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();


                if(httpURLConnection.getResponseCode() < 400){
                    success_link_count++;
                }
                else{
                    broken_links.add(url);
                    broken_link_count++;
                }
            } catch (Exception e) {
                void_link_counts++;
            }

        }
        ExtentLogger.info("count of success links " + success_link_count);
        ExtentLogger.info("count of void links " + void_link_counts);
        ExtentLogger.info("count of broken links " + broken_link_count);

        for(String link : broken_links){
            System.out.println(link);
        }
    }
}
