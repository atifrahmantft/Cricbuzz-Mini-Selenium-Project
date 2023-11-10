package org.example.cricbuzz.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public final class CreateTestForEachThread {
    private CreateTestForEachThread(){

    }
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public static ExtentTest create_test_threads(ExtentReports extentReports, String test_case_name){
        ExtentTest test = extentReports.createTest(test_case_name);
        extentTest.set(test);
        return get_test_thread();
    }
    public static ExtentTest get_test_thread(){
        return extentTest.get();
    }
    public static void unload(){
        extentTest.remove();
    }
}
