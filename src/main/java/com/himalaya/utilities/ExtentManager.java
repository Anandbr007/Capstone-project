package com.himalaya.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	// Declaring static variables to hold ExtentReports and ExtentSparkReporter instances
    public static ExtentReports extent;
    public static ExtentSparkReporter htmlReporter;
    
    // Method to create an instance of ExtentReports
    public static ExtentReports createInstance() throws IOException {
        // Generating a unique report name with a timestamp
        String repname="TestReport-"+ getTimeStamp()+".html";
        // Creating an ExtentSparkReporter instance with the report name
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+repname);
        // Loading configuration from extent-config.xml file
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml");
        // Initializing ExtentReports
        extent = new ExtentReports();
        // Attaching ExtentSparkReporter to ExtentReports
        extent.attachReporter(htmlReporter);
        // Setting system information for the report
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User1", "Anand");
        extent.setSystemInfo("User2", "Karthik");
        extent.setSystemInfo("User3", "Sandra");
        // Returning the ExtentReports instance
        return extent;
    }
    
    // Method to get current timestamp
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
}