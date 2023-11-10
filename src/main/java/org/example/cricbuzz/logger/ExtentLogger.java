package org.example.cricbuzz.logger;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.cricbuzz.base.BaseClass;
import org.example.cricbuzz.config.GetConfigProperties;
import org.example.cricbuzz.reports.CreateTestForEachThread;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {

    private ExtentLogger(){

    }
    public static void pass(String message){
        if(GetConfigProperties.isScreenShotNeeded("pass")){
            CreateTestForEachThread.get_test_thread().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(
                            ((TakesScreenshot) BaseClass.getDriver())
                                    .getScreenshotAs(OutputType.BASE64)
                    ).build());
        }
    }

    public static void fail(String message){
        if(GetConfigProperties.isScreenShotNeeded("fail")){
            CreateTestForEachThread.get_test_thread().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(
                            ((TakesScreenshot) BaseClass.getDriver())
                                    .getScreenshotAs(OutputType.BASE64)
                    ).build());
        }
    }

    public static void skip(String message){
        if(GetConfigProperties.isScreenShotNeeded("skip")){
            CreateTestForEachThread.get_test_thread().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(
                            ((TakesScreenshot) BaseClass.getDriver())
                                    .getScreenshotAs(OutputType.BASE64)
                    ).build());
        }
    }

    public static void info(String message){
        CreateTestForEachThread.get_test_thread().info(message);
    }
}
