package org.example.cricbuzz.tests;


import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        Actions action = new Actions(driver);

        driver.get("https://www.google.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchField = driver.findElement(By.cssSelector("textarea#APjFqb"));

        searchField.sendKeys("cricbuzz" + Keys.ENTER);
        Thread.sleep(3000);

        WebElement cricBuzzElement = driver.findElement(By.xpath("//h3[contains(text(), \"Cricbuzz\")]"));
        cricBuzzElement.click();

        WebElement table = driver.findElement(By.xpath("//a[contains(text(), 'table')]"));
        table.click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(3000);

        Robot robot =  new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);
        Thread.sleep(3000);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));

        driver.quit();
    }

}