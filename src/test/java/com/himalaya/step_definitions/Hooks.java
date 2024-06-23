package com.himalaya.step_definitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.himalaya.base.ReusableFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static WebDriver driver;
	public ReusableFunctions reusableFunctions;
	private ExtentReports extent;
	private ExtentTest test;

	/**
	 * Method to initialize the browser and Extent report before each scenario.
	 */
	@Before
	public void openBrowser() {
		driver = ReusableFunctions.invokeBrowser();
		reusableFunctions = new ReusableFunctions(driver);
		reusableFunctions.openBrowser("SiteURL");

		//Initialize the Extent reports with the HTML reporter
		String repname = "CucumberReport" + getTimeStamp() + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//CucumberReports//" + repname);
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		// Create a new test
		test = extent.createTest("HimalayaWellness");
	}

	/**
	 * Method to generate timestamp.
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	
	/**
	 * Method to take a screenshot and add it to the Extent report after each scenario.
	 */
	 @After
	    public void closeBrowser(){
	    	//taking the screenshot after every test
	    			java.io.File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    			try {
	    				Date d1 = new Date();
	    				FileUtils.copyFile(screenshotfile, new File("CucumberScreenshots/"+ d1.getTime()+ "ss.jpg"));
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        //Take the screenshot
	        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        //Add it to the report
	        test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
	        test.pass("Test passed");
	        extent.flush();
	      driver.quit();
	    }

}
