package com.himalaya.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.himalaya.utilities.FileIO;



public class ReusableFunctions {
	
	private static WebDriver driver;
	private WebDriverWait wait;
	public static Properties prop;
	public static String browser_choice;
	
	/**
     * Constructor for ReusableFunctions class.
     * @param driver The WebDriver instance to be used.
     */
	public ReusableFunctions(WebDriver driver) {
		ReusableFunctions.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prop = FileIO.getProperties();
	}

	/************** Invoke Browser ****************/
	public static WebDriver invokeBrowser() {
		if(prop==null)
		{
			prop=FileIO.getProperties();
		}
		browser_choice = prop.getProperty("browserName");
		try {
			if (browser_choice.equalsIgnoreCase("msedge")) {
				driver = DriverSetup.invokeEdgeBrowser();
			} else if (browser_choice.equalsIgnoreCase("chrome")){
				driver = DriverSetup.invokeChromeBrowser();
			} else{
				throw new Exception("Invalid browser name provided in property file");
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return driver;
	}
	
	/************** Get browser option from user ****************/
	public static int getBrowserOption() {
		int choice = 1;
		System.out
				.println("Browser options\n1 - Chrome\n2 - MS Edge \n3 - Firefox\nEnter choice: ");
		Scanner sc = new Scanner(System.in);
		
		choice = sc.nextInt();
		while (choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Invalid choice entered.");
			System.out
					.println("Browser options\n1 - Chrome\n2 - MS Edge \n3 - Firefox\nEnter choice: ");
			choice = sc.nextInt();
		}
		sc.close();
		return choice;
	}
	
	/************** Open website URL ****************/
	public void openBrowser(String websiteUrlKey) {
		if (prop == null) {
	        prop = FileIO.getProperties();
	    }
		try {
			driver.get(prop.getProperty(websiteUrlKey));

		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	/************** Get list of web elements ****************/
	public static List<WebElement> getListOfElements(By locator) {
		List<WebElement> list = null;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		list = driver.findElements(locator);
		return list;
	}
	
	/************** Check if an element is present ****************/
	public static boolean isElementPresent(By locator, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/************** Send text to an element ****************/
	public static void sendText(By locator, String text) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	
	/************** Send text to an element and click enter ****************/
	public static void sendTextAndEnter(By locator, String text,Keys enter) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).sendKeys(text,enter);

		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}


	/************** Clear Textbox ****************/
	public static void textboxClear(By locator) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).clear();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	/************** Get text of element ****************/
	public static String getText(By locator) {
		String text = null;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
			text = driver.findElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		return text;
	}
	
	/************** Click on element with locator ****************/
	public static void clickOn(By locator, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.elementToBeClickable(locator));
			driver.findElement(locator).click();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	/************** Click on element with Actions ****************/
	public static void clickAction(By locator, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.elementToBeClickable(locator));
			Actions action = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(locator));
			jse.executeScript("window.scrollBy(0,-150)");
			action.moveToElement(driver.findElement(locator)).build().perform();
//			action.click(driver.findElement(locator)).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	/************** Click on element with JavaScript ****************/
	public static void clickJS(By locator, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.elementToBeClickable(locator));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(locator));
			jse.executeScript("arguments[0].click", driver.findElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	/************** delay with locator ****************/
	public static void delay(long timeout) throws InterruptedException {

		Thread.sleep(timeout*1000);
	
	}
	
	/************** is display with locator ****************/
	public static boolean isDisplayed(By locator) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		return false;
		
	}
	
	// Method to take a screenshot and save it to the specified file path
	public void takeScreenShot(String filepath) {
		// Cast driver to TakesScreenshot interface
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		// Capture screenshot as File
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		// Specify destination file
		File destFile = new File(filepath);
		try {
			// Copy the screenshot to the destination file
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/************** Report fail test ****************/
	public static void reportFail(String reportMessage) {
		Assert.fail("Test case failed: " + reportMessage);
	}
}

