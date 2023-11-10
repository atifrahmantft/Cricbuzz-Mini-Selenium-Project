package org.example.cricbuzz.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Utilities {
    public static void zooming_out() throws AWTException, InterruptedException {

        Robot robot =  new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);
        Thread.sleep(3000);

    }

    public static void takeScreenShot(WebDriver driver) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));

    }
}
