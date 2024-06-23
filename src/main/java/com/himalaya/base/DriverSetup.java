package com.himalaya.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetup {

	private static WebDriver driver;
	
	//invoke chrome browser
	/**
     * Invokes the Chrome browser with specific options.
     *
     * @return WebDriver instance for Chrome browser
     */
	public static WebDriver invokeChromeBrowser() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
	    options.addArguments("--start-maximized");
	    driver = new ChromeDriver(options);
	    return driver;
	}
	
	//invoke edge browser
	/**
     * Invokes the Edge browser with specific options.
     *
     * @return WebDriver instance for Edge browser
     */
	public static WebDriver invokeEdgeBrowser() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("guest");
		driver = new EdgeDriver(options);
		return driver;
	}
}
