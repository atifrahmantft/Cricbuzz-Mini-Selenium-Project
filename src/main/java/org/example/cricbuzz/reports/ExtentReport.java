package org.example.cricbuzz.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.cricbuzz.config.GetConfigProperties;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport(){

    }
    private static ExtentReports extentReports;
    private static ExtentTest test;

    public static void initReports() throws IOException {
        if(Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("src/main/java/" +
                    "org.example.cricbuzz/reports/spark.html");

            extentReports.attachReporter(spark);
            GetConfigProperties.getProperties();
        }
    }

    public static void flushReports(){
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File("src/main/java/org.example.cricbuzz/reports/spark.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void create_test(String test_case_name, String browser){
        test =  CreateTestForEachThread.create_test_threads(extentReports, test_case_name).assignCategory(browser);
    }
}
