package com.himalaya.utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentReportsListener implements ITestListener {
    // Declaration of ExtentReports and ExtentTest objects
    public ExtentReports extent;
    public ExtentTest test;

    // Method executed at the start of the test context
    public void onStart(ITestContext context) {
        try {
            // Creating an instance of ExtentReports using ExtentManager
            extent=ExtentManager.createInstance();
        } catch (IOException e) {
            // Printing stack trace if an IOException occurs
            e.printStackTrace();
        }
    }
    
    // Method executed before each test method starts
    public void onTestStart(ITestResult result) {
        // Creating a test instance with the test method name
        test=extent.createTest(result.getName());
    }
    
    // Method executed when a test method passes
    public void onTestSuccess(ITestResult result) {
        // Logging the test status as PASS
        test.log(Status.PASS, "Test case passed");
        // Adding green label to the test name in the report
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),
                ExtentColor.GREEN));
    }
    
    // Method executed when a test method fails
    public void onTestFailure(ITestResult result) {
        // Logging the test status as FAIL
        test.log(Status.FAIL, "Test case Failed");
        // Adding red label to the test name in the report
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),
                ExtentColor.RED));
    }
    
    // Method executed when a test method is skipped
    public void onTestSkipped(ITestResult result) {
        // Logging the test status as SKIP
        test.log(Status.SKIP, "Test case SKIPPED");
        // Adding amber label to the test name in the report
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),
                ExtentColor.AMBER));
    }
    
    // Method executed at the end of the test context
    public void onFinish(ITestContext context) {
        // Flushing the ExtentReports instance
        extent.flush();
    }
}